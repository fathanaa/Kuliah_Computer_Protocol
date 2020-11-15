package modul5_koneksinet_bag2.program5;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

class GetIPAddress {
    public static void main(String[] args) throws UnknownHostException {
        String s = "http://www.google.com";
        try {
            InetAddress ip = InetAddress.getByName(new URL(s).getHost());
            System.out.println("Public IP Address of: "+ip);
        } catch (MalformedURLException e){
            System.out.println("Invalid URL");
        }
    }
}

