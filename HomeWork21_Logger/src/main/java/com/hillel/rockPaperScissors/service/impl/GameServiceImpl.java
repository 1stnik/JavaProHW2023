package com.hillel.rockPaperScissors.service.impl;

import com.hillel.rockPaperScissors.StartGame;
import com.hillel.rockPaperScissors.dto.Computer;
import com.hillel.rockPaperScissors.dto.Game;
import com.hillel.rockPaperScissors.dto.HandType;
import com.hillel.rockPaperScissors.dto.Player;
import lombok.SneakyThrows;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private static final Logger life_cycle = LoggerFactory.getLogger("stdout");
    private static final Logger save = LoggerFactory.getLogger("logger");



    @Override
    public Game startGame(Player player) {
        return new Game()
                .setPlayer(player)
                .setComputer(new Computer());
    }

    @Override
    public void playerHand(Game game) {
        game.getPlayer().setHand(StartGame.playerHand);
    }

    @Override
    public void computerHand(Game game) {
        game.getComputer().setHand(new Random().nextInt(3) + 1);
    }

    @Override
    public HandType showHand(int hand) {
        if (hand == 1) {
//            System.out.println("Player chose: " + HandType.ROCK);
            return HandType.ROCK;
        }
        else if (hand == 2) {
//            System.out.println("Player chose: " + HandType.PAPER);
            return HandType.PAPER;
        }
        else if (hand == 3) {
//            System.out.println("Player chose: " + HandType.SCISSORS);
            return HandType.SCISSORS;
        }
        life_cycle.error(HandType.WRONG_VALUE.toString());
        return HandType.WRONG_VALUE;
    }

    @Override
    public String showWinner(Game game) {
        int pIndex = game.getPlayer().getHand() - 1;
        int cIndex = game.getComputer().getHand() - 1;
        String[][] resultGame = {
                {"Draw", "Player", "Computer"},
                {"Computer", "Draw", "Player"},
                {"Player", "Computer", "Draw"}};
        String output = resultGame[cIndex][pIndex];
        life_cycle.info("Winner is : " + output);
        save.info("Round winner is : " + output);
        increaseScore(game, output);
        return output;
    }

    @Override
    public void increaseScore(Game game, String output) {
        if (output.equalsIgnoreCase("draw")) {
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
        }
        else if (output.equalsIgnoreCase("player")) {
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            game.getPlayer().setNumberOfWinGames(game.getPlayer().getNumberOfWinGames() + 1);
        } else if (output.equalsIgnoreCase("Computer")) {
            game.getPlayer().setNumberOfGames(game.getPlayer().getNumberOfGames() + 1);
            game.getPlayer().setNumberOfLose(game.getPlayer().getNumberOfLose() + 1);
        }
    }

    @Override
    public String showResult(Game game) {
        return String.format("Player : %s win %s games and lose %s games from %s total games.",
                game.getPlayer().getName(),
                game.getPlayer().getNumberOfWinGames(),
                game.getPlayer().getNumberOfLose(),
                game.getPlayer().getNumberOfGames());
    }

    @SneakyThrows
    @Override
    public void fileCreator(Game game, String output) {
        String jarPath = Paths.get("").toAbsolutePath().toString();
        String fileName = "result_" + game.getPlayer().getName() + "_" +
                new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()) + ".txt";
        File f = new File(jarPath, File.separator.concat(fileName));

        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        OutputStream outputStream = new FileOutputStream(f, true);

        try {
            outputStream.write(showResult(game).concat("\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
