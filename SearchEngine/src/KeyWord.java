/**
 * The Class to score each keyword
 * @author jing
 *
 */
public class KeyWord {
	private String wordName;
	private int searchTimes;
	
	/**
	 * Constructor
	 * @param n String of the keyword
	 */
	public KeyWord(String n) {
		wordName = n;
		searchTimes = 1;
	}
	
	/**
	 * Increase the searched time when the keyword appears each time
	 */
	public void increaseSearchTime() {
		searchTimes = searchTimes+1;
	}
	
	/**
	 * Get the searched time of the keyword
	 * @return searched times
	 */
	public int getSearchTime() {
		return searchTimes;
	}
	
	/**
	 * Assign search time
	 * @param times
	 */
	public void assignSearchTime(int times) {
		searchTimes = times;
	}
	
	public String toString() {
		return wordName +" " + searchTimes;
	}
	
	public boolean equals(Object obj) {
		KeyWord b = (KeyWord) obj;
		if(this.wordName == b.wordName)	
			return true;
		else
			return false;
		
	}
}
