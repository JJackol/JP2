package lab03;

public class Tor {
	int idToru;
	int liczbaMiejsc;
	boolean dostepny;
	
	public Tor(int idToru, int liczbaMiejsc, boolean dostepny) {
		super();
		this.idToru = idToru;
		this.liczbaMiejsc = liczbaMiejsc;
		this.dostepny = dostepny;
	}
	
	public Tor(String csv_line) {
		super();
		String strs[] = csv_line.split(",");
		
		this.idToru = Integer.parseInt(strs[0]);
		this.liczbaMiejsc = Integer.parseInt(strs[1]);
		this.dostepny = Boolean.parseBoolean(strs[2]);
	}
	
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		builder.append(idToru);
		builder.append(liczbaMiejsc);
		builder.append(dostepny);
		return builder.toString();
	}
	

}
