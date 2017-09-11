package art;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("e:/art.txt");
        Art art = new Art(file);
        System.out.println(art.convent("hello world"));
    }
}
