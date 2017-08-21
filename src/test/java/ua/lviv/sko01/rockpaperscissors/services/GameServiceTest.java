package ua.lviv.sko01.rockpaperscissors.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.lviv.sko01.rockpaperscissors.core.GameBuilder;
import ua.lviv.sko01.rockpaperscissors.models.Game;
import ua.lviv.sko01.rockpaperscissors.services.impl.GameServiceImpl;
import ua.lviv.sko01.rockpaperscissors.utils.ConsoleUtils;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameBuilder builder;

    @Test
    public void testPlayGameMethodShouldBeCalled() {
        Game game = mock(Game.class);
        when(builder.buildGame()).thenReturn(game);
        ByteArrayInputStream in = new ByteArrayInputStream("n\r".getBytes());
        System.setIn(in);
        gameService.playGame();

        verify(game, times(1)).playGame();
    }
}
