package ua.lviv.sko01.rockpaperscissors.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.lviv.sko01.rockpaperscissors.core.GameEngine;
import ua.lviv.sko01.rockpaperscissors.models.impl.ComputerPlayer;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerTest {
    private static String NAME = "PC";

    @InjectMocks
    ComputerPlayer player;

    @Mock
    GameEngine engine;

    @Test
    public void testGetNameShouldReturnPreviouslyProvidedName() {
        player.setName(NAME);
        assertEquals("Player name should be 'Demo'", NAME, player.getName());
    }

    @Test
    public void testMakeChoiceShouldReturnSelectedOption() {
        List<Variants> variants = Arrays.asList(Variants.values());
        when(engine.getChoiceList()).thenReturn(variants);
        Variants choice = player.makeChoice(engine.getChoiceList());
        assertTrue("Existing option should be returned", variants.contains(choice));
    }
}
