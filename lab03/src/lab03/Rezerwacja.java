package lab03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rezerwacja implements GetRecordI{

	private int id;
	private int nr_toru;
	private int liczba_osob;
	private int cena;
	private Date date;
	private int czas;
	private SimpleDateFormat dateFormat;
	
	public Rezerwacja(String csv_line) {
		super();
		
		dateFormat = new SimpleDateFormat("yyyy-mm-dd hh");
		String strs[] = csv_line.split(",");
		this.id = Integer.parseInt(strs[0]);
		this.nr_toru = Integer.parseInt(strs[1]);
		this.liczba_osob = Integer.parseInt(strs[2]);
		this.cena = Integer.parseInt(strs[3]);
		try {
			this.date = dateFormat.parse(strs[4]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.czas = Integer.parseInt(strs[5]);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNr_toru() {
		return nr_toru;
	}

	public void setNr_toru(int nr_toru) {
		this.nr_toru = nr_toru;
	}

	public int getLiczba_osob() {
		return liczba_osob;
	}

	public void setLiczba_osob(int liczba_osob) {
		this.liczba_osob = liczba_osob;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCzas() {
		return czas;
	}

	public void setCzas(int czas) {
		this.czas = czas;
	}

	@Override
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(',');
		builder.append(nr_toru);
		builder.append(',');
		builder.append(liczba_osob);
		builder.append(',');
		builder.append(cena);
		builder.append(',');
		builder.append(dateFormat.format(date));
		builder.append(',');
		builder.append(czas);
		return builder.toString();
	}

	public Rezerwacja(int id, int nr_toru, int liczba_osob, Date date, int czas) {
		super();
		int stawka = 50;
		this.id = id;
		this.nr_toru = nr_toru;
		this.liczba_osob = liczba_osob;
		this.date = date;
		this.czas = czas;
		this.cena = czas*stawka;
	}
}
