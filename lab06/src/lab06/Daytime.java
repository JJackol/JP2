package lab06;

import java.io.*;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import org.omg.CORBA.portable.InputStream;

public class Daytime {
	InetAddress server;
	int port = 13;

	public static void main(String[] args) {
		try {
			System.out.println("proba");
			Daytime d = new Daytime("tempus1.gum.gov.pl");
			System.out.println(d.getTime());
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	public Daytime() throws UnknownHostException {
		this(InetAddress.getLocalHost());
	}

	public Daytime(String name) throws UnknownHostException {
		this(InetAddress.getByName(name));
	}

	public Daytime(InetAddress server) {
		this.server = server;
	}

	public String getTime() {
		if (server == null)
			return (new Date()).toString();
		try {
			Socket s = new Socket(server, port);
			java.io.InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String theLine;
			while ((theLine = br.readLine()) != null) {
				sb.append(theLine + "\r\n");
			}
			return sb.toString();
		} catch (IOException ex) {
			return (new Date()).toString();
		}
	}
}
