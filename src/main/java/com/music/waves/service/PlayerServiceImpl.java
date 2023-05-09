package com.music.waves.service;

import com.music.waves.model.entity.Player;
import com.music.waves.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository PlayerRepository;


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public boolean isPlayerExistByLogin(String login) {
        List<Player> result = PlayerRepository.findByLogin(login);
        return !result.isEmpty();
    }

    @Override
    public boolean isPlayerExistByID(Integer id) {
        List<Player> result = PlayerRepository.findByPlayerID(id);
        return !result.isEmpty();
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> result = PlayerRepository.findAll();
        return result;
    }

    @Override
    public boolean checkPassword(String login, String password) {
        Player customer = PlayerRepository.findByLogin(login).get(0);
        return customer.getPassword().equals(password);
    }

    @Override
    public Player createPlayer(Player Player){

        if(!PlayerRepository.findByLogin(Player.getLogin()).isEmpty()){
            throw new ResourceNotFoundException("Login taken");
        }

        return PlayerRepository.save(Player);
    }
    @Override
    public Player getPlayerByID(Integer id) {
        Player customer = PlayerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
        return customer;
    }
    @Override
    public Integer getPlayerIDByLogin(String login){
        return PlayerRepository.findByLogin(login).get(0).getPlayerID();
    }

    @Override
    public Player resetPassword(String email){
        Player customer = PlayerRepository.findByEmail(email).get(0);

        if (customer.getEmail() == null){
            throw new ResourceNotFoundException("Where no customers with email : " + email);
        }

        int leftLimit = 65;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer;
        buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String newPas = buffer.toString();

        customer.setPassword(newPas);
        PlayerRepository.save(customer);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(customer.getEmail());
        mailMessage.setSubject("Reset password");
        mailMessage.setText("New password: " + newPas);

        javaMailSender.send(mailMessage);

        return customer;
    }
}
