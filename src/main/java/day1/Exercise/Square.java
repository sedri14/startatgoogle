package day1.Exercise;

public class Square extends Figure {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return length*length;
    }

}
