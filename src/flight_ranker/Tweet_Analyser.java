/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

import edu.stanford.nlp.math.ArrayMath;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Aniket
 */

public class Tweet_Analyser {
    
   
    double senti_rate = 0.0;

    public Tweet_Analyser(String tweet) {
        
        BufferedReader br = null;
        String passed_tweet="";
                       
                         if(tweet.contains("not"))
                          {
                              //System.out.println((NativeString.indexOf(tweet,"not")+4));
                            
                              if(NativeString.charAt(tweet, NativeString.indexOf(tweet,"not")+4)!="g") //for good
                              {
                                
                                 if(tweet.contains("just"))
                                {  
                                    
                                     String[] tweet_parts = tweet.split("just\\s");
                                      //System.out.println(tweet_parts[1]);
                                      passed_tweet = tweet_parts[1];
                                }
                                
                                else if(tweet.contains("only"))
                                {
                                    
                                    String[] tweet_parts = tweet.split("only\\s");
                                   passed_tweet = tweet_parts[1];
                                   
                                }
                                
                                else{
                                    //take it more negative like 'not at all good'
                                         passed_tweet = tweet.concat("piteous"); // add 1 more 'piteous' to be more effective
                                         senti_rate = -1.5;  //not enough so make it more negative     
                                }
                                
                              }
                               
                              else{
                                  ////take it as 'not good'
                                   passed_tweet = tweet.concat("not"); // add 1 more 'not' to be more effective
                              }
                              
                              
                          }
                            
                         else{
                             passed_tweet = tweet;
                         }
   
			String sCurrentLine;
                        
                        String[] tweet_words = passed_tweet.split("\\s+");
                       // System.out.println(tweet_words.length);
                        
                                    
                        
			
                        for(int i=0;i<tweet_words.length;i++)
                        {
                            //System.out.println(tweet_words[i]);
                            
                            
                            try {
                            
                            br = new BufferedReader(new FileReader("G:\\Sentiwords.txt"));
                                //System.out.println(tweet_words[2]);
                        
                            while ((sCurrentLine = br.readLine()) != null) {
                                
                                
                                
                                 String[] senti_word = sCurrentLine.split("\\s+");
                                 if(senti_word[1].equals(tweet_words[i]))
                               {  
//                                  if(i==2)
//                                  {
//                                      System.out.println("good");
//                                  }
                                   
                                   senti_rate = senti_rate + Double.parseDouble(senti_word[0]);
                                      break;                               }
                            
			}
      
                        }

                        
                         catch (IOException e) {
			e.printStackTrace();
		} 
                        
                       
		} 
                
               
    }
    
    public static void main(String[] args) {
        
         String tweet = "Indian Airlines are not at all good.";
    String tweet2 = "Indian Airlines are not just good but better.";

    tweet_editor t1 = new tweet_editor(tweet);
        System.out.println(t1.edited_tweet);
        Tweet_Analyser ta = new Tweet_Analyser(t1.edited_tweet);
        System.out.println(ta.senti_rate);
        
        tweet_editor t2 = new tweet_editor(tweet2);
        
        System.out.println(t2.edited_tweet);
        Tweet_Analyser ta2 = new Tweet_Analyser(t2.edited_tweet);
        System.out.println(ta2.senti_rate);
    }
    
    
}
