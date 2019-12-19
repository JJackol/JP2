/**
 * 
 */
package lab03;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author jaca
 *
 */
public class Klient implements GetRecordI{
	private int id;
	private String imie;
	private String nazwisko;
	private String pesel;
	
	public Klient(int id, String imie, String nazwisko, String pesel) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
	}
	
	public Klient(String csv_line) {
		super();
		
		
		String strs[] = csv_line.split(",");
		
		this.id = Integer.parseInt(strs[0]);
		this.imie = strs[1];
		this.nazwisko = strs[2];
		this.pesel = strs[3];
		
	}
	
	@Override
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(',');
		builder.append(imie);
		builder.append(',');
		builder.append(nazwisko);
		builder.append(',');
		builder.append(pesel);
		return builder.toString();
	}

	
	//
	//gettery
	//

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public int getId() {
		return id;
	}
	
	
	

}//koniec class Klient
