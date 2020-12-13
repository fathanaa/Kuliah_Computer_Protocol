package modul9;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Socketinfo {
    public static void main(String[] args) {
        for (String host : args){
            try{
                Socket theSocket = new Socket(host,80);
                System.out.println("Connected to"
                    + theSocket.getInetAddress()
                    + " on port "+theSocket.getPort()
                    + " from port "
                    + theSocket.getLocalPort()+" of "
                    + theSocket.getLocalAddress());
            }catch (UnknownHostException ex){
                System.out.println("I cant find "+host);
            }catch (SocketException ex){
                System.out.println("Couldnt connect to "+host);
            }catch (IOException ex){
                System.out.println(ex);
            }
        }
    }
}
