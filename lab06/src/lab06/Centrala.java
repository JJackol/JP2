package lab06;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

class PaczkomatData{
	public int id;
	public int port;
	public PaczkomatData(int id, int port) {
		super();
		this.id = id;
		this.port = port;
	}
	
}

public class Centrala implements Runnable {
	LinkedList<PaczkomatData> lista;

    private int port = 9999;
    private ServerSocket serverSocket = null;
    private Thread thread = null;
    
    public Centrala() {
    	lista = new LinkedList<PaczkomatData>();
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

		Centrala c = new Centrala();
	}
	
    @Override
    public void run() {
        while (thread != null) {
        	
        	
            try {
            	while(true) {
	            	Socket s = serverSocket.accept();
	            		
	            	//socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
	    			OutputStream out = s.getOutputStream();		
	    			
	    			
	    				
	    			
	    			
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					InputStreamReader sc = new InputStreamReader(s.getInputStream());
					System.out.println("got client");
					
					char[] buf = new char[256];
					while(!sc.ready()) {
						Thread.yield();
					}
					sc.read(buf);
					String input = new String(buf);
					String[] data = input.split(",");
					
					switch(data[0]) {
	
					case "getId":
						int dest = tryGetPort(data[1]);
						if( dest > 0 ) {
							out.write(String.valueOf(dest).getBytes());
							out.flush();
						}
						break;
					case "register":
						if (register(data[1], data[2])){
							out.write("ok".getBytes());
							out.flush();
						}
						else {
							
						}
						break;
						
					default:;
							
					}
					
						
					s.close();
            	}
				
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

	private boolean register(String string, String port) {
    	int newId = Integer.parseInt(string.trim());
    	int destport = Integer.parseInt(port.trim());
    	for(PaczkomatData d : lista) {
    		if(d.id == newId)
    			return false;
    	}

		lista.add(new PaczkomatData(newId, destport));
		return true;
	}

	public void addThreadClient(Socket socket) {
        //client = new ChatServerThread(this, socket);
        //client.start();
    }

}
