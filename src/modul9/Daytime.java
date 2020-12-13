package modul9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Daytime {
    public Date getDateFromNetwork() throws IOException, ParseException{
        try(Socket socket = new Socket("time.nist.gov", 13)){
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()){
                time.append((char) c);
            }
            return parseDate(time.toString());
        }
    }

    private Date parseDate(String s) throws ParseException{
        String[] piece = s.split(" ");
        String dateTime = piece[1]+ " " +piece[2]+ " UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        return format.parse(dateTime);
    }

    public static void main(String[] args) {
        Daytime dt = new Daytime();
        try{
            System.out.println(""+dt.getDateFromNetwork());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
