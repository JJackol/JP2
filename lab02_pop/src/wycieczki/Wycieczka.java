package wycieczki;

public class Wycieczka {
	public String cel;
	public int liczbaMiejsc;
	public int cena;
	
	Wycieczka(String _cel, int l, int c){
		cel = _cel;
		liczbaMiejsc = l;
		cena = c;
	}
	
	Wycieczka(String str){
		super();
		String[] gr;
		gr = str.split("\t");
    	cel = gr[0];
    	liczbaMiejsc = Integer.parseInt(gr[1]);
    	cena = Integer.parseInt(gr[2]); 
	}
	
	
}
