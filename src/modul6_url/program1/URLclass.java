package modul6_url.program1;

import java.net.MalformedURLException;
import java.net.URL;

public class URLclass {
    public static void main(String[] args) throws MalformedURLException {
        // creates a URL with string representation.
        URL url1 = new URL("https://www.google.co.id/search?safe=strict&fulltext&q=ieee+xplore#member");
        // creates a URL with a protocol,hostname,and path
        URL url2 = new URL("https://indonesia@ieee.org");
        URL url3 = new URL("https://www.google.co.id/search?"+ "safe=strict&full%20text&q=ieee+xplore#member");
        // print the string representation of the URL.
        System.out.println(url1.toString());
        System.out.println(url2.toString());
        System.out.println("Different components of the URL3-");
        // retrieve the protocol for the URL
        System.out.println("Protocol:- " + url3.getProtocol());
        // retrieve the hostname of the url
        System.out.println("Hostname:- " + url3.getHost());
        // retrieve the default port
        System.out.println("Default port:- " + url3.getDefaultPort());
        // retrieve the authority part of URL
        System.out.println("Authority:- " + url3.getAuthority());
        // retrieve the query part of URL
        System.out.println("Query:- " + url3.getQuery());
        // retrive the path of URL
        System.out.println("Path:- " + url3.getPath());
        // retrive the file name
        System.out.println("File:- " + url3.getFile());
        // retrieve the user info
        System.out.println("User info:- " + url2.getUserInfo());
        // retrieve the reference
        System.out.println("Reference:- " + url3.getRef());
        // retrieve the equality
        System.out.println("Equals?: " + url1.equals(url3));
    }
}
