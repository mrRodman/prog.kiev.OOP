import java.io.*;

public class Dublicates {
    public Dublicates() {
    }

    public static void getDublicates(File in1, File in2, File out) throws IOException {
        if (in1 == null || in2 == null || out == null) {
            throw new IllegalArgumentException("NULL");
        }

        String string1 = "";
        String string2 = "";

        string1 = readLines(in1);
        string2 = readLines(in2);

        String[] words1 = getWords(string1);
        String[] words2 = getWords(string2);

        String result = getMatches(words1, words2);

        String[] temp = result.split(" ");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            bw.write(result.trim());
        }
        System.out.println();
    }

    private static String readLines (File in) throws IOException {
        String string1 = "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br1 = new BufferedReader(new FileReader(in))){
            for (;(string1 = br1.readLine()) != null;) {
                sb.append(string1);
            }
        }
        return sb.toString();
    }

    private static String[] getWords(String s) {
        String[] words;
        if (s.contains(" "))
            words = s.split(" ");
        else
            words = new String[] {s};

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\W", " "); //delete . , : and so on
            words[i].trim();
        }
        return words;
    }

    private static String getMatches(String[] words1, String[] words2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words2.length; j++) {
                if (words1[i].equalsIgnoreCase(words2[j])) {
                    if (sb.toString().contains(words2[j]))
                        continue;
                    sb.append(words2[j]);
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
