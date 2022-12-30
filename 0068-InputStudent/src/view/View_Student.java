/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import model.Student;

/**
 *
 * @author Administrator
 */
public class View_Student {

    ManageStudent manage = new ManageStudent();

    /**
     * This function use to input Student information
     */
    public void inputStudent() {
        System.out.println("=====Collection Sort Program=====");
        System.out.println("Please input student information");
        //input infor   
        while (true) {
            String name = Utility.getString("Name: ", "Name must be letter", Utility.REGEX_NAME);
            String classes = Utility.getString("Classes: ", "Classes must be letter",
                    Utility.REGEX_CLASSES);
            float mark = Utility.getFloat("Mark: ", "Cannot > 100", "Cannot < 0", "Must be digits", 0, 100);
            Student student = new Student(name, mark, classes);
            manage.addStudent(student);
            
            if(!checkYesNo()) {
                break;
            }
        }

    }

    void sortStudent() {
        manage.sort();
    }

    void displayStudent() {
        int id = 0;
        for (Student student : manage.getListStudent()) {
            System.out.println("-----Student " + (++id) + "-----");
            System.out.println(student.toString());
        }
    }

    private boolean checkYesNo() {
        String result = Utility.getString("Do you want to enter more student",
                "Must be y/Y or n/N", "[yYnN]");
        return result.equalsIgnoreCase("Y");
    }

}
