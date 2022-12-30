/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManagePerson;

/**
 *
 * @author Administrator
 */
public class View_Person {

    ManagePerson managePerson = new ManagePerson();
    /**
     * Input data
     */
    void inputData() {
        System.out.println("""
                           =====Management Person programer=====
                           """);
        for (int i = 0; i < managePerson.getPersonArray().length; i++) {
            String name = Utility.getString("Input Inforrmation of Person\n"
                    + "Please input name:",
                    "Name must be letter",
                    Utility.REGEX_NAME);
            String address = Utility.getString("Please input address:",
                    "Address must be letters",
                    Utility.REGEX_ADDRESS);
            double salary = Utility.getDouble("Please input salary:",
                    "Salary is greater than zero",
                    "Salary must be digits",
                    0.000001,
                    Double.MAX_VALUE);
            
            // add person after checking correctly
            managePerson.addPerson(name, address, salary, i);
        }
    }
    /**
     * sort list person
     */
    void sortPerson() {
        managePerson.sort();
    }

    void displayInformation() {

        System.out.println("Information of Person you have entered:");
        for (int i = 0; i < managePerson.getPersonArray().length; i++) {
            System.out.println("Name: " + managePerson.getPersonArray()[i].getName());
            System.out.println("Address: " + managePerson.getPersonArray()[i].getAddress());
            System.out.println("Salary: " + managePerson.getPersonArray()[i].getSalary() + "\n");

        }

    }

}
