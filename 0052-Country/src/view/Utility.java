package view;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Utility {
    
    public static String REGEX_CODE = "[A-Z]{3}";
    public static String REGEX_NAME = "[a-zA-z {-]+";
    public static String REGEX_TERRAIN = "[a-zA-Z ]+";
    public static String REGEX_NAME_SEARCH = "[a-zA-z {-]+";
    static int auto_Increment = 1;

    /**
     * This function use to get a string input
     * @param message: message required input
     * @param error: message error
     * @param regex: pattern use to check input
     * @return : user's input
     */   
    public String getString(String message, String error, String regex ) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }
    

    /**
     * get int number
     * @param message
     * @param firstError
     * @param secondError
     * @param thirdError
     * @param min
     * @param max
     * @return int number
     */
    public int getInt(String message, String firstError, String secondError,
            String thirdError, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }

            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    /**
     * get double number
     * @param message
     * @param firstError
     * @param secondError
     * @param thirdError
     * @param min
     * @param max
     * @return double number
     */
    public double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }

    /**
     * get float number
     * @param message
     * @param secondError
     * @param thirdError
     * @param min
     * @param max
     * @return float number
     */
    public float getFloat(String message, String secondError,
            String thirdError, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);

                //check range
                if (number <= min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(thirdError);
            }
        }
    }

}
