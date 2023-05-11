package com.music.waves.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @Column(name="trackid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer trackID;

    @Column(name="title", unique = true)
    private String title;

    @Column(name="duration")
    private Duration duration = null;

    @Column(name="levelmap")
    private String levelMap = null;

    public Integer getTrackID() {
        return trackID;
    }

    public void setTrackID(Integer trackID) {
        this.trackID = trackID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(String levelMap) {
        this.levelMap = levelMap;
    }
}
