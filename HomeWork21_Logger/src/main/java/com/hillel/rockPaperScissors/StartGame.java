package com.hillel.rockPaperScissors;

import com.hillel.rockPaperScissors.dto.Game;
import com.hillel.rockPaperScissors.dto.Player;
import com.hillel.rockPaperScissors.service.impl.GameService;
import com.hillel.rockPaperScissors.service.impl.GameServiceImpl;

import java.util.Locale;
import java.util.ResourceBundle;
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

    public static Locale currentLocale;

    public static Integer playerHand;

    /**
     * default locale is "ua"
     * choose "de" or "en" as method main arguments
     * */

    public static void main(String[] args) {

        Locale locale = new Locale("ua", "UA");
        Locale.setDefault(locale);
        currentLocale = Locale.getDefault();

        if (args.length != 0) {
            currentLocale = new Locale(args[0]);
        }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("text_local", currentLocale);

        logger.info(resourceBundle.getString("Let's start the game!"));

        Scanner scanner = new Scanner(System.in);
        logger.info(resourceBundle.getString("Enter your name") + ": ");
        String name = scanner.nextLine();
        logger.info(name);
        logger.info(resourceBundle.getString("Enter number of games") + ": ");
        Integer numberOfGames;
        do {
            while (!scanner.hasNextInt()) {
                logger.info(resourceBundle.getString("Enter positive number ..."));
                scanner.next();
            }
            numberOfGames = scanner.nextInt();
            logger.info(String.valueOf(numberOfGames));
            if(numberOfGames < 1) logger.info(resourceBundle.getString("Only positive number. Try again ..."));
        } while (numberOfGames < 1);


        logger.info(resourceBundle.getString("HERE WE GO!"));

        GameService gs = new GameServiceImpl();
        Game game = gs.startGame(new Player()
                .setName(name));

        String continueGame = "Y";
        String stopGame = "Y";

        do {
            logger.info(resourceBundle.getString("Choose a hand move") + ": ");
            logger.info(resourceBundle.getString("1 - Rock -"));
            logger.info(resourceBundle.getString("2 - Paper -"));
            logger.info(resourceBundle.getString("3 - Scissors -"));

            Integer scannerInput;
            boolean b = false;
            do {
                while (!scanner.hasNextInt()) {
                    logger.info(resourceBundle.getString("Incorrect value. Enter 1, 2 or 3"));
                    scanner.next();
                }
                scannerInput = scanner.nextInt();
                logger.info(String.valueOf(scannerInput));

                switch (scannerInput) {
                    case 1, 2, 3 -> {
                        playerHand = scannerInput;
                        b = true;
                    }
                    default -> logger.info(resourceBundle.getString("Incorrect value. Try again. Enter 1, 2 or 3"));
                }
            } while (!b);

            gs.playerHand(game);
            gs.computerHand(game);

            logger.info(resourceBundle.getString("Player choice is") + " - " +
                    resourceBundle.getString(gs.showHand(game.getPlayer().getHand()).toString()));
            logger.info(resourceBundle.getString("Computer choice is") + " - " +
                    resourceBundle.getString(gs.showHand(game.getComputer().getHand()).toString()));
            gs.showWinner(game);

            do{
                continueGame = scanner.nextLine();
            } while (continueGame.equalsIgnoreCase("Y"));
            if (--numberOfGames == 0) break;
            logger.info(resourceBundle.getString("One more round ... [Y/N]?"));
            stopGame = scanner.nextLine();
            logger.info(stopGame);
        } while (stopGame.equalsIgnoreCase("Y"));
        logger.info(gs.showResult(game));
        save.info(gs.showResult(game));

        gs.fileCreator(game, gs.showResult(game));
    }
}
