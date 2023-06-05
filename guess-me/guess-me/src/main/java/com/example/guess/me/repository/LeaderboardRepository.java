package com.example.guess.me.repository;

import com.example.guess.me.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update leaderboard l set l.player_score = :score where l.player_id = :Id",nativeQuery = true)
    void updateScoreById(@Param("score") int score, @Param("Id") int Id);
    @Transactional
    @Modifying
    @Query(value = "update leaderboard l set l.current_attempts = :newAttempts where l.player_id = :pId", nativeQuery = true)
    void updateCurrentAttempts(@Param("pId") int pId, @Param("newAttempts") int newAttempts);

    @Transactional
    @Query(value = "SELECT * from leaderboard l", nativeQuery = true)
    List<Leaderboard> findUserRank();
}
