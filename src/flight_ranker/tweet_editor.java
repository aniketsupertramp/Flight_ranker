/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

/**
 *
 * @author Aniket
 */
public class tweet_editor {
    
    String edited_tweet="";
    
    public tweet_editor(String tweet) {
    
        edited_tweet = tweet.replaceAll("https?://\\S+\\s?","");
        
        edited_tweet = edited_tweet.replaceAll("[\\s]+"," ");
        
        edited_tweet = edited_tweet.toLowerCase();
        
        edited_tweet = edited_tweet.replace("#", "");
        
        edited_tweet = edited_tweet.replace(".", " ");//removal of dot
        
        
        
}
    
    
}
