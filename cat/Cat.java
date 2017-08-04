package cat;

public class Cat {
    private String name;
    private String color;
    private int age;
    private double weight;

    public Cat() {}

    public Cat(String name, String color, int age, double weight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void sayMew () {
        System.out.println("Mew");
    }

    public void sleep() {
        System.out.println("zzz");
    }

    @Override
    public String toString() {
        return "Cat's " +
                "name is " + name + '\n' +
                "color is " + color + '\n' +
                "age is " + age + '\n' +
                "weight is " + weight +
                '\n';
    }
}
