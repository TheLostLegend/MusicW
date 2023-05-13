package com.music.waves.service;

import com.music.waves.model.entity.Player;
import com.music.waves.model.entity.Track;
import com.music.waves.repository.PlayerRepository;
import com.music.waves.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository TrackRepository;

    @Override
    public boolean isTrackExistByTitle(String title) {
        List<Track> result = TrackRepository.findByTitle(title);
        return !result.isEmpty();
    }

    @Override
    public List<Track> getTracks() {
        List<Track> result = TrackRepository.findAll();
        return result;
    }

    @Override
    public Track createTrack(Track track){
        return TrackRepository.save(track);
    }
    @Override
    public Track getTrackByID(Integer id) {
        Track track = TrackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Track not exist with id :" + id));
        return track;
    }


}
