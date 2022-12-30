
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class ValidationData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // check phone format
        checkPhoneFormat(sc);
        // check email format
        checkEmailFormat(sc);
        // check date format
        checkDateFormat(sc);

    }

    /**
     * check phone format
     *
     * @param sc
     */
    private static boolean checkPhoneFormat(Scanner sc) {
        // Trinh bay mẫu của của đề thui. Từng bước 1.
        System.out.println("======== Validate Program ========");
        while (true) {
            System.out.print("Phone number: ");
            String phone = sc.nextLine().trim();

            // if phone empty => prompt error
            if (phone.isEmpty()) {
                System.err.println("Phone cannot empty!");
            } // check format using match regex // must be number and have 10 digits
            else if (!phone.matches("[0-9]{10}")) {
                System.err.println("Phone must be 10 digits and is numbers");
            } else {
                return false;
            }

        }

    }

    /**
     * check email format
     *
     * @param sc
     */
    private static boolean checkEmailFormat(Scanner sc) {
        while (true) {
            System.out.print("Your email: ");
            String email = sc.nextLine().trim();

            // if mail empty => prompt error
            if (email.isEmpty()) {
                System.err.println("Mail cannot empty!");
            } // check format using match regex // must be xxx@xxx
            else if (!email.matches("\\w+[@](\\w+[.])+\\w+")) {
                System.err.println("Email must correct format: \\w+[@](\\w+[.])+\\w+ ");
            } else {
                return false;
            }

        }
    }

    /**
     * check date format
     *
     * @param sc
     */
    private static boolean checkDateFormat(Scanner sc) {
        System.out.print("Input date: ");
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateInput = sc.nextLine();
                Date date = dateFormat.parse(dateInput);

                // check date exist 
                // if exist => return false
                if (checkDateExist(dateInput, dateFormat)) {
                    return false;
                }

            } catch (ParseException ex) {
                System.err.println("Date to correct format (dd//mm/yyyy)");
            }
        }

    }

    /**
     *
     * @param dateInput
     * @param dateFormat
     * @return true/false
     */
    private static boolean checkDateExist(String dateInput, SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);
        try {
            Date outputDate = dateFormat.parse(dateInput);
            return true;
        } catch (ParseException ex) {
            System.err.println("Date does not exist");
            return false;
        }
    }
}
