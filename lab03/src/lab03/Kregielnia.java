package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;



public class Kregielnia {
	private String nazwa;
	int liczbaTorow;
	
	List<Tor> listaTorow;

	public Kregielnia() {
		super();
		try
		{
			File f = new File("Tory.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            listaTorow.add(new Tor(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.nazwa = "Moja Kregielnia";
		this.liczbaTorow = listaTorow.size();
	}
		

}//koniec klasy kregielnia
