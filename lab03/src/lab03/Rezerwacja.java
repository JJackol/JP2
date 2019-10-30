package lab03;

import java.util.Date;

public class Rezerwacja {
	private int nr_toru;
	private int liczba_osob;
	private int cena;
	private Date date;
	
	public Rezerwacja(String csv_line) {
		super();
		String strs[] = csv_line.split(",");
		
		this.nr_toru = Integer.parseInt(strs[0]);
		this.liczba_osob = Integer.parseInt(strs[1]);
		this.cena = Integer.parseInt(strs[2]);
	}
	
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		builder.append(nr_toru);
		builder.append(liczba_osob);
		builder.append(cena);
		return builder.toString();
	}
}
