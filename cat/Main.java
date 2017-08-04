package cat;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Snow", "wight", 2, 3);

        cat1.sayMew();
        System.out.println(cat1);

        Cat cat2 = new Cat("Sleepy", "Gray", 3, 2.5);

        cat2.sleep();
        System.out.println(cat2);
    }
}
