package com.hillel.rockPaperScissors;

import com.hillel.rockPaperScissors.dto.Game;
import com.hillel.rockPaperScissors.dto.Player;
import com.hillel.rockPaperScissors.service.impl.GameService;
import com.hillel.rockPaperScissors.service.impl.GameServiceImpl;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Serhii Nikonenko
 * @version 1.1.3
 */

public class StartGame {

    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger save = LoggerFactory.getLogger("logger");


    public static Integer playerHand;

    public static void main(String[] args) {

        logger.info("Let's start the game!");

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter your name: ");
        String name = scanner.nextLine();
        logger.info(name);
        logger.info("Enter number of games : ");
        Integer numberOfGames;
        do {
            while (!scanner.hasNextInt()) {
                logger.info("Enter positive number ...");
                scanner.next();
            }
            numberOfGames = scanner.nextInt();
            logger.info(String.valueOf(numberOfGames));
            if(numberOfGames < 1) logger.info("Only positive number. Try again ...");
        } while (numberOfGames < 1);


        logger.info("HERE WE GO!");

        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(new Player()
                .setName(name));

        String continueGame = "Y";
        String stopGame = "Y";

        do {
            logger.info("""
                Choose a hand move:
                1 - Rock
                2 - Paper
                3 - Scissors
                """);

            Integer scannerInput;
            boolean b = false;
            do {
                while (!scanner.hasNextInt()) {
                    logger.info("Incorrect value. Enter 1, 2 or 3");
                    scanner.next();
                }
                scannerInput = scanner.nextInt();
                logger.info(String.valueOf(scannerInput));

                switch (scannerInput) {
                    case 1, 2, 3 -> {
                        playerHand = scannerInput;
                        b = true;
                    }
                    default -> logger.info("Incorrect value. Try again. Enter 1, 2 or 3");
                }
            } while (!b);

            gs.playerHand(game);
            gs.computerHand(game);

            logger.info("Player choice is " + gs.showHand(game.getPlayer().getHand()));
            logger.info("Computer choice is " + gs.showHand(game.getComputer().getHand()));
            gs.showWinner(game);

            do{
                continueGame = scanner.nextLine();
            } while (continueGame.equalsIgnoreCase("Y"));
            if (--numberOfGames == 0) break;
            logger.info("One more round ... [Y/N]?");
            stopGame = scanner.nextLine();
            logger.info(stopGame);
        } while (stopGame.equalsIgnoreCase("Y"));
        logger.info(gs.showResult(game));
        save.info(gs.showResult(game));

        gs.fileCreator(game, gs.showResult(game));
    }
}
