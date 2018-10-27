import java.util.ArrayList;

public class PriorityQueue_word {
	/**
	 * Extract the max item from the priority queue and remove it.
	 * @param A is the original web-page array
	 * @param heapSize heapSize of the array
	 * @return The max element of the heap
	 */
	public static KeyWord heap_extract_max(ArrayList<KeyWord> A, int heapSize) {
		build_max_heap(A,heapSize);
		//int heapSize = A.size();
		if(heapSize < 1)
			throw new ArrayIndexOutOfBoundsException("Underflow");
		
		KeyWord max = A.get(0);
		A.set(0, A.get(heapSize-1));
		heapSize = heapSize-1;
		maxHeapify(A, 0, heapSize);
		return max;	
	}

	/**
	 * Building a descending order queue based on scores of each page
	 * @param A The original web-page array get from a web crawler
	 * @return A web-page priority queue 
	 */
	public static ArrayList<KeyWord> build_priority_queue(ArrayList<KeyWord> A){
		int qSize = A.size();
		ArrayList<KeyWord> Q = new ArrayList<KeyWord> (qSize);
		int heapSize = A.size();
		for(int i = 0; i<qSize && heapSize>0; i++) {
			Q.add(heap_extract_max(A, heapSize));
			heapSize --;
		}
		return Q;
	}
	
	/**
	 * This method helps to restructure the heap to keep it as a priority queue after assigning a new score to a element
	 * @param Q The previous priority queue
	 * @param i The index of the element which will be assigning a new key
	 * @param key The new score that is assigned to Q[i]
	 */
	public static void heap_increase_key(ArrayList<KeyWord> Q, int i, int key ) {
		if (key < Q.get(i).getSearchTime()) {
			throw new IllegalArgumentException("New key is smaller than current key");
		}
		Q.get(i).assignSearchTime(key);
		while (i>0 && Q.get((i-1)/2).getSearchTime() < Q.get(i).getSearchTime()) {
			swap(Q, (i-1)/2, i);
			i = (i-1)/2;
		}
	}
	

	
	private static void swap(ArrayList<KeyWord> A, int i, int j ) {
		KeyWord temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
	
	/**
	 * Get the maximum of the heap
	 * @param The priority queue
	 * @return The root of the priority queue(max element)
	 */
	public static KeyWord heap_maximum(ArrayList<KeyWord> A) {
		return A.get(0);
	}
	
	/**
	 * This method helps to restructure the priority queue after insertion a new item with a score key
	 * @param Q The priority queue to be added
	 * @param address The link of the web-page what will be added
	 * @param key The score of the new element.
	 */
	public static void max_heap_insert(ArrayList<KeyWord> Q, int key) {
		KeyWord newWord = new KeyWord(null);
		newWord.assignSearchTime(Integer.MIN_VALUE);
		Q.add(newWord);
		heap_increase_key(Q, Q.size()-1,key);
		
		
	}
	
	/**
	 * Build max heap of a web-page array
	 * @param A The original web-page array
	 * @param heapSize heapSize of a heap
	 */
	public static void build_max_heap(ArrayList<KeyWord> A, int heapSize) {
		//int heapSize = A.size()-1;
		for(int i = (heapSize-1)/2; i>=0; i--) {
			maxHeapify(A, i, heapSize-1);
		}
	}
	
	/**
	 * This method helps to max heapify the array to a max heap.
	 * @param A
	 * @param i
	 * @param aheapSize
	 */
	public static void maxHeapify(ArrayList<KeyWord> A, int i, int aheapSize) {
		int l = i*2 + 1;
		int r = i*2 + 2;
		int largest;
		if((l <= aheapSize) && A.get(l).getSearchTime() > A.get(i).getSearchTime() ) {
			largest = l;
		}
		else
			largest = i;
		if((r<= aheapSize) && (A.get(r).getSearchTime() > A.get(largest).getSearchTime())) {
			largest = r;
		}
		if (largest != i) {
			KeyWord temp = A.get(i);
			A.set(i, A.get(largest));
			A.set(largest, temp);
			maxHeapify(A, largest, aheapSize);
		}
}
}
