package homework2;

import homework2.figures.Circle;
import homework2.figures.Square;
import homework2.figures.Triangle;

public class Main {
    public static void main(String[] args) {

        Triangle triangle = new Triangle(new Point(3, 4), new Point(5, 6), new Point(7, 8));
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimetr());
        System.out.println();

        Square square = new Square(new Point(2, 3), new Point(4, 5));

        System.out.println(square.getPerimetr());
        System.out.println(square.getArea());
        System.out.println();

        Circle circle1 = new Circle(new Point(5, 7), 9);
        System.out.println(circle1.getArea());
        System.out.println(circle1.getPerimetr());

        Circle circle2 = new Circle(new Point(9, 5), new Point(5, 7));
        System.out.println(circle2.getArea());
        System.out.println(circle2.getPerimetr());

        Board board = new Board();

        board.addShape(triangle);
        board.addShape(circle1);
        board.addShape(square);
        board.addShape(circle2);
        board.addShape(new Triangle());
        board.removeShape(4);
        board.removeShape(2);
        board.removeShape(2);
        board.print();
    }
}
