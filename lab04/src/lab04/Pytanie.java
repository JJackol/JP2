package lab04;

import org.json.simple.JSONObject;

public class Pytanie {
	public String nazwa;
	public String tresc;
	public String A;
	public String B;
	public String C;
	public String D;
	public String poprawna;
	
	public Pytanie(String nazwa, String tresc, String a, String b, String c, String d, String poprawna) {
		super();
		this.nazwa = nazwa;
		this.tresc = tresc;
		this.A = a;
		this.B = b;
		this.C = c;
		this.D = d;
		this.poprawna = poprawna;
	}	
	public Pytanie(String nazwa) {
		super();
		this.nazwa = nazwa;
		this.tresc = "???";
		this.A = "a";
		this.B = "b";
		this.C = "c";
		this.D = "d";
		this.poprawna = "A";
	}
	
	public Pytanie(JSONObject obj){
		this.nazwa = (String) obj.get("nazwa");
		this.tresc = (String) obj.get("tresc");
		this.A = (String) obj.get("A");
		this.B = (String) obj.get("B");
		this.C = (String) obj.get("C");
		this.D = (String) obj.get("D");
		this.poprawna = (String) obj.get("poprawna");
		
	
	}
	
	public void zapisz(String nazwa, String tresc, String a, String b, String c, String d, String poprawna) {
		
		this.nazwa = nazwa;
		this.tresc = tresc;
		this.A = a;
		this.B = b;
		this.C = c;
		this.D = d;
		this.poprawna = poprawna;
	}	
}
