package homework.figures;

import homework.Shape;

public class Circle extends Shape {
    private double xCentre;
    private double yCentre;
    private double xRadius;
    private double yRadius;
    private double radiusDefault;

    private double radius;

    /**
     *
     * constructor with some dot on the line
     */
    public Circle(double xCentre, double yCentre, double xRadius, double yRadius) {
        this.xCentre = xCentre;
        this.yCentre = yCentre;
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    /**
     *
     * constructor with radius
     */

    public Circle(double xCentre, double yCentre, double radiusDefault) {
        this.xCentre = xCentre;
        this.yCentre = yCentre;
        this.radiusDefault = radiusDefault;
    }

    public Circle() {
    }

    private void getRadius() {
        if (radiusDefault != 0)
            radius = radiusDefault;
        else
            radius = Math.sqrt(Math.pow(xRadius + xCentre, 2) + Math.pow(yRadius + yCentre, 2));
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

    public double getxCentre() {
        return xCentre;
    }

    public void setxCentre(double xCentre) {
        this.xCentre = xCentre;
    }

    public double getyCentre() {
        return yCentre;
    }

    public void setyCentre(double yCentre) {
        this.yCentre = yCentre;
    }

    public double getxRadius() {
        return xRadius;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public void setyRadius(double yRadius) {
        this.yRadius = yRadius;
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
                "xCentre=" + xCentre +
                ", yCentre=" + yCentre +
                '}';
    }
}
