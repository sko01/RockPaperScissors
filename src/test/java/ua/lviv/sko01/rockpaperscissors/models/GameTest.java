package ua.lviv.sko01.rockpaperscissors.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.lviv.sko01.rockpaperscissors.core.impl.RPSGameEngine;
import ua.lviv.sko01.rockpaperscissors.models.impl.ComputerPlayer;
import ua.lviv.sko01.rockpaperscissors.models.impl.HumanPlayer;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    private Player playerOne;
    private Player playerTwo;
    private Map<String, Integer> score;

    @InjectMocks
    Game game;

    @Mock
    RPSGameEngine gameEngine;

    @Before
    public void setUp() {
        playerOne = new HumanPlayer();
        playerOne.setName("Player 1");
        playerTwo = new ComputerPlayer();
        game.setPlayerOne(playerOne);
        game.setPlayerTwo(playerTwo);
        game.setGameEngine(gameEngine);
        score = new HashMap<>();
        score.put(playerOne.getName(), 0);
        score.put(playerTwo.getName(), 0);
        game.setScore(score);
    }

    @Test
    public void testGetPlayerOneShouldReturnFirstPlayer() {
        assertEquals("Same player should be returned from game as was set", playerOne, game.getPlayerOne());
    }

    @Test
    public void testGetPlayerTwoShouldReturnFirstPlayer() {
        assertEquals("Same player should be returned from game as was set", playerTwo, game.getPlayerTwo());
    }

    @Test
    public void testGetScoreShouldReturnInitialScore() {
        assertEquals("Same score should be returned from game as was set", score, game.getScore());
    }

    @Test
    public void testGetGameEngineShouldReturnInitialGameEngine() {
        assertEquals("Same game engine should be returned from game as was set", gameEngine, game.getGameEngine());
    }

    @Test
    public void testGetScoreStringShouldReturnStringWithPlayerNames() {
        assertTrue("String should contain player names", game.getScoreString().contains(playerOne.getName()));
        assertTrue("String should contain player names", game.getScoreString().contains(playerTwo.getName()));
    }

    @Test
    public void testPlayGameShouldStartAndIncreaseScoreForPlayerOne() {
        HumanPlayer playerMock = Mockito.mock(HumanPlayer.class);
        game.setPlayerOne(playerMock);
        when(gameEngine.getChoiceList()).thenReturn(Arrays.asList(Variants.values()));
        when(gameEngine.getResult(any(), any())).thenReturn(Result.WIN);
        when(playerMock.makeChoice(any())).thenReturn(Variants.PAPER);
        when(playerMock.getName()).thenReturn("Player 1");
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);

        int scoreBefore = score.get(playerOne.getName());

        game.playGame();
        int scoreAfter = game.getScore().get(playerOne.getName());

        assertEquals("Score should be updated", scoreAfter, scoreBefore + 1);
    }

    @Test
    public void testPlayGameShouldStartAndIncreaseScoreForPlayerTwo() {
        HumanPlayer playerMock = Mockito.mock(HumanPlayer.class);
        game.setPlayerOne(playerMock);
        when(gameEngine.getChoiceList()).thenReturn(Arrays.asList(Variants.values()));
        when(gameEngine.getResult(any(), any())).thenReturn(Result.LOOSE);
        when(playerMock.makeChoice(any())).thenReturn(Variants.PAPER);
        when(playerMock.getName()).thenReturn("Player 1");
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);

        int scoreBefore = score.get(playerTwo.getName());

        game.playGame();
        int scoreAfter = game.getScore().get(playerTwo.getName());

        assertEquals("Score should be updated", scoreAfter, scoreBefore + 1);
    }

    @Test
    public void testPlayGameShouldStartAndNotIncreaseScore() {
        HumanPlayer playerMock = Mockito.mock(HumanPlayer.class);
        game.setPlayerOne(playerMock);
        when(gameEngine.getChoiceList()).thenReturn(Arrays.asList(Variants.values()));
        when(gameEngine.getResult(any(), any())).thenReturn(Result.DRAW);
        when(playerMock.makeChoice(any())).thenReturn(Variants.PAPER);
        when(playerMock.getName()).thenReturn("Player 1");
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);

        int scoreBeforePlayerOne = score.get(playerMock.getName());
        int scoreBeforePlayerTwo = score.get(playerTwo.getName());

        game.playGame();
        int scoreAfterPlayerOne = game.getScore().get(playerMock.getName());
        int scoreAfterPlayerTwo = game.getScore().get(playerTwo.getName());

        assertEquals("Score should be updated", scoreAfterPlayerOne, scoreBeforePlayerOne);
        assertEquals("Score should be updated", scoreAfterPlayerTwo, scoreBeforePlayerTwo);
    }
}
