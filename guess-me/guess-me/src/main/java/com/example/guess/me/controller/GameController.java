package com.example.guess.me.controller;

import com.example.guess.me.model.Leaderboard;
import com.example.guess.me.model.Player;
import com.example.guess.me.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    @Autowired
    GameService gameService;

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/start-game")
    public int startGame(@RequestParam("username") String username){
        return gameService.saveNewUser(username);
    }

//    @CrossOrigin(value = "*")
//    @PostMapping("/guess/{guessNumber}/id/{id}")
//    public String guessTheNumber(@PathVariable("guessNumber") int guessNumber,@PathVariable("id") int id){
//        return gameService.verifyUserGuess(guessNumber,id);
//    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST,value = "/guess")
    public String guessTheNumber(@RequestParam("id") int id,@RequestParam("guessNumber") int guessNumber ){
    return gameService.verifyUserGuess(guessNumber,id);
}
}
