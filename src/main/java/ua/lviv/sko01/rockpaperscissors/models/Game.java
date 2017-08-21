package ua.lviv.sko01.rockpaperscissors.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.lviv.sko01.rockpaperscissors.constants.Constants;
import ua.lviv.sko01.rockpaperscissors.core.GameEngine;
import ua.lviv.sko01.rockpaperscissors.utils.ConsoleUtils;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final Logger LOG = LoggerFactory.getLogger(Game.class);

    GameEngine gameEngine;

    private Player playerOne;

    private Player playerTwo;

    private Map<String, Integer> score = new HashMap<>();

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

    public String getScoreString() {
        String playerOneName = playerOne.getName();
        String playerTwoName = playerTwo.getName();
        return String.format("%s: %d  %s: %d", playerOneName, score.get(playerOneName), playerTwoName, score.get(playerTwoName));
    }

    public void playGame() {
        boolean newRound = true;
        while(newRound) {
            startRound();
            newRound = ConsoleUtils.isContinueGame(System.in, Constants.CREATE_NEW_ROUND_MSG);
        }
    }

    private void startRound() {
        Variants playerOneMove = playerOne.makeChoice(gameEngine.getChoiceList());
        Variants playerTwoMove = playerTwo.makeChoice(gameEngine.getChoiceList());
        Result result = gameEngine.getResult(playerOneMove, playerTwoMove);
        LOG.info("{} selected {}", playerOne.getName(), playerOneMove);
        LOG.info("{} selected {}", playerTwo.getName(), playerTwoMove);
        LOG.info("Round result: {}", result);
        updateScore(result);
        LOG.info(getScoreString());
    }

    private void updateScore(Result result) {
        switch(result) {
            case WIN:
                score.put(playerOne.getName(), score.get(playerOne.getName()).intValue() + 1);
                break;
            case LOOSE:
                score.put(playerTwo.getName(), score.get(playerTwo.getName()).intValue() + 1);
                break;
            case DRAW:
                break;
        }
    }
}
