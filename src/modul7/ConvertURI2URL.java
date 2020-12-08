package modul7;

import java.net.URI;
import java.net.URL;

public class ConvertURI2URL {
    public static void main(String[] args) throws Exception{
        URL url = null;
        URI uri = null;

        uri = new URI("file://D:/1.4/Ex1.java");
        System.out.println("URI: "+uri);

        url = uri.toURL();
        System.out.println("URL: "+url);

        uri = new URI(url.toString());
        System.out.println("URI: "+uri);

        uri = url.toURI();
        System.out.println("URI: "+ uri);
    }
}
