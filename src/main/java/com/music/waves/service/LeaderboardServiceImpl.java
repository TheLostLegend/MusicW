package com.music.waves.service;

import com.music.waves.model.entity.Leaderboard;
import com.music.waves.model.entity.LeaderboardALTER;
import com.music.waves.model.entity.Track;
import com.music.waves.repository.LeaderboardRepository;
import com.music.waves.repository.PlayerRepository;
import com.music.waves.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    @Autowired
    private LeaderboardRepository leaderboardRepository;
    @Autowired
    private TrackRepository TrackRepository;
    @Autowired
    private PlayerRepository PlayerRepository;

    @Override
    public List<LeaderboardALTER> getLeaderboardsByTitle(String title) {
        List<Track> trackList = TrackRepository.findByTitleAndAdditionalWord(title);
        List<Leaderboard> leaderboardList = new ArrayList<>();
        List<LeaderboardALTER> leaderboardAList = new ArrayList<>();
        for (Track elem: trackList) {
            leaderboardList.addAll(leaderboardRepository.findByTrackID(elem.getTrackID()));
        }
        for (Leaderboard elem:leaderboardList){
            String title1 = TrackRepository.findByTrackID(elem.getTrackID()).get(0).getTitle();
            String playerName = PlayerRepository.findByPlayerID(elem.getPlayerID()).get(0).getLogin();
            leaderboardAList.add(new LeaderboardALTER(title1,playerName , elem.getScore()));
        }
        return leaderboardAList;
    }

    @Override
    public Leaderboard createLeaderboard(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    @Override
    public Leaderboard updateLeaderboard(Leaderboard leaderboard) {
        List<Leaderboard> leaderboardList = leaderboardRepository.findByTrackIdAndPlayerId(leaderboard.getTrackID(), leaderboard.getPlayerID());
        if (leaderboardList.get(0).getScore() == null){
            throw new ResourceNotFoundException("There is no leaderboards");
        }
        if (leaderboardList.get(0).getScore() < leaderboard.getScore())
        return leaderboardRepository.save(leaderboard);
        else return leaderboardList.get(0);
    }

    @Override
    public boolean isLeaderboardExistByID2(Integer trackID, Integer playerID) {
        List<Leaderboard> leaderboardList = leaderboardRepository.findByTrackIdAndPlayerId(trackID, playerID);
        return !leaderboardList.isEmpty();
    }

}
