import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueue_web_Tester {
	@Test
	public void heap_extract_max_test() {
		ArrayList<Website> A = new ArrayList<Website>(3);
		Website a = new Website("hello", 0);
		Website b = new Website("world", 1);
		Website c = new Website("!", 2);
		a.assignScore(5);
		b.assignScore(10);
		c.assignScore(15);
		A.add(a);
		A.add(b);
		A.add(c);
		Website result = PriorityQueue_web.heap_extract_max(A, A.size());
		Assert.assertEquals(c, result);
		System.out.println(result);
	}
	
	@Test
	public void build_max_heap_test() {
		ArrayList<Website> A = new ArrayList<Website>(3);
		Website a = new Website("hello", 0);
		Website b = new Website("world", 1);
		Website c = new Website("!", 2);
		a.assignScore(5);
		b.assignScore(10);
		c.assignScore(15);
		A.add(a);
		A.add(b);
		A.add(c);
		PriorityQueue_web.build_max_heap(A, A.size());
		Assert.assertEquals(A.get(0).getScore(), 15);
		//System.out.println(A);
	}
	
	@Test
	public void heap_increase_key_test() {
		ArrayList<Website> A = new ArrayList<Website>(3);
		Website a = new Website("hello", 0);
		Website b = new Website("world", 1);
		Website c = new Website("!", 2);
		a.assignScore(5);
		b.assignScore(10);
		c.assignScore(15);
		A.add(a);
		A.add(b);
		A.add(c);
		PriorityQueue_web.build_max_heap(A, A.size());
		//System.out.println("Before increasing the key...");
		//System.out.println(A);
		PriorityQueue_web.heap_increase_key(A, 2, 20 );
		//System.out.println("After increasing the key...");
		//System.out.println(A);
		Assert.assertEquals(A.get(0).getScore(), 20);
	}
	
	@Test
	public void max_heap_insert_test() {
		ArrayList<Website> A = new ArrayList<Website>(3);
		Website a = new Website("hello", 0);
		Website b = new Website("world", 1);
		Website c = new Website("!", 2);
		a.assignScore(5);
		b.assignScore(10);
		c.assignScore(15);
		A.add(a);
		A.add(b);
		A.add(c);
		PriorityQueue_web.build_max_heap(A, A.size());
		//System.out.println("Before insertion...");
		//System.out.println(A);
		PriorityQueue_web.max_heap_insert(A, "SJSU", 30);
		//System.out.println("After insertion...");
		//System.out.println(A);
		Assert.assertEquals(A.get(0).getScore(), 30);	
	}
}
