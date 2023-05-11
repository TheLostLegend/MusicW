package com.music.waves.service;

import com.music.waves.model.entity.Leaderboard;
import com.music.waves.model.entity.LeaderboardALTER;
import com.music.waves.model.entity.Track;

import java.util.List;

public interface LeaderboardService {
    public List<LeaderboardALTER> getLeaderboardsByTitle(String title);
}
