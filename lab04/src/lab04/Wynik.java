package lab04;

 
public class Wynik implements GetRecordI{
	
	
	int index;
	int wynik;
	String imie;
	
	
	public Wynik(int wynik, String imie) {
		super();
		this.wynik = wynik;
		this.imie = imie;
	}
	
	public Wynik(String csv_line) {
		super();
		String strs[] = csv_line.split(",");
		
		this.wynik = Integer.parseInt(strs[0]);
		this.imie = strs[1];
		
	}

	@Override
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(wynik);
		builder.append(",");
		builder.append(imie);
		
		return builder.toString();
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public int getWynik() {
		return wynik;
	}


	public void setWynik(int wynik) {
		this.wynik = wynik;
	}


	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}
	
	

}


