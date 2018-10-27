package homework1;

import java.util.Random;

/**
 * Implementing the InsertionSort
 * @author jing
 *
 */
public class InsertionSort {
	/**
	 * Sorting list A in ascending order
	 * @param A list to be sorted
	 * @return the sorted order
	 */
	public static int[] insertionSort(int[] A) {
		for(int i = 2; i<A.length; i++) {
			int j = i;
			int key = A[i];
			while(j>0 && key < A[j-1]) {
				A[j] = A[j-1];
				j--;
			}
			A[j] = key;	
		}
		return A;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] A = new int[20];
		for(int i = 0; i<20;i++) {
			A[i] = rand.nextInt(50);
		}

		int[] B = new int[20];
		for(int i = 0; i<20;i++) {
			B[i] = rand.nextInt(10)+(i+1)*10;
		}
		
		
		int[] C = new int[20];
		for(int i = 0; i <20; i++) {
			C[i] = (20- i)*10-rand.nextInt(10);
		}

		// Average case:
		long averageStart = System.nanoTime();
		int[] result = insertionSort(A);
		long averageEnd = System.nanoTime();
		
		long bestStart = System.nanoTime();
		int[] result2 = insertionSort(B);
		long bestEnd = System.nanoTime();
		
		long worstStart = System.nanoTime();
		int[] result3 = insertionSort(C);
		long worstEnd = System.nanoTime();
		
		//average case：
		
		System.out.print("[");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] +" ");
		}
		System.out.print("]\n");
		System.out.printf("The running time for the average case is is %2.6f\n",  (averageEnd - averageStart)/1E+6);
		
		//best case
		System.out.print("[");
		for(int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] +" ");
		}
		System.out.print("]\n");
		System.out.printf("The running time for the best case is is %2.6f\n",  (bestEnd - bestStart)/1E+6);
	
		
		//worst case:
		System.out.print("[");
		for(int i = 0; i < result3.length; i++) {
			System.out.print(result3[i] +" ");
		}
		System.out.print("]\n");
		System.out.printf("The running time for the worst case is is %2.6f\n",  (worstEnd - worstStart)/1E+6);
	
	}

}
