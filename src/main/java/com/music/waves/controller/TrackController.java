package com.music.waves.controller;

import com.music.waves.model.Message;
import com.music.waves.model.entity.Track;
import com.music.waves.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping("/{id}")
    public Track getTrackByID(@PathVariable Integer id){
        return trackService.getTrackByID(id);
    }

    @GetMapping("/all")
    public List<Track> getTracks(){
        return trackService.getTracks();
    }

    @GetMapping("/is_exist")
    public ResponseEntity<Message> isTrackExistByTitle(@RequestParam String title){
        if (trackService.isTrackExistByTitle(title)){
            return new ResponseEntity<>(new Message("success", null),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new Message("fail", null),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Message> createTrack(@RequestBody Track track){
        Track resTrack = trackService.createTrack(track);
        return new ResponseEntity<>(new Message("success", resTrack.getTrackID()), HttpStatus.OK);
    }
}
