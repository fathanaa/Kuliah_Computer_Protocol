package modul5_koneksinet_bag2.program3;

public class CheckInternetConnectivity {
    public static void main(String[] args) throws Exception{
        Process process = java.lang.Runtime.getRuntime().exec("ping www.google.com");
        int x = process.waitFor();
        if (x == 0){
            System.out.println("Connection Succesful, "+" Output was "+x);
        }else {
            System.out.println("internet not connected, "+" Output was "+x);
        }
    }
}

