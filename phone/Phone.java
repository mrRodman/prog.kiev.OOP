package phone;

public class Phone {
    private String color;
    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public Phone(String color, String number) {
        this.color = color;
        this.number = number;
    }

    public void registerNumber() {
        if (!Network.isNumberPresent(this.number))
            Network.addNumber(this);
    }

    public void call(String number) {
        System.out.println("Phone " + this.toString() + " is calling on number " + number);

        if (Network.isNumberPresent(number) && !this.number.equals(number)) {
            Network.transfer(number);
        }
        else
            System.out.println("Wrong number");
    }

    public void receiveCall() {
        System.out.println(this.toString());
        System.out.println("Ring Ring");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone " +
                "color=" + color +
                ", number=" + number;
    }
}
