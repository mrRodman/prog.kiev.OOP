package coke;

import java.util.ArrayDeque;

public class CokeAutomat {
    private int numberOfCokes;
    private ArrayDeque<String> queue;

    public CokeAutomat(int numberOfCokes) {
        this.numberOfCokes = numberOfCokes;
        queue = new ArrayDeque<>();
    }

    public CokeAutomat() {
    }

    public void drink() {
        for (int i = 0; i < numberOfCokes; i++) {
            String temp = queue.pop();
            queue.add(temp);
            queue.add(temp);
        }
        System.out.println(queue);
    }

    public void addToQueue(String  s) {
        queue.add(s);
    }

    public int getNumberOfCokes() {
        return numberOfCokes;
    }

    public void setNumberOfCokes(int numberOfCokes) {
        this.numberOfCokes = numberOfCokes;
    }
}
