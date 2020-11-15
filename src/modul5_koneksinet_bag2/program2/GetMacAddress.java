package modul5_koneksinet_bag2.program2;

import  java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class GetMacAddress {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)){
            displayInterfaceInformation(netint);
        }
    }

    private static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
            System.out.printf("Display name: %s%n", netint.getDisplayName());
            System.out.printf("Name: %s%n", netint.getName());
            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(inetAddresses)){
                System.out.println("InetAddress: %s%n"+ inetAddress);
            }
            System.out.printf("Parent: %s%n", netint.getParent());
            System.out.printf("Up? %s%n", netint.isUp());
            System.out.printf("Loopback? %s%n", netint.isLoopback());
            System.out.printf("PointToPoint? %s%n", netint.isPointToPoint());
            System.out.printf("Supports multicast? %s%n", netint.isVirtual());
            System.out.printf("Virtual? %s%n", netint.isVirtual());
            System.out.printf("Hardware address: %s%n",Arrays.toString(netint.getHardwareAddress()));
            List<InterfaceAddress> interfaceAddresses = netint.getInterfaceAddresses();
            for (InterfaceAddress addr : interfaceAddresses){
                System.out.println("InterfaceAddress: %s%n"+ addr.getAddress());
            }
            System.out.println();
            Enumeration<NetworkInterface> subInterfaces = netint.getSubInterfaces();
            for (NetworkInterface networkInterface : Collections.list(subInterfaces)){
                System.out.println("%n SubInterface %n");
                displayInterfaceInformation(networkInterface);
            }
            System.out.println();
    }
}
