package com.music.waves.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @Column(name="playerid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer playerID;

    @Column(name="login", unique = true)
    private String login;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="registerdata")
    private Timestamp registerData = null;

    @Column(name="lastlogindata")
    private Timestamp lastLoginData = null;

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterData() {
        return registerData;
    }

    public void setRegisterData(Timestamp registerData) {
        this.registerData = registerData;
    }

    public Timestamp getLastLoginData() {
        return lastLoginData;
    }

    public void setLastLoginData(Timestamp lastLoginData) {
        this.lastLoginData = lastLoginData;
    }
}
