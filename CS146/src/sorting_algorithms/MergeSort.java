package sorting_algorithms;

import java.util.Random;

public class MergeSort {
	public static void mergeSort(int[] A) {
		mergeSortHelper(A,0,A.length-1);
	}
	
	private static void mergeSortHelper(int[] A, int start, int end) {
		if(start < end) {
			int mid = start + (end-start)/2;
			 mergeSortHelper(A, start, mid);
			 mergeSortHelper(A, mid+1, end);
			 merge(A, start, mid, end);
		}
		
	}
	
	private static void merge(int[] A, int start, int mid ,int end) {
		int n1 = mid-start+1;
		int n2 = end-mid;
		int[] left = new int[n1+1];
		for(int i = 0; i< n1; i++) {
			left[i] = A[start+i];
		}
		left[n1] = (int)Double.POSITIVE_INFINITY;
		
		
		int[] right = new int[n2+1];
		for(int i = 0;i < n2; i++) {
			right[i] = A[mid +i+1];
		}
		right[n2] = (int)Double.POSITIVE_INFINITY;
		int i = 0;
		int j = 0;
		for(int k = start; k<=end; k++) {
			if(left[i]<=right[j]) {
				A[k] = left[i];
				i++;
			}
			else {
				A[k] = right[j];
				j++;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] A = new int[20];
		for(int i = 0; i<20;i++) {
			A[i] = rand.nextInt(50);
		}
		System.out.println("Average case Before sorting...");
		for(int i = 0; i<A.length;i++) {
			System.out.print(A[i] + " ");
		}
		long averageStart = System.nanoTime();
		mergeSort(A);
		long averageEnd = System.nanoTime();
		System.out.println("\nAfter sorting...");
		for(int i = 0; i<A.length;i++) {
			System.out.print(A[i] + " ");
		}
		System.out.printf("\nThe running time for the average case is is %2.6f\n",  (averageEnd - averageStart)/1E+6);
		System.out.println();
		
		
		
		int[] B = new int[20];
		for(int i = 0; i<20;i++) {
			B[i] = rand.nextInt(10)+(i+1)*10;
		}
		
		System.out.println("Best case Before sorting...");
		for(int i = 0; i<B.length;i++) {
			System.out.print(B[i] + " ");
		}
		
		long bestStart = System.nanoTime();
		mergeSort(B);
		long bestEnd = System.nanoTime();
		System.out.println("\nAfter sorting...");
		for(int i = 0; i<B.length;i++) {
			System.out.print(B[i] + " ");
		}
		System.out.printf("\nThe running time for the best case is is %2.6f\n",  (bestEnd - bestStart)/1E+6);
		System.out.println();
		
		int[] C = new int[20];
		for(int i = 0; i <20; i++) {
			C[i] = (20- i)*10-rand.nextInt(10);
		}
		
		
		System.out.println("Worst case Before sorting...");
		for(int i = 0; i<C.length;i++) {
			System.out.print(C[i] + " ");
		}
		long worstStart = System.nanoTime();
		mergeSort(C);
		long worstEnd = System.nanoTime();
		System.out.println("\nAfter sorting...");
		for(int i = 0; i<C.length;i++) {
			System.out.print(C[i] + " ");
		}
		System.out.printf("\nThe running time for the worst case is is %2.6f\n",  (worstEnd - worstStart)/1E+6);
		
	}
}
