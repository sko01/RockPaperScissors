package ua.lviv.sko01.rockpaperscissors.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.lviv.sko01.rockpaperscissors.constants.Constants;

import java.io.InputStream;
import java.util.Scanner;


public class ConsoleUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleUtils.class);

    public static boolean getCreateNewGameInput(InputStream in, String msg) {
        Scanner sc = new Scanner(in);
        while(true) {
            LOG.info(msg);
            if (sc.hasNext()) {
                String input = sc.next();
                try {
                    return ValidationUtils.validateUserInput(input);
                } catch (IllegalArgumentException e) {
                    LOG.info("You didn't entered correct choice. Please try again");
                }
            }
        }
    }

    public static int getSelectedVariantInput(InputStream in, int size) {
        Scanner sc = new Scanner(in);
        while (true) {
            LOG.info("Please make your choice: ");
            if (sc.hasNextInt()) {
                int selection = sc.nextInt();
                if (ValidationUtils.validateSelectionWithinPossibleVariants(selection, size)) {
                    return selection;
                }
                LOG.info(Constants.ENTERED_NUMBER_NOT_CORRECT_MSG);
            } else {
                sc.next();
                LOG.info(Constants.ENTERED_NUMBER_NOT_CORRECT_MSG);
            }
        }
    }

    public static int getSelectedOpponentTypeInput(InputStream in, int size) {
        Scanner sc = new Scanner(in);
        while(true) {
            LOG.info("Enter you selection: ");
            if (sc.hasNextInt()) {
                int selection = sc.nextInt();
                if (ValidationUtils.validatePlayerSelection(selection, size)) {
                    return selection;
                } else {
                    LOG.info(Constants.ENTERED_NUMBER_NOT_CORRECT_MSG);
                }
            } else {
                sc.next();
                LOG.info(Constants.ENTERED_NUMBER_NOT_CORRECT_MSG);
            }
        }
    }

    private ConsoleUtils() {}
}
