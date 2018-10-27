import java.util.ArrayList;
import java.util.List;

public class SearchEngine_word {

	public static void main(String[] args) {
		String[] keyword_raw = {"computer","flower", "toys","money","panda",
							 "doll", "keys","mouse","player","game","laptop",
							 "price","computer","student","baby","drink","panda",
							 "birds","human","student","boys","money","pencil",
							 "jobs","facebook","google","linkedin","money","student",
							 "school","love","human","happy","game","tools","game",
							 "school","boys","dance","keys","flower","computer"};
			
		//build keyword arraylist
		
		ArrayList<KeyWord> keyword = new ArrayList<KeyWord>();
		for(int i = 0; i<keyword_raw.length; i++) {
			KeyWord newItem = new KeyWord(keyword_raw[i]);
			if(keyword.contains(newItem))
				keyword.get(keyword.indexOf(newItem)).increaseSearchTime();
			else
				keyword.add(newItem);		
		}
		System.out.println("Total number of keywords: "+ keyword_raw.length);
		System.out.println("The list of keywords:");
		System.out.println(keyword);
		System.out.println();
		ArrayList<KeyWord> Q = PriorityQueue_word.build_priority_queue(keyword);
		
		System.out.println("The top 10 results");
		System.out.println();
		for(int i = 0; i<10; i++) {
        	System.out.println("Rank:" + (i+1)+" "+ Q.get(i));
        			
        }
	}
	

}
