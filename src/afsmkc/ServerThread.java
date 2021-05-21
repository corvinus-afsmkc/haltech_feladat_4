package afsmkc;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Thread for Server
 */
public class ServerThread extends Thread {

    private Socket socket;
    private ArrayList<Socket> clients;
    private HashMap<Socket, String> clientNameList;

    public ServerThread(Socket socket, ArrayList<Socket> clients, HashMap<Socket, String> clientNameList) {
        this.socket = socket;
        this.clients = clients;
        this.clientNameList = clientNameList;
    }

    @Override
    public void run() {        
            BufferedReader input = null;
			try {
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
            while (true) {
                String outputString = null;
				try {
					outputString = input.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}                
                    System.out.println(outputString);
                    sendMessage(socket, outputString);
                }            
        }

    private void sendMessage(Socket sender, String outputString) {
        Socket s;
        PrintWriter pw;
        int i = 0;
        while (i < clients.size()) {
            s = clients.get(i);
            i++;
            try {
                if (s != sender) {
                    pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println(outputString);
                }
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }
}