package view;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Utility {

    protected static final String REGEX_NAME = "[a-zA-Z ]+";
    protected static final String REGEX_ADDRESS = "[a-zA-Z0-9 ]+";

    /**
     * This function use to get a string input
     *
     * @param message: message required input
     * @param error: message error
     * @param regex: pattern use to check input
     * @return : user's input
     */
    public static String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Can not empty!");
            }
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }

    /**
     * get a double number following request
     *
     * @param message
     * @param firstError
     * @param secondError
     * @param min
     * @param max
     * @return double number
     */
    public static double getDouble(String message, String firstError, String secondError,
            double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);

                //check range
                if (number < min) {
                    System.out.println(firstError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(secondError);
            }
        }
    }
}
