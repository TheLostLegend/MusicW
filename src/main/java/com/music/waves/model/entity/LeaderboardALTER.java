package com.music.waves.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class LeaderboardALTER {
    private String trackName;

    private String playerLogin;

    private Integer score;

    public LeaderboardALTER(String trackName, String playerLogin, Integer score) {
        this.trackName = trackName;
        this.playerLogin = playerLogin;
        this.score = score;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getPlayerLogin() {
        return playerLogin;
    }

    public void setPlayerLogin(String playerLogin) {
        this.playerLogin = playerLogin;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
