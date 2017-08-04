package triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3,  4, 5);

        System.out.println(triangle1.area());

        Triangle triangle2 = new Triangle(4, 5, 6);

        System.out.println(triangle2.area());

        System.out.println(Triangle.area(3, 4, 5));
    }
}
