package modul8;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnOpen {
    public static void main(String[] args) {
        if (args.length > 0){
            try {
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()){
                    InputStream buffer = new BufferedInputStream(raw);
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1){
                        System.out.println((char) c);
                    }
                }catch (MalformedURLException ex){
                    System.err.println(args[0] + "is not a parsable URL");
                }
            }catch (IOException ex){
                System.err.println(ex);
            }
        }
    }
}
