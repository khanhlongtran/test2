/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author Administrator
 */
public class ManageStudent {

    List<Student> listStudent = new ArrayList<>();
    List<Report> listReport = new ArrayList<>();

    public List<Report> getListReport() {
        return listReport;
    }

    public ManageStudent() {
        listStudent.add(new Student("1", "A", 1, 1));
        listStudent.add(new Student("1", "A", 2, 3));
        listStudent.add(new Student("1", "A", 3, 2));
        listStudent.add(new Student("1", "A", 4, 1));

    }

    public List<Student> getList() {
        return listStudent;
    }

    public boolean checkCreateStudent(String id, String name, int semester, int course) {
        if (checkDuplicate(id, name, semester, course)) {
            return false;
        } else {
            listStudent.add(new Student(id, name, semester, course));
            return true;
        }
    }

    public boolean checkDuplicate(String id, String name, int semester, int course) {
        for (Student student : listStudent) {
            if (student.getId().equals(id)
                    && student.getSemester() == semester
                    && student.getCourse() == course
                    && student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public String getStudentNameById(String id) {
        for (Student student : listStudent) {
            if (student.getId().equals(id)) {
                return student.getName();
            }
        }
        return null;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> listSearch = new ArrayList<>();

        for (Student student : listStudent) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public List<Student> getStudentByID(String id) {
        List<Student> listSearch = new ArrayList<>();

        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public void removeStudent(Student student) {
        listStudent.remove(student);
    }

    public void addStudent(String id, String name, int semester, int course) {
        listStudent.add(new Student(id, name, semester, course));
    }

    public boolean checkNotUpdate(String idUpdate, String nameUpdate,
            int semesterUpdate, int courseUpdate, Student student) {
        if (student.getId().equalsIgnoreCase(idUpdate)
                && student.getName().equalsIgnoreCase(nameUpdate)
                && student.getSemester() == (semesterUpdate)
                && student.getCourse() == (courseUpdate)) {
            return true;
        }
        return false;
    }

    public void updateAllName(String nameUpdate, String idUpdate) {
        for (Student student : listStudent) {
            if (student.getId().equals(idUpdate)) {
                student.setName(nameUpdate);
            }
        }
    }

    public void updateAllId(String idUpdate, String idOld) {
        for (Student student : listStudent) {
            if (student.getId().equals(idOld)) {
                student.setId(idUpdate);
            }
        }
    }

}
