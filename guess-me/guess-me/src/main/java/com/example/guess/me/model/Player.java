package com.example.guess.me.model;


import jakarta.persistence.*;

@Entity(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "playerId")
    private Integer Id;

    @Column(name = "playerName")
    private String name;

    @Override
    public String toString() {
        return "Player{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", currentScore=" + currentScore +
                ", highScore=" + highScore +
                '}';
    }

    @Column(name = "playerPassword")
    private String password;

    @Column(name = "playerCurrentScore")
    private Integer currentScore;

    @Column(name = "playerHighScore")
    private Integer highScore;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }
}
