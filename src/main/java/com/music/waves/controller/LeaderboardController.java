package com.music.waves.controller;

import com.music.waves.model.Message;
import com.music.waves.model.entity.LeaderboardALTER;
import com.music.waves.model.entity.Track;
import com.music.waves.service.LeaderboardService;
import com.music.waves.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/show")
    public List<LeaderboardALTER> getLeaderboardsByTitle(@RequestParam String title){
        return leaderboardService.getLeaderboardsByTitle(title);
    }
}
