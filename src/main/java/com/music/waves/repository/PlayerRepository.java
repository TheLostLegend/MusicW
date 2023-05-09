package com.music.waves.repository;

import com.music.waves.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByPlayerID(Integer id);
    List<Player> findByLogin(String login);
    List<Player> findByEmail(String email);
//    List<Player> findByCustomerType(String customerType);
}
