package modul10;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {
    public final static int PORT = 8;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)){
            while (true){
                System.out.println("The Server Stand by ... ");
                try (Socket connection = server.accept()){
                    System.out.println("Client connected");
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString()+"\r\n");
                    out.flush();
                    connection.close();
                }catch (IOException ioex){
                    // ignore
                }
            }
        }catch (IOException ioex){
            System.out.println(ioex);
        }
    }
}
