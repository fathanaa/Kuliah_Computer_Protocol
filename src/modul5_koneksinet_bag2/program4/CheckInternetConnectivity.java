package modul5_koneksinet_bag2.program4;

import java.net.URL;
import java.net.URLConnection;

class CheckInternetConnectivity {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.co.id/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Connection Succesful");
        }catch (Exception e){
            System.out.println("Connection isnt succesful");
        }
    }
}
