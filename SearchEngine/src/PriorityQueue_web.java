import java.util.ArrayList;

/**
 * Building priority queue for sorting webpages in descending order based on scores
 * @author jing
 *
 */
public class PriorityQueue_web {
	
	
	/**
	 * Building a descending order queue based on scores of each page
	 * @param A The original web-page array get from a web crawler
	 * @return A web-page priority queue 
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Website> build_descending_order_queue(ArrayList<Website> A){
		ArrayList<Website> A1 = (ArrayList<Website>) A.clone();
		int qSize = A1.size(); //size of the original web-page array
		int heapSize = A1.size();//initial heapSize
		ArrayList<Website> Q = new ArrayList<Website> (qSize); //Initial an empty priority queue
		for(int i = 0; i<qSize && heapSize>0; i++) {
			Q.add(heap_extract_max(A1, heapSize));//Extract the max and insert to the queue.
			heapSize --;//heapSize decrease by one after each extraction.
		}
		return Q;
	}
	/**
	 * Extract the max item from the priority queue and remove it.
	 * @param A is the original web-page array
	 * @param heapSize heapSize of the array
	 * @return The max element of the heap
	 */
	public static Website heap_extract_max(ArrayList<Website> A, int heapSize) {
		build_max_heap(A, heapSize); //build max heap of A
		if(heapSize < 1) 
			throw new ArrayIndexOutOfBoundsException("Underflow"); //error when underflow
		
		Website max = A.get(0); //get the max
		A.set(0, A.get(heapSize-1)); //remove the max and reset the root to be last element of the heap
		heapSize = heapSize-1;//heap size decrease by 1
		maxHeapify(A, 0, heapSize);//maxHeapify the heap
		return max;	
	}
	
	/**
	 * This method helps to restructure the heap to keep it as a priority queue after assigning a new score to a element
	 * @param Q The previous priority queue
	 * @param i The index of the element which will be assigning a new key
	 * @param key The new score that is assigned to Q[i]
	 */
	public static void heap_increase_key(ArrayList<Website> Q, int i, int key ) {
		if (key < Q.get(i).getScore()) {
			throw new IllegalArgumentException("New key is smaller than current key");
		}
		Q.get(i).assignScore(key);
		while (i>0 && Q.get((i-1)/2).getScore() < Q.get(i).getScore()) {
			swap(Q, (i-1)/2, i); 
			i = (i-1)/2;
		}
	}
	
	/**
	 * Get the maximum of the heap
	 * @param The priority queue
	 * @return The root of the priority queue(max element)
	 */
	public static Website heap_maximum(ArrayList<Website> Q) {
		return Q.get(0);
	}
	
	/**
	 * This method helps to restructure the priority queue after insertion a new item with a score key
	 * @param Q The priority queue to be added
	 * @param address The link of the web-page what will be added
	 * @param key The score of the new element.
	 */
	public static void max_heap_insert(ArrayList<Website> Q, String link, int key) {
		Website newWeb = new Website(link, Q.size());
		newWeb.assignScore(Integer.MIN_VALUE);
		Q.add(newWeb);
		heap_increase_key(Q, Q.size()-1,key);
		
		
	}
	/**
	 * Build max heap of a web-page array
	 * @param A The original web-page array
	 * @param heapSize heapSize of a heap
	 */
	public static void build_max_heap(ArrayList<Website> A, int heapSize) {
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
	public static void maxHeapify(ArrayList<Website> A, int i, int aheapSize) {
		int l = i*2 + 1;
		int r = i*2 + 2;
		int largest;
		if((l <= aheapSize) && A.get(l).getScore() > A.get(i).getScore() ) {
			largest = l;
		}
		else
			largest = i;
		if((r<= aheapSize) && (A.get(r).getScore() > A.get(largest).getScore())) {
			largest = r;
		}
		if (largest != i) {
			Website temp = A.get(i);
			A.set(i, A.get(largest));
			A.set(largest, temp);
			maxHeapify(A, largest, aheapSize);
		}
			
	}
	
	/**
	 * A helper function to help swap 2 element in a heap
	 * @param A
	 * @param i
	 * @param j
	 */
	private static void swap(ArrayList<Website> A, int i, int j ) {
		Website temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
	
}
