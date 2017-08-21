package ua.lviv.sko01.rockpaperscissors.utils;


public class ValidationUtils {

    public static boolean validateSelectionWithinPossibleVariants(int selection, int numberOfVariants) {
        return  (selection > 0 && selection <= numberOfVariants);
    }

    public static boolean validatePlayerSelection(int selection, int playersCount) {
        return (selection > 0 && selection <= playersCount);
    }

    public static boolean validateUserInput(String input) {
        if ("y".equalsIgnoreCase(input)) {
            return true;
        } else if ("n".equalsIgnoreCase(input)) {
            return false;
        } else {
            throw new IllegalArgumentException("Not valid user input");
        }
    }

    private ValidationUtils(){}
}
