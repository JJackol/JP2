/**
 * 
 */
package lab03;

/**
 * @author jaca
 *
 */
public class Klient {
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
	
	public String getRecord() {
		return "";
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
