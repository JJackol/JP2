package lab06;

import java.awt.EventQueue;
import java.io.BufferedReader;
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
		
		
		//register(id);
//		try {
//			
//			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);
//			
//			out = socketInfo.getOutputStream();			
//			String test = "test_paczkomatu";
//				
//			out.write( test.getBytes(), 0, test.length());
//			out.flush();
//			
//			PrintWriter pw = new PrintWriter(socketInfo.getOutputStream());
//			pw.write("test_paczkomatu".toCharArray());
//			
//			socketInfo.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
		
		try {	
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			Socket socket = new Socket(InetAddress.getByName(host), port);
			out = socket.getOutputStream();		
			
			in = socketCentr.getInputStream();
				
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
		try {			
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
			out = socketCentr.getOutputStream();		
			
			in = socketCentr.getInputStream();
				
			out.write( builder.toString().getBytes(), 0, builder.length());
			out.flush();
			info.write( builder.toString().getBytes(), 0, builder.length());
			info.flush();
			
			String verify = new String();
			while(in.read(buf)>0) {	
				verify += String.valueOf(buf);
				
			}
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
		try {			
			socketInfo = new Socket(InetAddress.getByName(hostInfo), portInfo);			
			info = socketInfo.getOutputStream();	
			
			socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
			out = socketCentr.getOutputStream();		
			
			in = socketCentr.getInputStream();
				
			out.write( builder.toString().getBytes(), 0, builder.length());
			out.flush();
			info.write( builder.toString().getBytes(), 0, builder.length());
			info.flush();
			
			//int inSize = ;
			
			String verify = new String();
			while(in.read(buf)>0) {	
				verify += String.valueOf(buf);
				if(verify.equals("ok")) {
					isRegistered = true;	
				}
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
		char[] buf = new char[256];
		
		try {
        	while(true) {
            	Socket s = myServerSocket.accept();
            		
            	//socketCentr = new Socket(InetAddress.getByName(hostCentr), portCentr);
    			OutputStream out = s.getOutputStream();		
    			
    	
				sc = new InputStreamReader(s.getInputStream());
			
				
				sc.read(buf);
				String input = new String(buf);
				String[] data = input.split(",");
				
				switch(data[0]) {

				case "getId":
					if(null != null ) {
						//todo
					}
					break;
				case "register":
					if (true){
						out.write("ok".getBytes());
						out.flush();
					}
					else {
						;
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
