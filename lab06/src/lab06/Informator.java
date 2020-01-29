package lab06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.LinkedList;

public class Informator implements Runnable {

    private int port = 7777;
    private ServerSocket serverSocket = null;
    private Thread thread = null;
    private LinkedList<String> stringBuffer;
    
    public Informator() {
    	stringBuffer = new LinkedList<String>();
    	try {
            serverSocket = new ServerSocket(port);
            System.out.println("Informator started on port " + serverSocket.getLocalPort() + "...");
            System.out.println("Waiting for client...");
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
	}

	public static void main(String[] args) {
		Informator informator = new Informator();
		

	}
	
    @Override
    public void run() {
		while (thread != null) {
			try {
				while (true) {
					Socket s = serverSocket.accept();
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					InputStreamReader sc = new InputStreamReader(s.getInputStream());
					
					
					
					char[] buf = new char[256];
					sc.read(buf);
					System.out.println(String.valueOf(buf));
					s.close();
				}
			}catch(Exception e) {
				
			}
		}
    }

}
