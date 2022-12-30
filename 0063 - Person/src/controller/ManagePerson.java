/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Person;

/**
 *
 * @author Administrator
 */
public class ManagePerson {

    private Person[] personArray = new Person[3];

    /**
     * Getter
     * @return 
     */
    public Person[] getPersonArray() {
        return personArray;
    }

    /**
     * Sort person list by salary ascending
     */
    public void sort() {
        for (int i = 0; i < personArray.length - 1; i++) {
            for (int j = i + 1; j < personArray.length; j++) {
                if (personArray[i].getSalary() > personArray[j].getSalary()) {
                    Person tempPerson = personArray[i];
                    personArray[i] = personArray[j];
                    personArray[j] = tempPerson;
                }
            }
        }
    }

    /**
     * add information into array after input correctly all the request
     * @param name
     * @param address
     * @param salary
     * @param k 
     */
    public void addPerson(String name, String address, double salary, int k) {
        for (int i = 0; i < personArray.length; i++) {
            personArray[k] = new Person(name, address, salary);
        }
    }
}
