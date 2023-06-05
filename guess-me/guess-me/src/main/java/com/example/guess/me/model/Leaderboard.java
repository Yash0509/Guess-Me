package com.example.guess.me.model;

import jakarta.persistence.*;

@Entity(name = "leaderboard")
public class Leaderboard implements Comparable<Leaderboard> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "playerId")
    private int Id;
    @Column(name="playerName")
    private String name;
    @Column(name="playerScore")
    private int score;
    @Column(name = "randomNumberGenerated")
    private int randomNumberGenerated;
    @Column(name = "currentAttempts")
    private int currentAttempts;

    public int getCurrentAttempts() {
        return currentAttempts;
    }

    public void setCurrentAttempts(int currentAttempts) {
        this.currentAttempts = currentAttempts;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", randomNumberGenerated=" + randomNumberGenerated +
                ", currentAttempts=" + currentAttempts +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRandomNumberGenerated() {
        return randomNumberGenerated;
    }

    public void setRandomNumberGenerated(int randomNumberGenerated) {
        this.randomNumberGenerated = randomNumberGenerated;
    }

    @Override
    public int compareTo(Leaderboard o) {
        return this.score - o.getScore();
    }
}
