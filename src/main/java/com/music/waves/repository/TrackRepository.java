package com.music.waves.repository;

import com.music.waves.model.entity.Player;
import com.music.waves.model.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByTitle(String title);
    List<Track> findByTrackID(Integer id);

    @Query("SELECT t FROM Track t WHERE t.title LIKE %:title%")
    List<Track> findByTitleAndAdditionalWord(@Param("title") String title);
}
