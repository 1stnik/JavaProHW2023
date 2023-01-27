package com.hillel.rockPaperScissors.service.impl;

import com.hillel.rockPaperScissors.dto.Game;
import com.hillel.rockPaperScissors.dto.HandType;
import com.hillel.rockPaperScissors.dto.Player;

public interface GameService {

    Game startGame(Player player);

    void playerHand(Game game);

    void computerHand(Game game);

    HandType showHand(int hand);

    String showWinner(Game game);

    void increaseScore(Game game, String output);

    String showResult(Game game);

    void fileCreator(Game game, String output);

}