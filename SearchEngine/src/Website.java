/**
 * The Class to score each web site
 * @author jing
 *
 */
public class Website{
	private int score;
	private String link;
	private int index;
	//private int numOfLinkedWebsites;
	/**
	 * Constructor of Website
	 * @param add link of the website
	 * @param i the sequence of being added to an array list
	 */
	public Website(String add, int i) {
		link = add;
		index = i;
		
	}
	
	@Override
	public String toString() {
		String result = "index-" + index + " "+"Score-"+score +" "+ '"'+link+'"';
		return result;
	}
	
	/**
	 * Get the score of current web page
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Assign a new score to the current page
	 * @param s score
	 */
	public void assignScore(int s) {
		score = s;
	}
	
	/**
	 * Get the index of current page in array list
	 * @return
	 */
	public int getIndex() {
		return index;
	}
}
