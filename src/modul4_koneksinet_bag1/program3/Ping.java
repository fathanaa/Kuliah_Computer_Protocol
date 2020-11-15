package modul4_koneksinet_bag1.program3;

import java.net.InetAddress;

public class Ping {
    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getByName("web.mit.edu");
        System.out.println("Name: "+address.getHostName());
        System.out.println("Address: "+address.getHostAddress());
        System.out.println("Reach: "+address.isReachable(3000));
    }
}
