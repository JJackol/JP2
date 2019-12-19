package lab03;

public class Tor implements GetRecordI{
	int idToru;
	int liczbaMiejsc;
	boolean dostepny;
	
	public Tor(int idToru, int liczbaMiejsc, boolean dostepny) {
		super();
		this.idToru = idToru;
		this.liczbaMiejsc = liczbaMiejsc;
		this.dostepny = dostepny;
	}
	
	public int getIdToru() {
		return idToru;
	}

	public void setIdToru(int idToru) {
		this.idToru = idToru;
	}

	public int getLiczbaMiejsc() {
		return liczbaMiejsc;
	}

	public void setLiczbaMiejsc(int liczbaMiejsc) {
		this.liczbaMiejsc = liczbaMiejsc;
	}

	public boolean isDostepny() {
		return dostepny;
	}

	public void setDostepny(boolean dostepny) {
		this.dostepny = dostepny;
	}

	public Tor(String csv_line) {
		super();
		String strs[] = csv_line.split(",");
		
		this.idToru = Integer.parseInt(strs[0]);
		this.liczbaMiejsc = Integer.parseInt(strs[1]);
		this.dostepny = Boolean.parseBoolean(strs[2]);
	}
	
	@Override
	public String getRecord() {
		StringBuilder builder = new StringBuilder();
		builder.append(idToru);
		builder.append(',');
		builder.append(liczbaMiejsc);
		builder.append(',');
		builder.append(dostepny);
		return builder.toString();
	}
	

}
