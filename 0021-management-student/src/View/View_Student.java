package View;

import controller.ManageStudent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author Administrator
 */
public class View_Student {

    ManageStudent manage = new ManageStudent();

    /**
     * function 1
     */
    void inputStudent() {

        //check size
        if (manage.getList().size() > 2) {
            if (checkYesNo() == false) {
                return;
            }
        }

        // input student
        String id = getId();

        // find record have id in list
        // input ID da ton tai -> hien thi ten luon, khong cho nhap nua.
        String name = manage.getStudentNameById(id);
        if (name == null) {
            name = getName();
        } else {
            System.out.println("Enter name: " + name);
        }

        int semester = getSemester();
        int course = getCourse();

        // add to list
        boolean result = manage.checkCreateStudent(id, name, semester, course);
        if (!result) {
            System.out.println("Duplicated!");
        } else {
            manage.addStudent(id, name, semester, course);
            System.out.println("Add successfull !!");
        }
    }

    private String getId() {
        String id = Utility.getString("Enter id: ", "Wrong", Utility.REGEX_STRING);
        return id;
    }

    private String getName() {
        String name = Utility.getString("Enter name: ", "Wrong", Utility.REGEX_STRING);
        return name;
    }

    private int getCourse() {
        int course = Utility.getInt("Enter course\n (1.Java || 2. .Net || 3. C/C++): ",
                "Wrong", "Wrong", "Wrong", 1, 3);
        return course;
    }

    private int getSemester() {
        int semester = Utility.getInt("Enter semester: ", "Wrong", "Wrong", "Wrong", 1, 10);
        return semester;
    }

    private boolean checkYesNo() {
        String result = Utility.getString("Do you want to continue? ( Y/ N): ", "Wrong", Utility.REGEX_YN);

        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkYesNo(String message) {
        String result = Utility.getString("Do you want to update " + message + "? (Y/N): ", "Wrong", Utility.REGEX_YN);

        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    
    
    /**
     * function 2
     */
    void findAndSort() {
        // input Name
        String name = getName();
        // search by name
        List<Student> listSearch = manage.getStudentByName(name);

        if (listSearch.isEmpty()) {
            System.out.println("Not found");
        }
        // sort by name
        Collections.sort(listSearch, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        // display after sort
        System.out.printf("%-8s %-15s %-12s %-10s \n", "ID", "Name", "Semester", "Course");
        for (Student student : listSearch) {
            System.out.println(student);
        }
    }
    
    
    
    
    /**
     * function 3
     */
    void updateOrDelete() {
        // input id
        String id = getId();

        // find Student by ID
        List<Student> listFoundID = manage.getStudentByID(id);
        if (listFoundID.isEmpty()) {
            System.err.println("NOT FOUND");
        } else {
            // check update or delete
            // U = true || D = false
            if (checkUpdateOrDelete()) {
                // Nhìn vào thằng listFoundID mới chọn đc để update or delete ok!
                // nên phải truyền vào 
                updateStudent(listFoundID);
            } else {
                deleteStudent(listFoundID);
            }
        }

        // check Update or Delete
    }

    private void updateStudent(List<Student> listFoundID) {
        displayListFoundByID(listFoundID);
        int choice = Utility.getInt("Enter your record you want to update?",
                "Must > min", "Must < max", "Wrong", 1, listFoundID.size());
        // update afte choice

        Student student = listFoundID.get(choice - 1);
        
        // get properties of student that you want to update
        String idOld = student.getId();
        String idUpdate = student.getId();
        String nameUpdate = student.getName();
        int semesterUpdate = student.getSemester();
        int courseUpdate = student.getCourse();

        if (checkYesNo("id")) {
            idUpdate = getId();
        }
        if (checkYesNo("name")) {
            nameUpdate = getName();
        }
        if (checkYesNo("semester")) {
            semesterUpdate = getSemester();
        }
        if (checkYesNo("course")) {
            courseUpdate = getCourse();
        }

        // check not update: Tuc la khong thay doi sau khi new info
        
        if (manage.checkNotUpdate(idUpdate, nameUpdate, semesterUpdate, courseUpdate, student)) {
            System.err.println("You not update!");
        } // check duplicate
        else if (manage.checkDuplicate(idUpdate, nameUpdate, semesterUpdate, courseUpdate)) {
            System.err.println("Duplicate !!!");
        } // update
        else {
            
//            student.setId(idUpdate);
            manage.updateAllId(idUpdate, idOld);
            manage.updateAllName(nameUpdate, idUpdate);
            student.setSemester(semesterUpdate);
            student.setCourse(courseUpdate);
        }

    }

    private void deleteStudent(List<Student> listFoundID) {
        displayListFoundByID(listFoundID);

        int choice = Utility.getInt("Enter your record you want to delete?",
                "Must > min", "Must < max", "Wrong", 1, listFoundID.size());
        // delete afte choice

        Student student = listFoundID.get(choice - 1);
        manage.removeStudent(student);
        System.out.println("Delete successfully!");
    }

    private boolean checkUpdateOrDelete() {
        String result = Utility.getString("Do you want to UPDATE or DELETE? ( U/ D): ",
                "Wrong", Utility.REGEX_UD);

        if (result.equalsIgnoreCase("u")) {
            return true;
        } else {
            return false;
        }
    }

    private void displayListFoundByID(List<Student> listFoundID) {
        System.out.printf("%-8s %-8s %-15s %-12s %-10s \n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFoundID.size(); i++) {
            Student student = listFoundID.get(i);
            System.out.format("%-8s %-8s %-15s %-12s %-10s \n",
                    i + 1, student.getId(), student.getName(), student.getSemester(),
                    student.getCourseString());
        }
    }
    
    

    /**
     * function 4
     */
    void report() {
        manage.getListReport().clear();
        for (Student first : manage.getList()) {
            int total = 0;
            for (Student second : manage.getList()) {
                if (first.getId().equalsIgnoreCase(second.getId())
                        && first.getCourse() == second.getCourse()) {
                    total++;

                }
            }
            manage.getListReport().add(new Report(first.getId(), first.getName(),
                    first.getCourse(), total));
        }
    }

}
