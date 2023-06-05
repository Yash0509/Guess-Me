package com.example.guess.me.repository;

import com.example.guess.me.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Player,Integer> {
}