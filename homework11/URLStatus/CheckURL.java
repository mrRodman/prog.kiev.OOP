package URLStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class CheckURL {

    public CheckURL() {
    }

    public static void checkURLStatus(File file) {
        String[] urls = readURLFromFile(file);

        for (String link : urls) {
            try {
                URL url = new URL(link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                System.out.println(httpURLConnection.getResponseMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] readURLFromFile(File file) {
        try {
            if (file == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while (br.ready()) {
                sb.append(br.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().split("\n");
    }
}
