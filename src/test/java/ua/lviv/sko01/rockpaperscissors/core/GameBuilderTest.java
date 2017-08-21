package ua.lviv.sko01.rockpaperscissors.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import ua.lviv.sko01.rockpaperscissors.constants.Constants;
import ua.lviv.sko01.rockpaperscissors.models.Game;
import ua.lviv.sko01.rockpaperscissors.models.impl.ComputerPlayer;
import ua.lviv.sko01.rockpaperscissors.models.impl.HumanPlayer;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class GameBuilderTest {

    @InjectMocks
    GameBuilder builder;

    @Test
    public void testBuildGameShouldBeCreatedWithComputerPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(Constants.COMPUTER_TRIGGER).getBytes());
        System.setIn(in);
        Game game = builder.buildGame();
        assertTrue("Game with computer player created", game.getPlayerTwo() instanceof ComputerPlayer);
    }

    @Test
    public void testBuildGameShouldBeCreatedWithHumanPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(Constants.PLAYER_TRIGGER).getBytes());
        System.setIn(in);
        Game game = builder.buildGame();
        assertTrue("Game with human player created", game.getPlayerTwo() instanceof HumanPlayer);
    }

    @Test
    public void testBuildGameShouldBeCreatedWithScoreZeroValues() {
        ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(Constants.PLAYER_TRIGGER).getBytes());
        System.setIn(in);
        Game game = builder.buildGame();
        assertTrue("Game with score equals zero created", game.getScore().get(game.getPlayerOne().getName()) == 0);
        assertTrue("Game with score equals zero created", game.getScore().get(game.getPlayerTwo().getName()) == 0);
    }
}
