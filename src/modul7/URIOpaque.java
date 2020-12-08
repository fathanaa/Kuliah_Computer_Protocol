package modul7;

import java.net.URI;

public class URIOpaque {
    public static void main(String[] args) throws Exception{
        URI u1 = new URI("mailto:java-net@java.oracle.com");
        URI u2 = new URI("http://www.oracle.com/download");
        URI u3 = new URI("oracle.com/download");

        System.out.println("The URI is "+ u1);

        if (u1.isOpaque()){
            System.out.println("This is an opaque URI");
        }else if (u1.isAbsolute()){
            System.out.println("This is an absolute URI");
        }else {
            System.out.println("This is no an URI");
        }

        System.out.println("The URI is "+ u2);

        if (u2.isOpaque()){
            System.out.println("This is an opaque URI");
        }else if (u2.isAbsolute()){
            System.out.println("This is an absolute URI");
        }else {
            System.out.println("This is no an URI");
        }

        System.out.println("The URI is "+ u3);

        if (u3.isOpaque()){
            System.out.println("This is an opaque URI");
        }else if (u3.isAbsolute()){
            System.out.println("This is an absolute URI");
        }else {
            System.out.println("This is no an URI");
        }
    }
}
