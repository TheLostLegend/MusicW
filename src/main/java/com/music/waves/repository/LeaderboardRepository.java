package com.music.waves.repository;

import com.music.waves.model.entity.Leaderboard;
import com.music.waves.model.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
    List<Leaderboard> findByTrackID(Integer id);
    List<Leaderboard> findByTrackIdAndPlayerId(Integer trackId, Integer playerId);
}
