
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("vi");
        ResourceBundle bundle = ResourceBundle.getBundle("lang", locale);
        System.out.println("Xin chao trong tieng anh: " + bundle.getString("hello"));
    }
}
