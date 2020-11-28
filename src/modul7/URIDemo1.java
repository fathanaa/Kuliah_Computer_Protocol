package modul7;

import java.net.URI;

public class URIDemo1 {
    public static void main(String[] args) throws Exception{
        String uribase = "https://www.wikipedia.org/";
        String urirelative = "languages/../java";
        String str = "https://upload.wikimedia.org/wikipedia/commons/e/e7/Java_Programming.pdf";

        URI uriBase = new URI(uribase);

        URI uri = URI.create(str);

        System.out.println("");
        System.out.println("Base URI = "+uribase.toString());
        URI uriRelative = new URI(urirelative);
        System.out.println("Relative URI = "+uriRelative.toString());
        URI uriResolved = uriBase.resolve(uriRelative);
        System.out.println("Resolved URI = "+ uriResolved.toString());
        URI uriRelativized = uriBase.relativize(uriResolved);
        System.out.println("Relative URI = "+uriRelative.toString());
        System.out.println(uri.normalize().toString());
        System.out.println("Scheme = "+uri.getScheme());
        System.out.println("Raw Scheme = "+ uri.getRawSchemeSpecificPart());
        System.out.println("Scheme-specific part = "+ uri.getSchemeSpecificPart());
        System.out.println("Raw User Info = "+uri.getRawUserInfo());
        System.out.println("Authority = "+ uri.getAuthority());
        System.out.println("Raw authority = "+uri.getRawAuthority());
    }
}
