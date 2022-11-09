package day1.Exercise;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
    Figure circle = new Circle(6.7);
    Figure square = new Square(3);
    Figure rectangle = new Rectangle(5,6);
    System.out.println(circle.getClass());
    System.out.println(square.getClass());
    System.out.println(rectangle.getClass());
    }


}
