/**
 * 
 */
package perm;


import java.util.Arrays;

/**
 * @author Jacek
 *
 */
public class VariationGenerator {
	private int n, k;
	private int[] ns;
	private boolean _hasMore;
	//private

	public VariationGenerator(int n, int k) {
		super();
		this.n = n;
		this.k = k;
		ns = new int[k+1];
		if(n>0 && k>0)
			_hasMore = true;
	}
	
//	static public int[][] getVariations(int n, int k){
//		if(k == 0) {
//			;
//		}
//		int ret;
//		return ret;
//	}
	
	public int[] getNextVar() {
		boolean overflow = true;
		int[] ret = Arrays.copyOf(ns, ns.length-1) ;
		for (int i = 0; i < ns.length; i++) {
			if(overflow)
				ns[i]++;
			if(ns[i] >= n) {
				ns[i] %= n;
			}
			else
				overflow = false;
		}
		if(ns[ns.length - 1] != 0) {
			assert( ns[k] != 0 );
			_hasMore = false;
		}
		return ret;
	}
	
	public boolean hasMore() {return _hasMore;}
	
	static public int pow(int n, int k) {
		if(k==0)
			return 1;
		else 
			return n*pow(n,k-1);
	}

}
