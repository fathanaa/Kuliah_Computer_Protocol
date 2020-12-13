package modul10;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

public class LocalPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 65536; port++){
            try {
                ServerSocket server = new ServerSocket(port);
            }catch (IOException ex){
                System.out.println("There is a server on port "+port);
            }
        }
    }
}
