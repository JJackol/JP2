package lab06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Paczkomat implements Runnable {
	private long id;

	private String host = "localhost";
    private int port = 7777;
    private Socket socket = null;
    private Thread thread = null;
    OutputStream out ;
    
	public Paczkomat(long id) {
		super();
		//InetAddress inet = new InetSocketAddress("localhost", 9000);
		
		try {
			
			socket = new Socket(InetAddress.getByName(host), port);
			
			out = socket.getOutputStream();			
			String test = "test_paczkomatu";
				
			out.write( test.getBytes(), 0, test.length());
			out.flush();
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write("test_paczkomatu".toCharArray());
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Paczkomat p = new Paczkomat(1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
