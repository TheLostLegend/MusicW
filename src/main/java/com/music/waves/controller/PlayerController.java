package com.music.waves.controller;

import com.music.waves.model.Message;
import com.music.waves.model.entity.Player;
import com.music.waves.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public Player getPlayerByID(@PathVariable Integer id){
        return playerService.getPlayerByID(id);
    }

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}/is_exist")
    public ResponseEntity<Message> isPlayerExistByID(@PathVariable Integer id){
        if (playerService.isPlayerExistByID(id)){
            return new ResponseEntity<>(new Message("success", null),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new Message("fail", null),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/is_exist")
    public ResponseEntity<Message> isPlayerExistByLogin(@RequestParam String login){
        if (playerService.isPlayerExistByLogin(login)){
            return new ResponseEntity<>(new Message("success", null),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new Message("fail", null),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/login")
    public ResponseEntity<Message> loginPlayer(@RequestParam String login, @RequestParam String password){
        if (playerService.isPlayerExistByLogin(login)){
            if (playerService.checkPassword(login, password)){
                return new ResponseEntity<>(new Message("success", playerService.getPlayerIDByLogin(login)), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(new Message("fail", null),HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<>(new Message("fail", null),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/sing_up")
    public ResponseEntity<Message> createCustomer(@RequestBody Player customer){
        Player resultCustomer = playerService.createPlayer(customer);
        return new ResponseEntity<>(new Message("success", resultCustomer.getPlayerID()), HttpStatus.OK);
    }
    @GetMapping("/reset_pas")
    public ResponseEntity<Message> resetPassword(@RequestParam String email){
        Player customer = playerService.resetPassword(email);
        return new ResponseEntity<>(new Message("success", customer.getPlayerID()), HttpStatus.OK);
    }
}
