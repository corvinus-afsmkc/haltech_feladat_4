package afsmkc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String reply = null;
        Scanner sc = new Scanner(System.in);

        Socket s = new Socket("localhost", 8080);
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        ClientThread ClientThread = new ClientThread(s);
        new Thread(ClientThread).start();

        pw.println("--Felhaszn�l�1 bel�pett--");
            
        String name = ("Felhaszn�l�1: ");
        while(true) {
        	reply = sc.nextLine();            
            pw.println(name + reply);
        }               
    }
}