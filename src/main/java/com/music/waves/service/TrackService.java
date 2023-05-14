package com.music.waves.service;

import com.music.waves.model.entity.Player;
import com.music.waves.model.entity.Track;

import java.util.List;

public interface TrackService {
    public boolean isTrackExistByTitle(String title);
    public Track getTrackByTitle(String title);
    public Track createTrack(Track track);
    public Track getTrackByID(Integer id);
    public List<Track> getTracks();
    public List<Track> getTracksByTitle(String title);
}
