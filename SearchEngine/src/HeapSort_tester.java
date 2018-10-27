import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class HeapSort_tester {
	@Test
	public void heapSort_test() {
		ArrayList<Website> A = new ArrayList<Website>(3);
		Website a = new Website("hello", 0);
		Website b = new Website("world", 1);
		Website c = new Website("!", 2);
		a.assignScore(5);
		b.assignScore(10);
		c.assignScore(15);
		A.add(b);
		A.add(a);
		A.add(c);
		System.out.println("Before sorting...");
		System.out.println(A);
		HeapSort_web.heapSort(A);
		System.out.println("After sorting...");
		System.out.println(A);
		Assert.assertEquals(A.get(0).getScore(), a.getScore());
		
	}
	
}
