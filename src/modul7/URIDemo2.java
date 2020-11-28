package modul7;

import java.net.URI;

public class URIDemo2 {
    public static void main(String[] args) throws Exception{
        String str = "https://en.wikibooks.org/wiki/Java_Programming/Byte_Code#Example";

        URI uri = new URI(str);

        System.out.println("Host = "+ uri.getHost());
        System.out.println("Port = "+ uri.getPort());
        System.out.println("Raw Path = "+ uri.getRawPath());
        System.out.println("Path"+ uri.getPath());
        System.out.println("Query = "+ uri.getQuery());
        System.out.println("Raw Query = "+ uri.getRawQuery());
        System.out.println("Fragment = "+ uri.getFragment());
        System.out.println("Raw Fragment = "+uri.getRawFragment());

        URI uri2 = new URI("https://fr.wikibooks.org/wiki/D%C3%A9velopper_en_Java/La_machine_virtuelle_Java_(JVM)");
        System.out.println("CompareTo = "+ uri.compareTo(uri2));
        System.out.println("Equals = "+ uri.equals(uri2));
        System.out.println("Hashcode = "+ uri.hashCode());
        System.out.println("toStrong = "+ uri.toString());
        System.out.println("toASCIIString = "+ uri.toASCIIString());

    }
}
