package com.music.waves.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;

@Entity
@IdClass(LeaderboardId.class)
@Table(name = "leaderboard")
public class Leaderboard{
    @Id
    @Column(name="trackid")
    private Integer trackID;

    @Id
    @Column(name="playerid")
    private Integer playerID;

    @Column(name="score")
    private Integer score;

    public Integer getTrackID() {
        return trackID;
    }

    public void setTrackID(Integer trackID) {
        this.trackID = trackID;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
