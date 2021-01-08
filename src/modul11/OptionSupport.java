package modul11;

import java.io.IOException;
import java.net.*;
import java.nio.channels.*;
public class OptionSupport {
    public static void main(String[] args) {
        try{
            printOptions(SocketChannel.open());
            printOptions(ServerSocketChannel.open());
            printOptions(AsynchronousSocketChannel.open());
            printOptions(AsynchronousServerSocketChannel.open());
            printOptions(DatagramChannel.open());
        }catch(Exception e){System.out.println(e);}
    }
    private static void printOptions(NetworkChannel channel) throws IOException {
        System.out.println(channel.getClass().getSimpleName()
                + " supports:");
        try{
            for (SocketOption<?> option : channel.supportedOptions()) {
                System.out.println(option.name() + ": "
                        + channel.getOption(option));
            }
        }catch(Exception e){System.out.println(e);}
        System.out.println();
        channel.close();
    }
}