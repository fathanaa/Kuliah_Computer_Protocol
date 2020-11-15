package modul4_koneksinet_bag1.program1;

import java.net.InetAddress;

public class GetAllByName {
    public static void main(String[] args) throws Exception{
        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        for (InetAddress address : addresses) {
            System.out.println(address);
        }
    }
}
