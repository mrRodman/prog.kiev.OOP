package response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ResponseServer implements Runnable{
    private Socket soc;
    private Thread thread;
    private int numberOfRequest;

    public ResponseServer(Socket soc, int numberOfRequest) {
        this.soc = soc;
        this.numberOfRequest = numberOfRequest;
        thread = new Thread(this);
        thread.start();
    }

    public ResponseServer() {
    }

    @Override
    public void run() {
        try (InputStream is = soc.getInputStream(); OutputStream os = soc.getOutputStream();
             PrintWriter pw = new PrintWriter(os)){

            byte[] recv = new byte[is.available()];
            is.read(recv);
            String response = createResponse();
            pw.print(response);
            pw.flush();
        } catch (IOException e) {
                 e.printStackTrace();
        }
    }

    private String createResponse() {
        StringBuilder response = new StringBuilder();
        response.append("Number of rec " + numberOfRequest);
        response.append(" OS: ");
        response.append(System.getProperty("os.name"));
        response.append("\n" + "free memory: ");
        response.append(Runtime.getRuntime().freeMemory());
        response.append("\n" + "max memory: ");
        response.append(Runtime.getRuntime().maxMemory());
        response.append("\n" + "available processors: ");
        response.append(Runtime.getRuntime().availableProcessors());
        response.append("\n" + "total memory: ");
        response.append(Runtime.getRuntime().totalMemory());

        String res = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" +
                "Content-Type: text/html\r\n"+ "Content-Length: " + "\r\n" +
                "Connection: close\r\n\r\n";
        res += "<html><head></head><body>" + response.toString() +"</body></html>";
        return res;
    }
}
