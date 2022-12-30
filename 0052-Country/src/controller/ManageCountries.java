/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.EastAsiaCountry;

/**
 *
 * @author Administrator
 */
public class ManageCountries {

    List<EastAsiaCountry> listCountry = new ArrayList<>();

    public List<EastAsiaCountry> getListCountry() {
        return listCountry;
    }

    public void addCountry(String countryCode, String countryName, float totalArea,
            String countryTerrain) {
        listCountry.add(new EastAsiaCountry(countryCode, countryName, totalArea, countryTerrain));
    }

}
