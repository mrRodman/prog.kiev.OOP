package response;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket soc = new ServerSocket(8080)){
            int numberOfRequest = 0;
           for (;;) {
               numberOfRequest++;
               Socket income = soc.accept();
               ResponseServer rs = new ResponseServer(income, numberOfRequest);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
