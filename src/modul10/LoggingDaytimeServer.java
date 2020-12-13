package modul10;

import modul9.Daytime;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDaytimeServer {
    public final static int PORT = 7;
    private final static Logger auditLogger = Logger.getLogger("request");
    private final static Logger errorLogger = Logger.getLogger("error");

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try(ServerSocket server = new ServerSocket(PORT)){
            while (true){
                try{
                    Socket connection = server.accept();
                    Callable<Void> task = new DaytimeTask(connection);
                    pool.submit(task);
                }catch (IOException ioex){
                    errorLogger.log(Level.SEVERE, "accept error", ioex);
                }catch (RuntimeException ex){
                    errorLogger.log(Level.SEVERE,"Unexpected Error" + ex.getMessage(), ex);
                }
            }
        }catch (IOException ex){
            errorLogger.log(Level.SEVERE, "Couldnt start server", ex);
        }catch (RuntimeException ex){
            errorLogger.log(Level.SEVERE,"Couldnt start server: "+ex.getMessage(),ex);
        }
    }
    private static class DaytimeTask implements Callable<Void>{
        private Socket connection;
        DaytimeTask(Socket connection){
            this.connection = connection;
        }

        @Override
        public Void call(){
            try {
                Date now = new Date();
                auditLogger.info(now+""+connection.getRemoteSocketAddress());
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                out.write(now.toString());
                out.flush();
            }catch (IOException ioex){
                // disconnected
            }finally {
                try {
                    connection.close();
                }catch (IOException ioex){
                    // ignore
                }
            }
            return null;
        }
    }
}
