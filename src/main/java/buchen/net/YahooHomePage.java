package buchen.net;

import java.io.*;
import java.net.Socket;

/**
 * Connect to Yahoo's web server
 */
public class YahooHomePage {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.yahoo.com", 80);    //TCP
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.write("GET /index.html\n\n");
        writer.flush();

        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
