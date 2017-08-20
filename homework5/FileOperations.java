import java.io.*;

public class FileOperations {

    public FileOperations() {
    }

    public static void copyWithSomeExtension (File in, File out, String... extensions) throws IOException {
        if (in == null || out == null)
            throw new IllegalArgumentException("Null");

        FileCheck fileCheck = new FileCheck(extensions);

        File[] files = in.listFiles(fileCheck);

        for (File file : files) {
            fileCopy(file, out);
        }
    }

    private static void fileCopy (File in, File out) throws IOException {
        if (in == null || out == null)
            throw new IllegalArgumentException("Null??? But how???");

        File fileOut = new File(out.getAbsolutePath() + "/" + in.getName());

        try (InputStream fis = new FileInputStream(in);
             OutputStream fos = new FileOutputStream(fileOut)) {
            byte[] buffer = new byte[1024 * 1024];

            while (fis.available() > 0) {
                int byteRead = fis.read(buffer);
                fos.write(buffer, 0, byteRead);
            }
        }
    }

    private static class FileCheck implements FileFilter {
        private String[] extensions;

        private FileCheck(String... extensions) {
            this.extensions = extensions;
        }

        private boolean extensionsCheck (String extension) {
            for (String temp : extensions) {
                if (extension.equals(temp))
                    return true;
            }
            return false;
        }

        @Override
        public boolean accept(File pathname) {
            int dotIndex = pathname.getName().lastIndexOf('.');

            if (dotIndex == -1)
                return false;

            String extension = pathname.getName().substring(dotIndex + 1);
            return extensionsCheck(extension);
        }
    }
}
