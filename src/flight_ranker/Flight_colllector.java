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
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class Flight_colllector {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("Oa6WAzH0j3sgVrP0CNGvxnWA2");
        cb.setOAuthConsumerSecret("sLdoFybvJvVFz7Lxbbv9KWQDFeKcVeZAkWDC4QMHnx5lV2OmGE");
        cb.setOAuthAccessToken("2691889945-5NOBWKUgT9FiAoyOQSCFg8CLlPRlDMbWcUrJBdK");
        cb.setOAuthAccessTokenSecret("J6tA8Sxrtz2JNSFdQwAonbGxNfLNuD9I54Zfvomku3p5t");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        
        
        StatusListener listener = new StatusListener() {
            
            
             @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStatus(Status status) {
                User user = status.getUser();
                
                // gets Username
                String username = status.getUser().getScreenName();
                long followers = user.getFollowersCount();
                
                long retweets =status.getRetweetCount();
                 
                long favs =status.getFavoriteCount();
                
                System.out.println("USERNAME--> "+username);
                 System.out.println("FOLLOWERS--> "+followers);
                String profileLocation = user.getLocation();
                
                
//                System.out.println("RETWEETS--> "+retweets);
               
//                System.out.println("FAVOURITES--> "+favs);
                
                System.out.println("LOCATION--> "+profileLocation);
                long tweetId = status.getId(); 
                System.out.println("TWEET ID--> "+tweetId);
                String content = status.getText();
                System.out.println("TWEET--> "+content +"\n");
                
           
                
                 BufferedWriter b1 = null,b2,b3,b4,b5,b6 ,b7= null;
                
                try {
                    //output_file = new BufferedReader(new FileReader("G:\\Sentiwords.txt"));
                    
                    FileWriter f1 = new FileWriter ("G:\\flights_data.txt", true);
                   b1 = new BufferedWriter (f1);
                        b1.write("#USERNAME- "+username);
                        b1.newLine();
                        
                         b1.write("#Followers- "+followers);
                                
                        b1.newLine();
                        
                         b1.write("#Location- "+profileLocation);
                              
                        b1.newLine();
                         b1.write("#ID- "+tweetId);
                              
                        b1.newLine();
                         b1.write("#Tweet- "+content);
                        b1.newLine();
                        b1.newLine();
                        
                        
                        
                       tweet_editor modified_tweet =  new tweet_editor(content);
                       //tweet_tagger tagged_tweet = new tweet_tagger(modified_tweet.edited_tweet);
                       //System.out.println(tagged_tweet.tagged);
                       
                      
                       
                       
                       sentiment_calculator senti_value = new sentiment_calculator(modified_tweet.edited_tweet);
                       
                       
                     if(content.contains("Indigo"))
                       {System.out.println("indigo");
                           FileWriter f2 = new FileWriter ("G:\\Indigo.txt", true);
                   b2 = new BufferedWriter (f2);
                        b2.write(Double.toString(senti_value.senti_rate));
                        b2.newLine();
                       }
                       
                       if(content.contains("Jet"))
                       {System.out.println("jet");
                           FileWriter f3 = new FileWriter ("G:\\jet.txt", true);
                   b3 = new BufferedWriter (f3);
                        b3.write(Double.toString(senti_value.senti_rate));
                        b3.newLine();
                       }
                       
                       if(content.contains("Indian"))
                       {System.out.println("indian");
                           FileWriter f4 = new FileWriter ("G:\\Indian.txt", true);
                   b4 = new BufferedWriter (f4);
                        b4.write(Double.toString(senti_value.senti_rate));
                        b4.newLine();
                       }
                       
                       if(content.contains("Spicejet"))
                       {System.out.println("spicejet");
                           FileWriter f5 = new FileWriter ("G:\\spicejet.txt", true);
                   b5 = new BufferedWriter (f5);
                        b5.write(Double.toString(senti_value.senti_rate));
                        b5.newLine();
                       }
                       
                       
                       if(content.contains("AirAsia"))
                       {System.out.println("airasia");
                           FileWriter f6 = new FileWriter ("G:\\airasia.txt", true);
                   b6 = new BufferedWriter (f6);
                        b6.write(Double.toString(senti_value.senti_rate));
                        b6.newLine();
                       }
                       
                      try {
                                         //output_file = new BufferedReader(new FileReader("G:\\Sentiwords.txt"));
                    
                    FileWriter f7 = new FileWriter ("G:\\flight_senti.txt", true);
                   b7 = new BufferedWriter (f7);
                        b7.write(String.valueOf(senti_value.senti_rate));
                        b7.newLine();
                       
                }
                   
                      catch (IOException e) {
			e.printStackTrace();
		} 
                
                finally
                {
                    try {
                        b7.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Flight_colllector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    
                } 
                
                catch (IOException e) {
			e.printStackTrace();
		} 
                
                finally
                {
                    try {
                        b1.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Flight_colllector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStallWarning(StallWarning sw) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
      
         FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"Indian Airlines, Indigo Airlines, Indigo Airline , Indian Airline , Spicejet , jetAirways , Jet Airways, Jet Airlines , airasia"}; //we will pass stock related keyword here

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  
   
            
        }
        
    }
    


