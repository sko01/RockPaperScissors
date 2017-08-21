package ua.lviv.sko01.rockpaperscissors.core;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import ua.lviv.sko01.rockpaperscissors.core.impl.RPSGameEngine;
import ua.lviv.sko01.rockpaperscissors.models.Result;
import ua.lviv.sko01.rockpaperscissors.models.Variants;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {

    @InjectMocks
    RPSGameEngine gameEngine;

    @Test
    public void testAvailableChoiceListShouldBeReturned() {
        List<Variants> variants = Arrays.asList(Variants.values());
        assertEquals("Same variants list should be returned", variants, gameEngine.getChoiceList());
    }

    @Test
    public void testDrawComparisonResultShouldBeReturnedIfSameVariantsWereSelected() {
        Variants playerOneVariant = Variants.PAPER;
        Variants playerTwoVariant = Variants.PAPER;
        assertEquals("Draw result is expected", Result.DRAW, gameEngine.getResult(playerOneVariant, playerTwoVariant));
    }

    @Test
    public void testWinComparisonResultShouldBeReturnedIfRockAndScissersWereSelected() {
        Variants playerOneVariant = Variants.ROCK;
        Variants playerTwoVariant = Variants.SCISSORS;
        assertEquals("Win result is expected", Result.WIN, gameEngine.getResult(playerOneVariant, playerTwoVariant));
    }

    @Test
    public void testLooseComparisonResultShouldBeReturnedIfRockAndScissersWereSelected() {
        Variants playerOneVariant = Variants.ROCK;
        Variants playerTwoVariant = Variants.PAPER;
        assertEquals("Loose result is expected", Result.LOOSE, gameEngine.getResult(playerOneVariant, playerTwoVariant));
    }
}
