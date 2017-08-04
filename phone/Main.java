package phone;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Red", "123");
        Phone phone2 = new Phone("Black", "345");
        Phone phone3 = new Phone("Green", "678");

        phone1.registerNumber();
        phone2.registerNumber();

        phone1.call("345");
        phone1.call("222");
    }
}
