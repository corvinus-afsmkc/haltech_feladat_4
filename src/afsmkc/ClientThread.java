package afsmkc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientThread implements Runnable {

    private Socket socket;
    private BufferedReader br;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = br.readLine();
                System.out.println(message);
            }
        }
        catch (IOException e) {
        	e.printStackTrace();
        } 
        finally {
                try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}           
            }
        }
    }
