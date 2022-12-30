/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        View_Student view = new View_Student();

        while (true) {
            displayMenu();

            int option = Utility.getInt("Option: ", "Wrong", "Wrong", "Wrong", 1, 5);

            switch (option) {
                case 1:
                    // input
                    view.inputStudent();
                    break;
                case 2:
                    // find and sort list search
                    view.findAndSort();
                    break;
                case 3:
                    // update or delete
                    view.updateOrDelete();
                    break;
                case 4:
                    // report
                    view.report();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }
    private static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit");
    }
}
