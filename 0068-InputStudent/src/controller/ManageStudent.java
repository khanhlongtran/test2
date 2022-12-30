/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Student;



/**
 *
 * @author Administrator
 */
public class ManageStudent {
    private List<Student> listStudent;
    // đây là thuộc tính nhé. Quản lí thì cần 1 danh sách mà.
    // ctrl + shift + i => import all

    public ManageStudent() {
        listStudent = new ArrayList<>();
    }

    // lấy getter tức là lớp này phải trả lại ĐC listStudent mong muốn.
    public List<Student> getListStudent() {
        return listStudent;
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }

    public void sort() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                  return o1.getName().compareToIgnoreCase(o2.getName());
                  // o1 > o2 => return positive
            }
        } );
    }
    
    
}
