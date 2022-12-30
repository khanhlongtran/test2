/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        View_Countries view = new View_Countries();
        Utility util = new Utility();

        while (true) {
            System.out.println("\t\t\tMENU\n"
                    + "==========================================================================\n"
                    + "1. Input the information of 11 countries in East Asia\n"
                    + "2. Display the information of country you've just input\n"
                    + "3. Search the information of country by user-entered name\n"
                    + "4. Display the information of countries sorted name in ascending order  \n"
                    + "5. Exit \n"
                    + "==========================================================================");
            int option = util.getInt("Enter your choice: ", "Can not greater than 5",
                    "Can not less than 1",
                    "Must be digits", 1, 5);
            switch (option) {
                case 1:
                    view.addCountryInformation();
                    break;
                case 2:
                    view.getRecentlyEnteredInformation();
                    break;
                case 3:
                    view.searchInformationByName();
                    break;
                case 4:
                    view.sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.exit(0);

            }
        }

    }
}
