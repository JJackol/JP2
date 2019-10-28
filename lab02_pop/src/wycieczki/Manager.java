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
			
			int d1=0, d2=0, d3=0, d4=0;
			int d1max = 10, d2max, d3max, d4max;
			for (int i = 0; i < var.length; i++) {
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
		
		return d1 + d2 + d3 + d4;
	}

}
