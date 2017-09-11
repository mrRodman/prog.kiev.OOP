package translate;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File eng = new File("e:/English.txt");
        File ukr = new File("e:/Ukrainian.txt");
        File dic = new File("e:/3.txt");
        Translater translater = new Translater(eng, ukr, dic);

        translater.translate();

        System.out.println(translater.getDictionary());
    }

}
