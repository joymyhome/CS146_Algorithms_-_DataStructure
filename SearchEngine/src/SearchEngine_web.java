import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SearchEngine_web
{
   
    public static void main(String[] args)
    {
        Spider spider = new Spider();
        spider.search("http://www.sjsu.edu", "student");
        
        ArrayList<Website> websites = spider.getTarget();
        //spider.getTarget()
        //Assigning score: This step I think should be taken out while crawling the web. To make it simpler
        //I will just put it here to assign scores.
        
        Random r = new Random(1000);
        for(Website each : websites) {
        	int frequency_and_location = (int) (r.nextDouble()*10);
        	int existingTime = (int) (r.nextDouble()*20);
        	int numberOfList = (int) (r.nextDouble()*30);
        	int advisingFee = (int) (r.nextDouble()*40);
        	int score = frequency_and_location+existingTime+numberOfList+advisingFee;
        	each.assignScore(score);
        }

        //Before sorting
        for(int i = 0; i<30; i++) {
        	System.out.println(websites.get(i));
        }
        
        //Sorting by using heapsort and priority queue
        ArrayList<Website> Q = PriorityQueue_web.build_descending_order_queue(websites);
        
        
        System.out.println();
        System.out.println();
        
        //Get the top 10 items from the descending order queue
        for(int i = 0; i<10; i++) {
        	System.out.println("PageRank: "+(i+1)+", "+ Q.get(i));
        }
        System.out.println();
        System.out.println("Which web page you would like to add score?(Represent by PageRank number from 1-30):");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        System.out.println("The current score for " + index + " is " + Q.get(index-1).getScore());
       
        System.out.println("The current index for this page is " + Q.get(index-1).getIndex() );
        System.out.println("What is the new score: ");
        int score = in.nextInt();
        PriorityQueue_web.heap_increase_key(Q, index-1, score );
        for(int i = 0; i<10; i++) {
        	System.out.println("PageRank: "+(i+1)+", "+ Q.get(i));
        }
        
    }
}