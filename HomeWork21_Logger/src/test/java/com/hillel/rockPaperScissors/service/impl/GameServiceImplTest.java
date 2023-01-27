package com.hillel.rockPaperScissors.service.impl;

import com.hillel.rockPaperScissors.dto.Game;
import com.hillel.rockPaperScissors.dto.HandType;
import com.hillel.rockPaperScissors.dto.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    @Test
    void startGame() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);

        Assertions.assertNotNull(game);
        Assertions.assertNotNull(game.getPlayer());
        Assertions.assertNotNull(game.getComputer());
        Assertions.assertEquals("PlayerA", game.getPlayer().getName());
    }

    @Test
    void playerHand() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);

        game.getPlayer().setHand(1);
        Assertions.assertEquals(1, game.getPlayer().getHand());
        Assertions.assertEquals("PlayerA", game.getPlayer().getName());
    }

    @Test
    void computerHand() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);
        gs.computerHand(game);
        int compHand = game.getComputer().getHand();
        Assertions.assertTrue(compHand >= 1 && compHand <=3);
    }

    @Test
    void showHand() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);
        game.getPlayer().setHand(1);
        Assertions.assertEquals(HandType.ROCK, gs.showHand(game.getPlayer().getHand()));
        game.getPlayer().setHand(2);
        Assertions.assertEquals(HandType.PAPER, gs.showHand(game.getPlayer().getHand()));
        game.getPlayer().setHand(3);
        Assertions.assertEquals(HandType.SCISSORS, gs.showHand(game.getPlayer().getHand()));
        game.getPlayer().setHand(0);
        Assertions.assertEquals(HandType.WRONG_VALUE, gs.showHand(game.getPlayer().getHand()));
    }

    @Test
    void showWinner() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);

        game.getPlayer().setHand(1);
        game.getComputer().setHand(1);
        Assertions.assertEquals("Draw", gs.showWinner(game));
        game.getPlayer().setHand(2);
        game.getComputer().setHand(2);
        Assertions.assertEquals("Draw", gs.showWinner(game));
        game.getPlayer().setHand(3);
        game.getComputer().setHand(3);
        Assertions.assertEquals("Draw", gs.showWinner(game));

        game.getPlayer().setHand(3);
        game.getComputer().setHand(1);
        Assertions.assertEquals("Computer", gs.showWinner(game));
        game.getPlayer().setHand(1);
        game.getComputer().setHand(2);
        Assertions.assertEquals("Computer", gs.showWinner(game));
        game.getPlayer().setHand(2);
        game.getComputer().setHand(3);
        Assertions.assertEquals("Computer", gs.showWinner(game));

        game.getPlayer().setHand(1);
        game.getComputer().setHand(3);
        Assertions.assertEquals("Player", gs.showWinner(game));
        game.getPlayer().setHand(2);
        game.getComputer().setHand(1);
        Assertions.assertEquals("Player", gs.showWinner(game));
        game.getPlayer().setHand(3);
        game.getComputer().setHand(2);
        Assertions.assertEquals("Player", gs.showWinner(game));

    }

    @Test
    void increaseScore() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);

        gs.increaseScore(game, "draw");
        Assertions.assertEquals(1, game.getPlayer().getNumberOfGames());
        gs.increaseScore(game, "player");
        Assertions.assertEquals(2, game.getPlayer().getNumberOfGames());
        Assertions.assertEquals(1, game.getPlayer().getNumberOfWinGames());
        gs.increaseScore(game, "computer");
        Assertions.assertEquals(3, game.getPlayer().getNumberOfGames());
        Assertions.assertEquals(1, game.getPlayer().getNumberOfWinGames());
        Assertions.assertEquals(1, game.getPlayer().getNumberOfLose());
    }

    @Test
    void showResult() {
        Player playerA = new Player().setName("PlayerA");
        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(playerA);

        Assertions.assertEquals("PlayerA", game.getPlayer().getName());
        Assertions.assertEquals(0, game.getPlayer().getNumberOfGames());
        Assertions.assertEquals(0, game.getPlayer().getNumberOfLose());
        Assertions.assertEquals(0, game.getPlayer().getNumberOfWinGames());

        game.getPlayer().setNumberOfGames(5);
        game.getPlayer().setNumberOfLose(2);
        game.getPlayer().setNumberOfWinGames(3);
        Assertions.assertEquals(5, game.getPlayer().getNumberOfGames());
        Assertions.assertEquals(2, game.getPlayer().getNumberOfLose());
        Assertions.assertEquals(3, game.getPlayer().getNumberOfWinGames());

        String testStr = "Player : PlayerA win 3 games and lose 2 games from 5 total games.";
        Assertions.assertEquals(testStr, gs.showResult(game));
    }
}