package wycieczki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grupa {
	public int id;
	public int licznosc;
	public List<String> preferencje = new ArrayList<>();
	
	public Grupa(String s) {
		super();
		String[] gr;
		gr = s.split("\t");
    	id = Integer.parseInt(gr[0]);
    	licznosc = Integer.parseInt(gr[1]);
    	gr = gr[2].split(", ");
    	for (int j= 0; j < gr.length; j++) {
			preferencje.add(gr[j]);
		}
    	
	}

	
}
