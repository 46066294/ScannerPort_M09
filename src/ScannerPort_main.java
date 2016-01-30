import java.net.Socket;

/**
 * Created by Mat on 30/01/2016.
 */

public class ScannerPort_main {
    public static void main(String[] args) {
        Socket socket;
        String ip = "localhost";

        for(int port = 0; port <= 13000; port++){
            try{
                socket = new Socket(ip, port);

                System.out.println("Puerto " + port + " Abierto");
                socket.close();
            }
            catch(Exception ex){
                //ex.printStackTrace();
            }
        }
    }
}
/*
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScannerPort_main {

    public static void main(String[]args){
        ExecutorService executor = Executors.newCachedThreadPool();

        int ini = 0, fin = 65536;
        while(ini <= 65536){
            executor.execute(new Run(ini,fin));
            fin++;
            ini++;
        }
        //executor.execute(new Run(65501,65535));//65536

    }

}

class Run implements Runnable{
    int puerto;
    int fin;
    public Run(int port,int fin){
        puerto = port;
        this.fin = fin;
    }

    public void run(){
        ScannerPort scanner = new ScannerPort(puerto, fin);
    }
}


class ScannerPort {

    public ScannerPort(int puerto, int fin){

        Socket socket;
        String ip = "localhost";

        for(int port = puerto; port <= fin; port++){
            try{
                socket = new Socket(ip, port);

                System.out.println("Puerto " + port + " Abierto");
                socket.close();
            }
            catch(Exception ex){
                //ex.printStackTrace();
            }

        }
    }
}
*/