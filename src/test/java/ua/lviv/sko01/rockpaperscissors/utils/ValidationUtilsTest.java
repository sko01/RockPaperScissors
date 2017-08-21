package ua.lviv.sko01.rockpaperscissors.utils;


import org.junit.Test;
import ua.lviv.sko01.rockpaperscissors.models.Variants;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationUtilsTest {
    @Test
    public void testSelectionWithinPossibleVariantsShouldReturnTrue() {
        assertTrue("Selection should be within possible variants", ValidationUtils.validateSelectionWithinPossibleVariants(1, Variants.values().length));
        assertTrue("Selection should be within possible variants", ValidationUtils.validateSelectionWithinPossibleVariants(Variants.values().length, Variants.values().length));
    }

    @Test
    public void testSelectionNotWithinPossibleVariantsShouldReturnFalse() {
        assertFalse("Selection not within possible variants should return false", ValidationUtils.validateSelectionWithinPossibleVariants(0, Variants.values().length));
        assertFalse("Selection not within possible variants should return false", ValidationUtils.validateSelectionWithinPossibleVariants(Variants.values().length + 1, Variants.values().length));
    }

    @Test
    public void testPlayerSelectionWithinPossibleValuesShouldReturnTrue() {
        assertTrue("Selection within possible values return true", ValidationUtils.validatePlayerSelection(1, 2));
        assertTrue("Selection within possible values return true", ValidationUtils.validatePlayerSelection(2, 2));
    }

    @Test
    public void testPlayerSelectionNotWithinPossibleValuesShouldReturnFalse() {
        assertFalse("Selection not within possible values return false", ValidationUtils.validatePlayerSelection(0, 2));
        assertFalse("Selection not within possible values return false", ValidationUtils.validatePlayerSelection(4, 2));
    }

    @Test
    public void testValidYUserInputShouldReturnTrue() {
        assertTrue("'Y' user input should be valid and return true", ValidationUtils.validateUserInput("Y"));
        assertTrue("'y' user input should be valid and return true", ValidationUtils.validateUserInput("y"));
    }

    @Test
    public void testValidNUserInputShouldReturnFalse() {
        assertFalse("'N' user input should be valid and return false", ValidationUtils.validateUserInput("N"));
        assertFalse("'n' user input should be valid and return false", ValidationUtils.validateUserInput("n"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUserInputTrowsIllegalArgumentException() {
        ValidationUtils.validateUserInput("any text");
    }
}
