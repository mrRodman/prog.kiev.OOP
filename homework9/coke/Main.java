package coke;

public class Main {
    public static void main(String[] args) {
        CokeAutomat cokeAutomat = new CokeAutomat(2);
        cokeAutomat.addToQueue("Sheldon");
        cokeAutomat.addToQueue("Leonard");
        cokeAutomat.addToQueue("Volovitc");
        cokeAutomat.addToQueue("Kutrapalli");
        cokeAutomat.addToQueue("Penny");

        cokeAutomat.drink();
    }
}
