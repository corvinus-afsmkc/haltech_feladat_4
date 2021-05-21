package afsmkc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        HashMap<Socket, String> clientNameList = new HashMap<Socket, String>();
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("--Szerver elindult--");
            while (true) {
                Socket s = ss.accept();
                clients.add(s);
                ServerThread ServerThread = new ServerThread(s, clients, clientNameList);
                ServerThread.start();
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
