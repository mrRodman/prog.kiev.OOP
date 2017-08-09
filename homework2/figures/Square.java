package homework2.figures;

import homework2.Point;
import homework2.Shape;

public class Square extends Shape {
    private Point point1;
    private Point point2;

    private double squareSide;

    public Square(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Square() {
    }

    private void getSquareSide() {
        squareSide = Math.sqrt(Math.pow(point1.getX() + point2.getX(), 2)
                + Math.pow(point1.getY() + point2.getY(), 2));
    }

    @Override
    public double getPerimetr() {
        this.getSquareSide();
        return 4 * squareSide;
    }

    @Override
    public double getArea() {
        this.getSquareSide();
        return Math.pow(squareSide, 2);
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Square{" +
                "point1=" + point1.getX() + " " + point1.getY() +
                ", point2=" + point2.getX() + " " + point2.getY() +
                ", squareSide=" + squareSide +
                '}';
    }
}