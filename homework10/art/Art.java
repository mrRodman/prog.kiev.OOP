package art;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Art {
    private StringBuilder art;
    private File file;

    public Art(File file) {
        this.file = file;
    }

    public Art() {
    }

    public String convent(String text) {
        text = text.toUpperCase();
        char[] chars = text.toCharArray();
        char[] alphabet = initAlphabet();
        String[] artFont = readArt(file);
        Map<Character, String> textConvent = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < alphabet.length; i++) {
            textConvent.put(alphabet[i], artFont[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result.append("\n\n\n\n");
                continue;
            }
            result.append(textConvent.get(chars[i]));
        }
        return result.toString();
    }

    private String[] readArt(File file){
        art = new StringBuilder();
        try {
            if (file == null) {
                throw new NullPointerException("NO SUCH FILE");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            for (;br.ready();)
                art.append(br.readLine() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return art.toString().split("                 ");
    }

    private char[] initAlphabet() {
        char[] chars = new char[26];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (65 + i);
        }
        return chars;
    }

    public StringBuilder getArt() {
        return art;
    }
}
