package homework2.figures;

import homework2.Point;
import homework2.Shape;

public class Circle extends Shape {
    private Point centre;
    private Point pointOnLine;
    private double radiusDefault;

    private double radius;

    /**
     *
     * constructor with some dot on the line
     */

    public Circle(Point centre, Point pointOnLine) {
        this.centre = centre;
        this.pointOnLine = pointOnLine;
    }

    /**
     *
     * constructor with radius
     */

    public Circle(Point centre, double radiusDefault) {
        this.centre = centre;
        this.radiusDefault = radiusDefault;
    }

    public Circle() {
    }

    private void getRadius() {
        if (radiusDefault != 0)
            radius = radiusDefault;
        else
            radius = Math.sqrt(Math.pow(pointOnLine.getX() + centre.getX(), 2) +
                    Math.pow(pointOnLine.getY() + centre.getY(), 2));
    }

    @Override
    public double getPerimetr() {
        this.getRadius();
        return 2 * radius * Math.PI;
    }

    @Override
    public double getArea() {
        this.getRadius();
        return 2 * Math.PI * Math.pow(radius, 2);
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public Point getPointOnLine() {
        return pointOnLine;
    }

    public void setPointOnLine(Point pointOnLine) {
        this.pointOnLine = pointOnLine;
    }

    public double getRadiusDefault() {
        return radiusDefault;
    }

    public void setRadiusDefault(double radiusDefault) {
        this.radiusDefault = radiusDefault;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centre=" + centre.getX() + " " + centre.getY() +
                ", radius=" + radius +
                '}';
    }
}
