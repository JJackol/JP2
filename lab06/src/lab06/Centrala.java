package lab06;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

class PaczkomatData{
	public int id;
	public int port;
}

public class Centrala implements Runnable {
	LinkedList<PaczkomatData> lista;

    private int port = 8081;
    private ServerSocket serverSocket = null;
    private Thread thread = null;
    
    public Centrala() {
    	try {
            serverSocket = new ServerSocket(port);
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    @Override
    public void run() {
        while (thread != null) {
        	
        	
            try {
            	Socket s = serverSocket.accept();

				PrintWriter pw = new PrintWriter(s.getOutputStream());
				InputStreamReader sc = new InputStreamReader(s.getInputStream());
				System.out.println("got client");
				
				char[] buf = new char[256];
				sc.read(buf);
				String input = new String(buf);
				String[] data = input.split(",");
				
				switch(data[0]) {

				case "getId":
					if(tryGetPort(data[1]) != null ) {
						
					}
					break;
				case "register":
					if (register(data[1])){
						
					}
					else {
						
					}
					break;
					
				default:;
						
				}
				
					
				s.close();
				
                //System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");
                //System.out.println("Waiting for client...");
                // wait until client socket connecting, then add new thread
                //addThreadClient(serverSocket.accept());
            } catch (IOException e) {
                System.out.println("Error : " + e);
            }
        }
    }

    private Integer tryGetPort(String string) {
    	int getId = Integer.parseInt(string);
    	for(PaczkomatData d : lista) {
    		if(d.id == getId)
    			return d.port;
    	}
		return null;
	}

	private boolean register(String string) {

    	int newId = Integer.parseInt(string);
    	for(PaczkomatData d : lista) {
    		if(d.id == newId)
    			return false;
    	}
		return true;
	}

	public void addThreadClient(Socket socket) {
        //client = new ChatServerThread(this, socket);
        //client.start();
    }

}
