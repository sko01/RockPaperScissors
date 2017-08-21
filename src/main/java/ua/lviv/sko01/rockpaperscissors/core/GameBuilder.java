package ua.lviv.sko01.rockpaperscissors.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.sko01.rockpaperscissors.constants.Constants;
import ua.lviv.sko01.rockpaperscissors.models.Game;
import ua.lviv.sko01.rockpaperscissors.models.Player;
import ua.lviv.sko01.rockpaperscissors.models.impl.ComputerPlayer;
import ua.lviv.sko01.rockpaperscissors.models.impl.HumanPlayer;
import ua.lviv.sko01.rockpaperscissors.utils.ConsoleUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(GameBuilder.class);

    @Autowired
    GameEngine gameEngine;

    public Game buildGame(){
        Game rpsGame = new Game();
        rpsGame.setGameEngine(gameEngine);
        Player playerOne = new HumanPlayer();
        playerOne.setName("Player 1");
        Player playerTwo = initPlayerTwo();

        rpsGame.setPlayerOne(playerOne);
        rpsGame.setPlayerTwo(playerTwo);
        rpsGame.setScore(initGameScore(playerOne, playerTwo));
        return rpsGame;
    }

    private Player initPlayerTwo(){
        LOG.info("Please select opponent:");
        LOG.info("{}. Player", Constants.PLAYER_TRIGGER);
        LOG.info("{}. Computer", Constants.COMPUTER_TRIGGER);
        int selected = ConsoleUtils.getSelectedOpponentTypeInput(System.in, Constants.PLAYER_COUNT);
        if (selected == Constants.PLAYER_TRIGGER) {
            Player playerTwo = new HumanPlayer();
            playerTwo.setName("Player 2");
            return playerTwo;
        } else {
            return new ComputerPlayer();
        }
    }

    private Map<String, Integer> initGameScore(Player playerOne, Player playerTwo){
        Map<String, Integer> gameScore = new HashMap<>();
        gameScore.put(playerOne.getName(), 0);
        gameScore.put(playerTwo.getName(), 0);
        return gameScore;
    }
}
