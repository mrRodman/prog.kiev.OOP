package homework;

public class Board {
    private Shape[] shapes = new Shape[4];

    public void addShape(Shape shape) {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] == null) {
                shapes[i] = shape;
                return;
            }
        }
        System.out.println("Board is full");
    }

    public void removeShape(int index) {
        if (index > 3 || index < 0) {
            System.out.println("Write correct index!");
            return;
        }

        if (shapes[index] != null)
            shapes[index] = null;
        else
            System.out.println("Place is already empty");
    }

    public void print() {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null) {
                System.out.printf("index %d %s\n", i,shapes[i].toString());
            }
        }
    }
}
