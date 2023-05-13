package com.music.waves.service;

import com.music.waves.model.entity.Leaderboard;
import com.music.waves.model.entity.LeaderboardALTER;
import com.music.waves.model.entity.Track;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface LeaderboardService {
    public List<LeaderboardALTER> getLeaderboardsByTitle(String title);

    public Leaderboard createLeaderboard(Leaderboard leaderboard);
    public Leaderboard updateLeaderboard(Leaderboard leaderboard);
    public boolean isLeaderboardExistByID2(Integer trackID, Integer playerID);
}
