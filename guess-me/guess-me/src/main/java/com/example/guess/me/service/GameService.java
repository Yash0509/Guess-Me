package com.example.guess.me.service;

import com.example.guess.me.model.Leaderboard;
import com.example.guess.me.model.Player;
import com.example.guess.me.repository.GameRepository;
import com.example.guess.me.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    LeaderboardRepository leaderboardRepository;

     public int saveNewUser(String userName){
        int randomNumber=(int) (Math.random()*100);
        Leaderboard newPlayerRecord= new Leaderboard();
        newPlayerRecord.setName(userName);
        newPlayerRecord.setRandomNumberGenerated(randomNumber);
        newPlayerRecord.setScore(Integer.MAX_VALUE);
        newPlayerRecord.setCurrentAttempts(0);
        Leaderboard savedPlayer=leaderboardRepository.save(newPlayerRecord);
        return savedPlayer.getId();
     }

    public String verifyUserGuess(int guessNumber, int id) {
         Optional<Leaderboard> databaseEntry=leaderboardRepository.findById(id);
        if(databaseEntry==null) {
            return "Sign IN FIRST!!!!!!!";
        }
        else if (guessNumber==databaseEntry.get().getRandomNumberGenerated()) {
            int attempts=databaseEntry.get().getCurrentAttempts();
            leaderboardRepository.updateScoreById(attempts+1,id);
            List<Leaderboard> recordList = leaderboardRepository.findUserRank();
            return "Congratulation, you guessed it correct ! Your Rank is "+findUserRank(recordList,id);
        }
        else {
            int currentAttempts=databaseEntry.get().getCurrentAttempts();
            int newAttempts=currentAttempts+1;
            leaderboardRepository.updateCurrentAttempts(id,newAttempts);
            if(guessNumber<databaseEntry.get().getRandomNumberGenerated()){
                return "Guess higher than current";
            } else {
                return "Guess lower than current";
            }
        }
    }

    private String findUserRank(List<Leaderboard> recordList, int id) {
        Collections.sort(recordList);
        for(int i=0;i<recordList.size();i++){
            if (recordList.get(i).getId()==id)
                return Integer.toString(i-1);
        }
        System.out.println(recordList);
        return null;
    }
}
