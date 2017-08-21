package ua.lviv.sko01.rockpaperscissors.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VariantsTest {
    @Test
    public void testPaperIsBetterThanPaperShouldReturnFalse() {
        Variants choice = Variants.PAPER;
        assertFalse("Paper should not be better than Paper", choice.isBetterThen(Variants.PAPER));
    }

    @Test
    public void testPaperIsBetterThanScissorsShouldReturnFalse() {
        Variants choice = Variants.PAPER;
        assertFalse("Paper should not be better than Scissors", choice.isBetterThen(Variants.SCISSORS));
    }

    @Test
    public void testPaperIsBetterThanRockShouldReturnTrue() {
        Variants choice = Variants.PAPER;
        assertTrue("Paper should be better than Rock", choice.isBetterThen(Variants.ROCK));
    }

    @Test
    public void testPaperIsBetterThanNullShouldReturnFalse() {
        Variants choice = Variants.PAPER;
        assertFalse("Paper should not be better than null", choice.isBetterThen(null));
    }

    @Test
    public void testRockIsBetterThanPaperShouldReturnFalse() {
        Variants choice = Variants.ROCK;
        assertFalse("Rock should not be better than Paper", choice.isBetterThen(Variants.PAPER));
    }

    @Test
    public void testRockIsBetterThanScissorsShouldReturnTrue() {
        Variants choice = Variants.ROCK;
        assertTrue("Rock should be better than Scissors", choice.isBetterThen(Variants.SCISSORS));
    }

    @Test
    public void testRockIsBetterThanRockShouldReturnFalse() {
        Variants choice = Variants.ROCK;
        assertFalse("Rock should not be better than Rock", choice.isBetterThen(Variants.ROCK));
    }

    @Test
    public void testRockIsBetterThanNullShouldReturnFalse() {
        Variants choice = Variants.ROCK;
        assertFalse("Rock should not be better than null", choice.isBetterThen(null));
    }

    @Test
    public void testScissorsIsBetterThanPaperShouldReturnTrue() {
        Variants choice = Variants.SCISSORS;
        assertTrue("Scissors should be better than Paper", choice.isBetterThen(Variants.PAPER));
    }

    @Test
    public void testScissorsIsBetterThanScissorsShouldReturnFalse() {
        Variants choice = Variants.SCISSORS;
        assertFalse("Scissors should not be better than Scissors", choice.isBetterThen(Variants.SCISSORS));
    }

    @Test
    public void testScissorsIsBetterThanRockShouldReturnFalse() {
        Variants choice = Variants.SCISSORS;
        assertFalse("Scissors should not be better than Rock", choice.isBetterThen(Variants.ROCK));
    }

    @Test
    public void testScissorsIsBetterThanNullShouldReturnFalse() {
        Variants choice = Variants.SCISSORS;
        assertFalse("Scissors should not be better than null", choice.isBetterThen(null));
    }
}
