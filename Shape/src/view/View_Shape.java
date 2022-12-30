/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author Administrator
 */
public class View_Shape {

    static Scanner sc = new Scanner(System.in);

    void inputData(Circle circle, Triangle triangle, Rectangle rectangle) {
        System.out.println("=====Calculator Shape Program=====");
        //input rectangle
        while (true) {
            double width = Utility.getDouble("Please input side width:",
                    "Width must > 0", "Width must be number", 0);
            double length = Utility.getDouble("Please input side length: ",
                    "Length must > 0", "length must be number", 0);
            if (width <= length) {
                rectangle.setLength(length);
                rectangle.setWidth(width);
                break;
            } else {
                System.out.println("Withd must be < Length");
            }
        }
        //input circle
        double radius = Utility.getDouble("Please input side radius:",
                "Radius must > 0", "Radius must be number", 0);
        circle.setRadius(radius);
        //input triangle
        while (true) {
            double sideA = Utility.getDouble("Please input side A:",
                    "side A must > 0", "side A must be number", 0);
            double sideB = Utility.getDouble("Please input side B:",
                    "side B must > 0", "side B must be number", 0);
            double sideC = Utility.getDouble("Please input side B:",
                    "side B must > 0", "side A must be number", 0);
            if(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)  {
                triangle.setSideA(sideA);
                triangle.setSideB(sideB);
                triangle.setSideC(sideC);
                break;
            } else {
                System.out.println("The sum of 2 sides must be greater than the other side");
            }
        }
    }

    void displayCalculation(Circle circle, Triangle triangle, Rectangle rectangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
       
    }

    

}
