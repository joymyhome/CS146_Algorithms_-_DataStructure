import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Spider {
	private static final int MAX_PAGES_TO_SEARCH = 35;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    private List<Website> targetWebs = new ArrayList<Website>();
    
    
    /**
     * Returns the next URL to visit (in the order that they were found). We also do a check to make
     * sure this method doesn't return a URL that has already been visited.
     * 
     * @return
     */
    private String nextUrl()
    {
        String nextUrl;
        do
        {
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }
    /**
     * Our main launching point for the Spider's functionality. Internally it creates spider legs
     * that make an HTTP request and parse the response (the web page).
     * 
     * @param url
     *            - The starting point of the spider
     * @param searchWord
     *            - The word or string that you are searching for
     */
    public void search(String url, String searchWord)
    {
        while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
        {
            String currentUrl;
            SpiderLeg leg = new SpiderLeg();
            if(this.pagesToVisit.isEmpty())
            {
                currentUrl = url;
                this.pagesVisited.add(url);
            }
            else
            {
                currentUrl = this.nextUrl();
            }
            leg.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
                                   // SpiderLeg
            boolean success = leg.searchForWord(searchWord);
            if(success)
            {	
            	
            	if(!targetWebs.contains(currentUrl)) //Check if the currentUrl has been added to targetWebs.
            	{
            		//double score = assignScore(currentUrl,leg.getLinks().size()); //Assign a score to currentUrl.
            		targetWebs.add(new Website(currentUrl, targetWebs.size()));//If the page is found, then add this page to targetWebs
            	}
                //System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
                //break;
            }
            
            this.pagesToVisit.addAll(leg.getLinks());
        }
        //System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
    }
    
    public ArrayList<Website> getTarget(){
    	return (ArrayList<Website>) targetWebs;
    }
   
    /*
    public double assignScore(String currentUrl, int size) {
    	int seed = 10;
        Random r= new Random(seed);
    	double frequency_and_location = r.nextDouble()*50;
    	double existingTime = r.nextDouble()*25;
    	double numberOfList = (double) size/250*25;
    	double advisingFee = r.nextDouble()*25;
    	return frequency_and_location + existingTime + numberOfList + advisingFee;
    	
    }
    */

}
