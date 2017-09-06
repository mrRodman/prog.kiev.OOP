package chars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharsCount {
    private static String text;

    public CharsCount() {
    }

    public static void createList(File file) {
        readFromFile(file);
        if (text.equals("")) {
            System.err.println("File is empty!");
            return;
        }
        char[] tempChars = text.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < tempChars.length; i++) {
            if (tempChars[i] > 64 && tempChars[i] < 123 && !chars.contains(tempChars[i]))
                chars.add(tempChars[i]);
        }
        chars.sort((Character c1, Character c2) -> c1 - c2);
        chars.sort((Character c1, Character c2) -> countChars(c1, tempChars) - countChars(c2, tempChars));
        System.out.println(chars);
    }

    private static int countChars(char c, char[] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c)
                count++;
        }
        return count;
    }

    private static void readFromFile(File file) {
        if (file == null) {
            System.err.println("No such file");
            return;
        }
        text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while (br.ready())
                text += br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
