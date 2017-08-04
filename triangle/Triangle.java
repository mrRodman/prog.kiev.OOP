package triangle;

public class Triangle {
    private double a;
    private double b;
    private double c;
    private double halfPerimetr;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void halfPerimetr() {
        this.halfPerimetr = (a + b + c) / 2;
    }

    public double area() {
        double p = this.getHalfPerimetr();
        double area = Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);

        return area;
    }

    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double area = Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);

        return area;

    }

    public double getHalfPerimetr() {
        return (a + b + c) / 2;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
