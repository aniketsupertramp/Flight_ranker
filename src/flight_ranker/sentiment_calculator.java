/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Aniket
 */

    public class sentiment_calculator {

 double senti_rate = 0.00;
    
    public sentiment_calculator(String tweet) {
        
        BufferedReader br = null;
        
		

			String sCurrentLine;
                        
                        String[] tweet_words = tweet.split("\\s+");
                        
                        

			
                        for(int i=0;i<tweet_words.length;i++)
                        {
                            try {
                            
                            br = new BufferedReader(new FileReader("G:\\Sentiwords.txt"));
                        
                            while ((sCurrentLine = br.readLine()) != null) {
                                 //System.out.println(tweet_words[i]);
                                
				//System.out.println(sCurrentLine);
                               String[] senti_word = sCurrentLine.split("\\s+");
                               //System.out.println(senti_word[0]+"-->"+senti_word[1]);
                               //System.out.println(senti_word[1]+"-->"+tweet_words[i]);
                              if(senti_word[1].equals(tweet_words[i]))
                               {  
                                   //add sentiment_value
                                   
                                //   System.out.println(tweet_words[i]);
                               
                                   senti_rate = senti_rate + Double.parseDouble(senti_word[0]);
                                  
                                  
                                   
                                   break;                               }
                            
                           // System.out.println(tweet_words[i]);
                            
			}

                            
                            
                        }

                        
                         catch (IOException e) {
			e.printStackTrace();
		} 
                        
                       
		} 
                
               
    }
    
}
