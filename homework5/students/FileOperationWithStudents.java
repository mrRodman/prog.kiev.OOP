package students;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class FileOperationWithStudents {
    public static void wirteGroupToFile(File out, Group group) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output = NULL");
        }
        Throwable throwable = null;
        Object var3_4 = null;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            bw.write("name\t");
            bw.write("age\t");
            bw.write("rating\n");
            for (int i = 0; i < group.getGroup().length; i++) {
                if (group.getGroup()[i] != null) {
                    bw.write(group.getGroup()[i].toString());
                }
            }
        }
    }

    public static Group readGroupFromFile(File in, Group group) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("In = NULL");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(in))) {
            String[] headlines = br.readLine().split("\t");
            System.out.println(Arrays.toString(headlines));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                String name = "";
                int age = 0;
                double rating = 0;

                for (int i = 0; i < headlines.length; i++) {
                    if (headlines[i].equals("name")) {
                        name = data[i];
                    }
                    if (headlines[i].equals("age")) {
                        age = Integer.parseInt(data[i]);
                    }
                    if (headlines[i].equals("rating")) {
                        rating = Double.parseDouble(data[i]);
                    }
                }
                group.addStudent(new Student(name, age, rating));
            }
            return group;
        }
    }
}
