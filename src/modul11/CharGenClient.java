package modul11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class CharGenClient {
    public static int DEFAULT_PORT = 19;
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Usage: java chargen host [port]");
            return;
        }
        int port;
        try{
            port = Integer.parseInt(args[1]);
        }catch (RuntimeException ex){
            port = DEFAULT_PORT;
        }
        try {
            SocketAddress address = new InetSocketAddress(args[0], port);
            SocketChannel client = SocketChannel.open(address);
            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);
            System.out.println("running ...");
            while (client.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }catch (IOException ex){
            System.out.println(ex);
            //ex.printStackTrace();
        }
    }
}
