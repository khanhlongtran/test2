/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.EastAsiaCountry;

/**
 *
 * @author Administrator
 */
public class View_Countries {

    ManageCountries manage = new ManageCountries();
    Utility utility = new Utility();

    void addCountryInformation() {
        while (true) {

            System.out.print("%n"
                    + "#" + Utility.auto_Increment++ + " ");
            String countryCode = utility.getString("Enter codes of country : ",
                    "Must be letter",
                    Utility.REGEX_CODE);
            String countryName = utility.getString("Enter name of country: ", "Must be letter",
                    Utility.REGEX_NAME);
            float totalArea = utility.getFloat("Enter total Area: ", "Area must greater than 0",
                    "Must be digits",
                    0, Float.MAX_VALUE);
            String countryTerrain = utility.getString("Enter terrain of country: ",
                    "Must be letter",
                    Utility.REGEX_TERRAIN);

            if (checkCodeAndName(countryCode, countryName)) {
                manage.addCountry(countryCode, countryName, totalArea, countryTerrain);
            } else {
                System.out.println("ID, NAME cannot be duplicated!");
            }

            if (manage.getListCountry().size() == 3) {
                break;
            }

        }

    }

    void getRecentlyEnteredInformation() {
        if (manage.getListCountry().isEmpty()) {
            System.out.println("Not Found! The list is empty!");
        } else {
            manage.getListCountry().get(manage.getListCountry().size() - 1).display();
        }

    }

    void searchInformationByName() {
        List<EastAsiaCountry> listSearch = new ArrayList<>();
        String searchName = utility.getString("Enter name that you want to search: ",
                "Must be letter!", Utility.REGEX_NAME_SEARCH);
        if (manage.getListCountry().isEmpty()) {
            System.out.println("Can't search because you haven't entered!");
            return;
        }

        for (int i = 0; i < manage.getListCountry().size(); i++) {
            if (manage.getListCountry().get(i).getCountryName().toLowerCase().contains(searchName.toLowerCase())) {
                listSearch.add(manage.getListCountry().get(i));
            }
        }

        for (EastAsiaCountry eastAsiaCountry : listSearch) {
            eastAsiaCountry.display();
        }

    }

    void sortInformationByAscendingOrder() {
        if (manage.getListCountry().isEmpty()) {
            System.out.println("Can't search because you haven't entered!");
            return;
        }
        Collections.sort(manage.getListCountry(),
                (EastAsiaCountry o1, EastAsiaCountry o2) -> o1.getCountryName().compareTo(o2.getCountryName()));
        for (EastAsiaCountry eastAsiaCountry : manage.getListCountry()) {
            eastAsiaCountry.display();
        }
    }

    private boolean checkCodeAndName(String countryCode, String countryName) {
        for (int i = 0; i < manage.getListCountry().size(); i++) {
            if (manage.getListCountry().get(i).getCountryCode().equals(countryCode)
                    || manage.getListCountry().get(i).getCountryName().equals(countryName)) {
                return false;
            }
        }
        return true;
    }
}
