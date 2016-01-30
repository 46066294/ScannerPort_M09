/**
 * Created by Mat on 30/01/2016.
 */

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScannerPort_main {

    public static void main(String[]args){
        ExecutorService executor = Executors.newCachedThreadPool();

        int ini = 1,fin = 100;
        while(fin <= 65500){
            executor.execute(new Run(ini,fin));
            fin += 100;
            ini += 100;
        }
        executor.execute(new Run(65501,65535));

    }

}

class Run implements Runnable{
    int puerto = 0;
    int fin;
    public Run(int port,int fin){
        puerto = port;
        this.fin = fin;
    }

    public void run(){
        Scanner Scanner = new Scanner(puerto, fin);
    }
}


class Scanner {

    public Scanner(int puerto, int fin){

        Socket socket;
        String ip = "localhost";

        for(int port = puerto; port <= fin; port++){
            try{
                socket = new Socket(ip, port);

                System.out.println("Puerto " + port + " Abierto");
                socket.close();
            }
            catch(Exception ex){

            }

        }
    }
}
