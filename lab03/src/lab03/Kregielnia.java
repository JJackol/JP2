package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Kregielnia {
	private String nazwa;
	int liczbaTorow;
	private int mode;
	
	List<Tor> listaTorow;
	List<Klient> listaKlientow;
	List<Rezerwacja> listaRezerwacji;
	

	public Kregielnia() {
		super();
		
		listaTorow = new ArrayList<Tor>();
		try
		{
			File f = new File("Tory.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            if (!str.isEmpty())
	            	listaTorow.add(new Tor(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		listaKlientow = new ArrayList<Klient>();
		try
		{
			File f = new File("Klienci.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            if (!str.isEmpty())
	            	listaKlientow.add(new Klient(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		listaRezerwacji = new ArrayList<Rezerwacja>();
		try
		{
			File f = new File("Rezerwacje.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            if (!str.isEmpty())
	            	listaRezerwacji.add(new Rezerwacja(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.nazwa = "Moja Kregielnia";
		this.liczbaTorow = listaTorow.size();
	}
	
	public void saveState() {
		try (PrintWriter out = new PrintWriter("Tory.csv")) {
		    for (Tor tor : listaTorow) {
				out.println(tor.getRecord());
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try (PrintWriter out = new PrintWriter("Klienci.csv")) {
		    for (Klient klient : listaKlientow) {
				out.println(klient.getRecord());
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter("Rezerwacje.csv")) {
		    for (Rezerwacja rez : listaRezerwacji) {
				out.println(rez.getRecord());
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Zaloguj sie jako klient [1]");
		mode = s.nextInt();
		return mode;
	}
	
	public boolean dodajRezerwacje(Rezerwacja r) {
		listaRezerwacji.add(r);		
		return true;
	}	
	
	public boolean dodajKLienta(Klient k) {
		listaKlientow.add(k);		
		return true;
	}
		
	public boolean dodajTor(Tor t) {
		listaTorow.add(t);		
		return true;
	}
	
	public boolean usunRezerwacje(int id) {
		Rezerwacja rez = null;
		for (Rezerwacja rezerwacja : listaRezerwacji) {
			if(rezerwacja.getId() == id);
				rez = rezerwacja;
		}
		listaRezerwacji.remove(rez);
		return true;
	}	
	
	public boolean usunKlienta(int id) {
		Klient kli = null;
		for (Klient klient : listaKlientow) {
			if(klient.getId() == id);
				kli = klient;
		}
		listaRezerwacji.remove(kli);
		return true;
	}
	
	public boolean usunTor(int id) {
		Tor t = null;
		for (Tor tor : listaTorow) {
			if(tor.getIdToru() == id);
				t = tor;
		}
		listaRezerwacji.remove(t);
		return true;
	}
	
}//koniec klasy kregielnia
