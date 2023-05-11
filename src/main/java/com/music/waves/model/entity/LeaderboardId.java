package com.music.waves.model.entity;

import java.io.Serializable;

public class LeaderboardId implements Serializable {
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

    private Integer trackID;
    private Integer playerID;
}
