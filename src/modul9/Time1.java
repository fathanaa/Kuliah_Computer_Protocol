package modul9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Time1 {
    private static final String HOSTNAME = "time.nist.gov";
    public static void main(String[] args) throws IOException, ParseException{
        Date d = Time1.getDateFromNetwork();
        System.out.println(" it is "+ d);
    }

    private static Date getDateFromNetwork() throws IOException, ParseException{
        /*
        The time protocol sets the epoch at 1900, the java Date class at 1970.
        This number converts between them. long differenceBetweenOpech = 2208988000L;
        if you'd rather not use the magic number, uncomment the following section
        which calculates it directly
        */

        TimeZone gmt = TimeZone.getTimeZone("GMT");
        Calendar epoch1900 = Calendar.getInstance(gmt);
        epoch1900.set(1900,01,01,00,00,00);
        long epoch1900ms = epoch1900.getTime().getTime();
        Calendar epoch1970 = Calendar.getInstance(gmt);
        epoch1970.set(1970,01,01,00,00,00);
        long epoch1970ms = epoch1970.getTime().getTime();
        long differenceInms = epoch1970ms - epoch1900ms;
        long diffBetweenEpoch = differenceInms / 1000;

        Socket socket = null;
        Date time = null;
        try {
            socket = new Socket(HOSTNAME, 37);
            socket.setSoTimeout(15000);
            InputStream raw = socket.getInputStream();
            long secondsSince1900 = 0;
            for (int i = 0; i < 4; i++) {
                secondsSince1900 = (secondsSince1900 << 8) | raw.read();
            }
            long secondsSince1970 = secondsSince1900 - diffBetweenEpoch;
            long msSince1970 = secondsSince1970 * 1000;
            time = new Date(msSince1970);
            // }finally{
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            if (socket != null) socket.close();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        return time;
    }
}
