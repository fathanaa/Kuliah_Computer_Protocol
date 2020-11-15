package modul4_koneksinet_bag1.program5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PingWebsite {
    static void commands(ArrayList<String> commandList)
        throws Exception{
        ProcessBuilder build = new ProcessBuilder(commandList);
        Process process = build.start();
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String s = null;
        System.out.println("Standard output: ");
        while ((s = input.readLine()) != null){
            System.out.println(s);
        }
        System.out.println("error (if any): ");
        while((s = Error.readLine()) != null){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> commandList = new ArrayList<String>();
        commandList.add("ping");
        commandList.add("www.google.com");
        PingWebsite.commands(commandList);
    }
}
