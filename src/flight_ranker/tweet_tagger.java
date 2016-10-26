/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Aniket
 */
public class tweet_tagger {
    
    String tagged="";
    
    public tweet_tagger(String tweet) throws FileNotFoundException{
    
     MaxentTagger tagger = new MaxentTagger("taggers\\english-left3words-distsim.tagger");
  
    tagged = tagger.tagString(tweet);
      
    
}
    


    }