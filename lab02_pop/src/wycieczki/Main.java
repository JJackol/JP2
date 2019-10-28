package wycieczki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import perm.VariationGenerator;



public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		List<Grupa> gs = new ArrayList<>();	
		List<Wycieczka> ws = new ArrayList<>();
		try
		{
			File f = new File("Grupy.txt");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            gs.add(new Grupa(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try
		{
			File f = new File("Wycieczki.txt");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            ws.add(new Wycieczka(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int k=gs.size();
		int n=ws.size() +1;
		int v = VariationGenerator.pow(n, k);
		int[][] vars =new int[v][0];
		
		VariationGenerator x = new VariationGenerator (n, k);
		int i=0;
		while (x.hasMore ()) {
			int[] var = x.getNextVar();
			vars[i++] = var;	  
		}	
		while(i>0) {
			i--;
			for (int j = 0; j < vars[i].length; j++) {
				System.out.print(vars[i][j] + " ");
			}					
			System.out.println(Manager.det(vars[i], gs, ws));	
			System.out.println();
			
		}
//		for(int i1=0; i1< vars.length; i1++) {
//			for (int j = 0; j < vars[i1].length; j++) {
//				//System.out.print(vars[i1][j]+" ");
//			}				
//			System.out.print(vars[i1]);
//
//			System.out.println(Manager.det(vars[i1], gs, ws));	
//			System.out.println();	
//		}

		System.out.println("a");
	}

}
