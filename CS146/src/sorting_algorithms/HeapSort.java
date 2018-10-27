package sorting_algorithms;
/**
 * Implement heapSort 
 * @author jing
 *
 */
public class HeapSort {

	public static void heapSort(int[] A) {
		int heapSize = A.length-1;
		for(int i = heapSize/2; i>=0; i--) {
			maxHeapify(A, i, heapSize);
		}
		for (int j = A.length-1; j>0; j--) {
			int temp = A[0];
			A[0] = A[j];
			A[j] = temp;
			heapSize--;
			maxHeapify(A, 0, heapSize);
		}
		
	}
	
	public static void maxHeapify(int[] A, int i, int aheapSize) {
		int l = i*2 + 1;
		int r = i*2 + 2;
		int largest;
		if((l <= aheapSize) && A[l] > A[i] ) {
			largest = l;
		}
		else
			largest = i;
		if((r<= aheapSize) && (A[r] > A[largest])) {
			largest = r;
		}
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(A, largest, aheapSize);
		}
			
	}
	/*
	public static void main(String[] args) {
		int[] A = {2, 5, 1, 6,3, 8, 4};
		heapSort(A);
		for(int i=0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	*/
}
