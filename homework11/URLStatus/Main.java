package URLStatus;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("e:/1.txt");
        CheckURL.checkURLStatus(file);
    }
}
