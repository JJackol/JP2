package lab06;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Paczkomat implements Runnable {
	private int id;
	boolean isRegistered = false;
	
	private int myPort = 0;
	private ServerSocket myServerSocket = null;
	
	private String hostInfo = "localhost";
    private int portInfo = 7777;
    private String hostCentr = "localhost";
    private int portCentr = 9999;
    
    private Socket socketInfo = null;
    private Socket socketCentr = null;
    private Thread thread = null;
    OutputStream out ;
    OutputStream info ;
    InputStream in ;
    Random random;
    PaczkomatWindow window;
    
	public Paczkomat() {
		super();
		random = new Random();
		id = random.nextInt(1000);
		InetSocketAddress informatorAddr = new InetSocketAddress(hostInfo, portInfo);
		InetSocketAddress centrAddr = new InetSocketAddress(hostCentr, portCentr);
		
		try {
			myServerSocket = new ServerSocket(0);
			myPort = myServerSocket.getLocalPort();
			
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Paczkomat(PaczkomatWindow w) {
		super();
		window = w;
		random = new Random();
		id = random.nextInt(1000);
		InetSocketAddress informatorAddr = new InetSocketAddress(hostInfo, portInfo);
		InetSocketAddress centrAddr = new InetSocketAddress(hostCentr, portCentr);
		
		try {
			myServerSocket = new ServerSocket(0);
			myPort = myServerSocket.getLocalPort();
			
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread odbiur = new Thread(this);
		odbiur.start();
		
		
	}
	
	public void send(String host, int port, Paczka paczka) {
		byte[] buf = new byte[256];
		StringBuilder builder = new StringBuilder("send,");
		builder.append(paczka.imieFrom);
		builder.append(",");
		builder.append(paczka.telFrom);
		builder.append(",");
		builder.append(paczka.imieTo);
		builder.append(",");
		builder.append(paczka.telTo);
		builder.append(",");
		builder.append(paczka.msg);
		builder.append("\n");
		
		try {	
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			Socket socket = new Socket(InetAddress.getByName(host), port);
			out = socket.getOutputStream();		
			
			//in = socketCentr.getInputStream();
				
			out.write( builder.toString().getBytes(), 0, builder.length());
			out.flush();
			info.write( builder.toString().getBytes(), 0, builder.length());
			info.flush();
			
			
			
			//PrintWriter pw = new PrintWriter(socketInfo.getOutputStream());
			//pw.write("test_paczkomatu".toCharArray());

			socketInfo.close();
			socketCentr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId(int _id) {

		byte[] buf = new byte[256];
		StringBuilder builder = new StringBuilder("getId,");
		builder.append(_id);
		builder.append("\n");
		try {			
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
			out = socketCentr.getOutputStream();		
		
			out.write( builder.toString().getBytes(), 0, builder.length());
			out.flush();
			info.write( builder.toString().getBytes(), 0, builder.length());
			info.flush();
			
			DataInputStream in = new DataInputStream(new BufferedInputStream(socketCentr.getInputStream()));

			String verify = in.readLine();
			
			int t_port = Integer.parseInt(verify.trim());
			if(t_port>0) {
				return t_port;				
			}
			//PrintWriter pw = new PrintWriter(socketInfo.getOutputStream());
			//pw.write("test_paczkomatu".toCharArray());

			socketInfo.close();
			socketCentr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	
	}

	public void register(int _id) {
		if(isRegistered) return;

		byte[] buf = new byte[256];
		StringBuilder builder = new StringBuilder("register,");
		builder.append(_id);
		builder.append(",");
		builder.append(myPort);
		builder.append("\n");
		try {			
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
			out = socketCentr.getOutputStream();		
			
			//in = socketCentr.getInputStream();

			
			out.write( builder.toString().getBytes(), 0, builder.length());
			out.flush();
			info.write( builder.toString().getBytes(), 0, builder.length());
			info.flush();
			
			DataInputStream in = new DataInputStream(
					new BufferedInputStream(socketCentr.getInputStream()));
			
			
			
			String verify = in.readLine();			
			if(verify != null && verify.equals("ok\n")) {
				isRegistered = true;	
			}
			
			
			//PrintWriter pw = new PrintWriter(socketInfo.getOutputStream());
			//pw.write("test_paczkomatu".toCharArray());

			socketInfo.close();
			socketCentr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Paczkomat p = new Paczkomat();
	}

	@Override
	public void run() {
		
		InputStreamReader sc;
		
		
		try {
        	while(true) {
            	Socket s = myServerSocket.accept();
            		
            	//socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
    			OutputStream out = s.getOutputStream();		
    			DataInputStream in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
				
				String input = in.readLine();
				System.out.println(input);
				window.refreshBufor(input);
				
				String[] data = input.split(",");	
				
//				switch(data[0]) {
//				case "getId":
//					if(null != null ) {}					
//				case "register":					
//					break;					
//				default:;
			
				s.close();
			}
					
				
        }
			
        catch (IOException e) {
            System.out.println("Error : " + e);
        }	
		
	}

}
