package translate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Translater implements Serializable{
    private File englishFile;
    private File ukrainianFile;
    private File dictionaryFile;
    private Map<String, String> dictionary;

    public Translater(File englishFile, File ukrainianFile, File dictionaryFile) {
        this.dictionary = new HashMap<>();
        this.englishFile = englishFile;
        this.ukrainianFile = ukrainianFile;
        this.dictionaryFile = dictionaryFile;
    }

    public Translater() {
        this.dictionary = new HashMap<>();
    }

    public void translate() {
        fillDictionary();
        String[] words = getEngText().split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\W", "");
        }

        StringBuilder ukrText = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (dictionary.containsKey(words[i]))
                ukrText.append(dictionary.get(words[i]) + " ");
            else
                ukrText.append(words[i] + " ");
        }
        writeUkrText(ukrText.toString());

    }

    private String getEngText() {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(englishFile))) {
            StringBuilder sb = new StringBuilder();
            for (;br.ready();)
                sb.append(br.readLine());
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private void writeUkrText(String ukr) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ukrainianFile))){
            bw.write(ukr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillDictionary() {
        if (dictionaryFile == null) {
            System.err.println("No such file");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dictionaryFile))){
            dictionary = (HashMap)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addNewWord(String eng, String ukr) {
        if (dictionary.isEmpty())
            fillDictionary();
        if (eng != null && ukr != null)
            dictionary.put(eng, ukr);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dictionaryFile))){
            oos.writeObject(dictionary);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        for (Map.Entry<String, String> map : dictionary.entrySet()) {
            dictionary.remove(map.getKey());
        }
    }

    public File getEnglishFile() {
        return englishFile;
    }

    public void setEnglishFile(File englishFile) {
        this.englishFile = englishFile;
    }

    public File getUkrainianFile() {
        return ukrainianFile;
    }

    public void setUkrainianFile(File ukrainianFile) {
        this.ukrainianFile = ukrainianFile;
    }

    public File getDictionaryFile() {
        return dictionaryFile;
    }

    public void setDictionaryFile(File dictionaryFile) {
        this.dictionaryFile = dictionaryFile;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
