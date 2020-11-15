package modul4_koneksinet_bag1.program2;

import java.net.InetAddress;

public class CompareAddress {
    public static void main(String[] args) throws Exception {
        String a1 = "www.google.kz";
        String a2 = "www.google.co.id";
        InetAddress ca = InetAddress.getByName(a1);
        InetAddress com = InetAddress.getByName(a2);
        System.out.println(ca.getHostAddress()+" is "+ca.getHostName());
        System.out.println(com.getHostAddress());
        if (ca.equals(com)){
            System.out.println(a1+" is the same as "+a2);
        }else {
            System.out.println(a1+" and "+a2+" are not the same");
        }
    }
}
