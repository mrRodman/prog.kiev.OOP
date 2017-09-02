package students;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOperationWithStudents {
    public static void wirteGroupToFile(File out, Group group) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output = NULL");
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(out))) {
            oos.writeObject(group);
        }
    }

    public static Group readGroupFromFile(File in, Group group) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("In = NULL");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(in))) {
            group = (Group) ois.readObject();
                
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            return group;
    }
}