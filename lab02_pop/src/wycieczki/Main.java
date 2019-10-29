package wycieczki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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
//		while(i>0) {
//			i--;
//			for (int j = 0; j < vars[i].length; j++) {
//				System.out.print(vars[i][j] + " ");
//			}					
//			System.out.println(Manager.det(vars[i], gs, ws));	
//			System.out.println();
//			
//		}
		
		int results0 [] = new int [vars.length];
		int results1 [] = new int [vars.length];
		int results2 [] = new int [vars.length];
		int results3 [] = new int [vars.length];
		int results4 [] = new int [vars.length];
		
		for(int i1=0; i1< vars.length; i1++) {
			System.out.print(i1+" -- ");	
			for (int j = 0; j < vars[i1].length; j++) {
				System.out.print(vars[i1][j]+" ");
			}

			
			System.out.print("\t === \t");	
			System.out.print(Manager.det(vars[i1], gs, ws)+"\t");	
			System.out.print(Manager.det1(vars[i1], gs, ws)+"\t");	
			System.out.print(Manager.det2(vars[i1], gs, ws)+"\t");	
			System.out.print(Manager.det3(vars[i1], gs, ws)+"\t");	
			System.out.print(Manager.det4(vars[i1], gs, ws)+"\t");	
			
			
			results0[i1] = Manager.det(vars[i1], gs, ws);	
			results1[i1] = Manager.det1(vars[i1], gs, ws);
			results2[i1] = Manager.det2(vars[i1], gs, ws);
			results3[i1] = Manager.det3(vars[i1], gs, ws);
			results4[i1] = Manager.det4(vars[i1], gs, ws);
			//results][5] = i1;
			System.out.println();	
		}

		
		//Results;			
			int[] indices;
			//kryt 0
			System.out.println("Kombinacja kryteriow: ");
			int max0 = Arrays.stream(results0).max().getAsInt();
			//int ind = 
			indices = IntStream.range(0, results0.length).filter(h -> results0[h] == max0).toArray();
	        System.out.println(max0);
	        for (int kk = 0;  kk < indices.length; kk++) {
	        	System.out.print(" "+indices[kk]);	
			}
			System.out.println();	
			

			
	        //kryt 1
			System.out.println("Najlepsze zadowolenie uczestnikow: ");
			int max1 = Arrays.stream(results1).max().getAsInt();
			//int ind = 
			indices = IntStream.range(0, results1.length).filter(h -> results1[h] == max1).toArray();
	        System.out.println(max1);
	        for (int kk = 0;  kk < indices.length; kk++) {
	        	System.out.print(" "+indices[kk]);	
			}
			System.out.println();	
	        
	        //kryt 2
			System.out.println("Najmniejsze niezadowolenie uczestnikow (liczba niezadowolonych: ");
			
			int min2 = Arrays.stream(results2).min().getAsInt();
			//int ind = 
			indices = IntStream.range(0, results2.length).filter(h -> results2[h] == min2).toArray();
	        System.out.println(min2);
	        for (int kk = 0;  kk < indices.length; kk++) {
	        	System.out.print(" "+indices[kk]);	
			}
			System.out.println();	
	        
	        
	        //kryt 3
			System.out.println("Najwiekszy zysk organizatora: ");
			
			int max3 = Arrays.stream(results3).max().getAsInt();
			//int ind = 
			indices = IntStream.range(0, results3.length).filter(h -> results3[h] == max3).toArray();
	        System.out.println(max3);
	        for (int kk = 0;  kk < indices.length; kk++) {
	        	System.out.print(" "+indices[kk]);	
			}
			System.out.println();	
		
	        //kryt 4
			System.out.println("najmniejszy koszt uczestnikow: ");	
			
			int max4 = Arrays.stream(results4).max().getAsInt();
			//int ind = 
			indices = IntStream.range(0, results4.length).filter(h -> results4[h] == max4).toArray();
	        System.out.println(max4);
	        for (int kk = 0;  kk < indices.length; kk++) {
	        	System.out.print(" "+indices[kk]);	
			}
			System.out.println();	
		
		
		System.out.println("");
	}

}
