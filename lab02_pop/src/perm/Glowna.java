package perm;



public class Glowna {
	
	
	public static void main(String[] args) {

//  		CombinationGenerator cg = new CombinationGenerator(10,3);
//  		while(cg.hasMore()){
//  			int[] a = cg.getNext();
//  			for(int i=0; i<3; i++)
//  			 System.out.print(a[i]+" ");
//  			System.out.println();
//  		}
  		
  		/*	String[] elements = {"a", "b", "c", "d", "e", "f", "g"};
			int[] indices;
			CombinationGenerator x = new CombinationGenerator (elements.length, 3);
			StringBuffer combination;
			while (x.hasMore ()) {
			  combination = new StringBuffer ();
			  indices = x.getNext ();
			  for (int i = 0; i < indices.length; i++) {
			    combination.append (elements[indices[i]]);
			  }
			  System.out.println (combination.toString ());
			}
//		*/
//		int[] indices;
//		String[] elements = {"0", "1", "2", "3"};
//		
//		PermutationGenerator x = new PermutationGenerator (elements.length);
//		StringBuffer permutation;
//		while (x.hasMore ()) {
//		  permutation = new StringBuffer ();
//		  indices = x.getNext ();
//		  for (int i = 0; i < indices.length; i++) {
//		    permutation.append (elements[indices[i]]);
//		  }
//		  System.out.println (permutation.toString ());
//		}	


		System.out.println("hello");
		int n=10;
		int k=3;
		int v = pow(n, k);
		int[][] vars =new int[v][0];
		
		VariationGenerator x = new VariationGenerator (n, k);
		int i=0;
		while (x.hasMore ()) {
			int[] var = x.getNextVar();
			vars[i++] = var;	  
		}	
		for(int i1=0; i1<vars.length; i1++) {
			for (int j = 0; j < k; j++) {
				System.out.print(vars[i1][j]+" ");
			}			
			System.out.println();	
			System.out.println();	
		}
		  		
	}
	
	static private int pow(int n, int k) {
		if(k==0)
			return 1;
		else 
			return n*pow(n,k-1);
	}
}
