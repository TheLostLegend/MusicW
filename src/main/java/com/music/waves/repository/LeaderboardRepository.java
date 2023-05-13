package com.music.waves.repository;

import com.music.waves.model.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
    List<Leaderboard> findByTrackID(Integer id);
    List<Leaderboard> findByTrackIDAndPlayerID(Integer trackId, Integer playerId);
}
