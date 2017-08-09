package homework2.figures;

import homework2.Point;
import homework2.Shape;

public class Triangle extends Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    private double a;
    private double b;
    private double c;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Triangle() {
    }

    private void getTringleSides() {
        a = Math.sqrt(Math.pow(point1.getX() + point2.getX(), 2) + Math.pow(point1.getY() + point2.getY(), 2));
        b = Math.sqrt(Math.pow(point2.getX() + point3.getX(), 2) + Math.pow(point2.getY() + point3.getY(), 2));
        c = Math.sqrt(Math.pow(point1.getX() + point3.getX(), 2) + Math.pow(point1.getX() + point3.getY(), 2));
    }

    @Override
    public double getPerimetr() {
        this.getTringleSides();
        return a + b + c;
    }

    @Override
    public double getArea() {
        double p = this.getPerimetr() / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
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

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
