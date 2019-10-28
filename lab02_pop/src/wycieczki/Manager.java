package wycieczki;

import java.util.List;

public class Manager {
	
	static boolean isValid(int [] var, List<Grupa> gs, List<Wycieczka> ws) {
		int [] wolne_miejsca = new int[ws.size()+1];
		for (int i = 0; i < ws.size(); i++) {
			wolne_miejsca[i] = ws.get(i).liczbaMiejsc;
		}
		
		for (int i = 0; i < var.length; i++) {
			wolne_miejsca[var[i]] -= gs.get(i).licznosc;
			
		}
		for (int i = 0; i < wolne_miejsca.length-1; i++) {
			if(wolne_miejsca[i] < 0)
				return false;
		}		
		return true;
	}
		
		static int det(int [] var, List<Grupa> gs, List<Wycieczka> ws) {
			if(!isValid(var, gs, ws))
				return -1;
			
			int d1 = det1(var, gs, ws);
			int d2 = 0;
			int d3 = det3(var, gs, ws);
			int d4 = det4(var, gs, ws);	
			
			int m1 = 10;
			int m2 = 0;
			int m3 = 10;
			int m4 = 0;
			int d = d1*m1 + d2*m2 + d3*m3/1000 + d4*m4;						
							
			
			return d;
			
	}

	static int det1(int [] var, List<Grupa> gs, List<Wycieczka> ws ) {
		if(!isValid(var, gs, ws))
			return -1;
		int d1 = 0;
		int d1max = 10;
		for (int i = 0; i < var.length; i++) {
			// d1 1. kryteruim
			if(var[i] < ws.size()) {
				String cel = ws.get(var[i]).cel;
				
				int pref;
				if(gs.get(i).preferencje.contains(cel)) {
					pref = gs.get(i).preferencje.indexOf(cel);
					int l = gs.get(i).licznosc;
					d1 += l * d1max/(pref+1);
				}
				else { 
					d1 += 0;						
				}
			}
			else d1 = 0;
		}
		return d1;
	}
	
	static int det3(int [] var, List<Grupa> gs, List<Wycieczka> ws ) {
		if(!isValid(var, gs, ws))
			return -1;
		int d3 = 0;
		int d1max = 10;
		for (int i = 0; i < var.length; i++) {
		//d3 3. kryterium
			if(var[i] < ws.size()) {
				int koszt = ws.get(var[i]).cena * gs.get(i).licznosc;
				d3 += koszt;
			}
			else { 
				d3 += 0;
			}
		}
		return d3;
	}
	
	static int det4(int [] var, List<Grupa> gs, List<Wycieczka> ws ) {
		if(!isValid(var, gs, ws))
			return -1;
		int d3 = 0;
		
		int d1max = 100;
		for (int i = 0; i < var.length; i++) {
			// d1 1. kryteruim
			if(var[i] < ws.size()) {
				int koszt = ws.get(var[i]).cena * gs.get(i).licznosc;
				d3 += d1max - koszt;
			}
			else { 
				d3 += 0;
			}
		}
		return d3;
	}

}
////d3 3. kryterium
//if(var[i] < ws.size()) {
//	int koszt = ws.get(var[i]).cena * gs.get(i).licznosc;
//}
//else { 
//		d3 += 0;						
////}
//}
//else d3 = 0;

