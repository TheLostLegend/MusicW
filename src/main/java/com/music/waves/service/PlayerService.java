package com.music.waves.service;

import com.music.waves.model.entity.Player;

import java.util.List;

public interface PlayerService {
    public boolean isPlayerExistByLogin(String login);
    public boolean isPlayerExistByID(Integer id);
    public boolean checkPassword(String login, String password);
    public Player createPlayer(Player customer);
    public Player getPlayerByID(Integer id);
    public Integer getPlayerIDByLogin(String login);
    public Player resetPassword(String email);

    public List<Player> getPlayers();
}
