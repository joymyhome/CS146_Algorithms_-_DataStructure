import java.util.ArrayList;
import java.util.Random;


/**
 * Implement heapSort for website
 * @author jing
 *
 */
public class HeapSort_web {

	/**
	 * 
	 * @param A
	 */
	public static void heapSort(ArrayList<Website> A) {
		build_max_heap(A);
		int heapSize = A.size()-1;
		for (int j = A.size()-1; j>0; j--) {
			Website temp = A.get(0);
			A.set(0, A.get(j));
			A.set(j, temp);
			heapSize--;
			maxHeapify(A, 0, heapSize);
		}
		
	}
	/**
	 * 
	 * @param A
	 */
	public static void build_max_heap(ArrayList<Website> A) {
		int heapSize = A.size()-1;
		for(int i = heapSize/2; i>=0; i--) {
			maxHeapify(A, i, heapSize);
		}
	}
	
	
	/**
	 * 
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
	
	
	
	
	public static void main(String[] args) {
		Spider spider = new Spider();
        spider.search("http://www.sjsu.edu", "student");
        
        ArrayList<Website> websites = spider.getTarget();
        Random r = new Random(1000);
        for(Website each : websites) {
        	int frequency_and_location = (int) (r.nextDouble()*10);
        	int existingTime = (int) (r.nextDouble()*20);
        	int numberOfList = (int) (r.nextDouble()*30);
        	int advisingFee = (int) (r.nextDouble()*40);
        	int score = frequency_and_location+existingTime+numberOfList+advisingFee;
        	each.assignScore(score);
        }
		heapSort(websites);
		for(int i=0; i < 10; i++) {
			System.out.println(websites.get(i));
		}
	}
	
}
