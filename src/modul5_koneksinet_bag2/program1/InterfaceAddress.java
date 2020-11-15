package modul5_koneksinet_bag2.program1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;

public class InterfaceAddress {
    public static void main(String[] args) throws SocketException {
        NetworkInterface nif = NetworkInterface.getByIndex(1);
        List<java.net.InterfaceAddress> list = nif.getInterfaceAddresses();
        for (java.net.InterfaceAddress iaddr : list){
            System.out.println("getAdress(): "+iaddr.getAddress());
            System.out.println("getBroadcast(): "+iaddr.getBroadcast() );
            System.out.println("Hashcode: "+iaddr.hashCode());
            System.out.println("toString(): "+iaddr.toString());
            System.out.println();
        }
    }
}
