/**
 * 
 */
package lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author jaca
 *
 */
public class BazaPytan {
	private String nazwaBazy;
	private ArrayList<Pytanie> pytania;
	
	public BazaPytan(String nazwaBazy) {
		super();
		this.nazwaBazy = nazwaBazy;
		this.pytania = new ArrayList<Pytanie>();
	}
	
	public BazaPytan(String nazwaPliku, boolean fromFile) {
		super();
		this.nazwaBazy = new String(nazwaPliku.split("\\.")[0]);
		this.pytania = new ArrayList<Pytanie>();
		load(nazwaPliku);
		
	}
	
	
	
	public void load(String nazwaPliku) {
//todo parsowanie do poprawy// done
		JSONObject baza = new JSONObject();
		JSONObject pytObj = new JSONObject();
		
		try (FileReader in = new FileReader(nazwaPliku) ){
			try {
				
				JSONParser parser = new JSONParser();
				
				Object obj = parser.parse(in);
				JSONObject jo = (JSONObject)obj;
				System.out.println( jo.toJSONString() );
				
				JSONArray jsonArr = (JSONArray) jo.get("baza");

				System.out.println( jsonArr.toJSONString() );
				jsonArr.forEach(pyt -> pytania.add(new Pytanie((JSONObject)pyt)) );
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			BazaPytan nowa = new BazaPytan(nazwaBazy);
			nowa.save();
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void save() {
		JSONObject outJsonObject = new JSONObject();
		JSONArray baza = new JSONArray();
		JSONObject pytObj = new JSONObject();

		//for (int i = 0; i < pytania.size(); i++)
		for (Pytanie p : pytania) {
			pytObj.put("nazwa", p.nazwa);
			pytObj.put("tresc", p.tresc);
			pytObj.put("A", p.A);
			pytObj.put("B", p.B);
			pytObj.put("C", p.C);
			pytObj.put("D", p.D);
			pytObj.put("poprawna", p.poprawna);

			baza.add( pytObj.clone() );

			pytObj.clear();			
		}
		//System.out.println(baza.toJSONString());
		outJsonObject.put("baza", baza);      
		//System.out.println( outJsonObject.toJSONString() );
      
	try (PrintWriter out =  new PrintWriter(nazwaBazy+".json") ){
		try {
			outJsonObject.writeJSONString(out);
			//System.out.println( outJsonObject.toJSONString() );
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
   }
   public static void main(String[] args) {
	   BazaPytan b = new BazaPytan("test.json", true);
	   b.save();
	   
   }

public String getNazwaBazy() {
	return nazwaBazy;
}

public void setNazwaBazy(String nazwaBazy) {
	this.nazwaBazy = nazwaBazy;
}

public ArrayList<Pytanie> getPytania() {
	return pytania;
}

public void setPytania(ArrayList<Pytanie> pytania) {
	this.pytania = pytania;
}

public void nowePytanie(String string) {
	pytania.add(new Pytanie(string));
	
}

public void zapiszPytanieCache(int sel, Pytanie nowe) {
	Pytanie p = pytania.get(sel);
	p.zapisz(nowe.nazwa, nowe.tresc, nowe.A, nowe.B, nowe.C, nowe.D, nowe.poprawna);
	
}
}

