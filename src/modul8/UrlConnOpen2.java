package modul8;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnOpen2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            try {
                String encoding = "ISO-8859-1";
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                String contentType = uc.getContentType();
                try {
                    int encodingStart = contentType.indexOf("charset=");
                    if (encodingStart != -1){
                        encoding = contentType.substring(encodingStart + 8);
                    }
                }catch (Exception e){
                    System.out.println(e);
                    InputStream in = new BufferedInputStream(uc.getInputStream());
                    Reader r = new InputStreamReader(in, encoding);
                    int c;
                    while ((c = r.read()) != -1){
                        System.out.println((char) c);
                    }
                    r.close();
                }
            }catch (MalformedURLException ex){
                System.err.println(args[0]+" is not a parseable URL");
            }catch (UnsupportedEncodingException ex){
                System.err.println("Servent sent an encoding java does not support: "+ex.getMessage());
            }catch (IOException ex){
                System.out.println(ex);
            }
        }
    }
}
