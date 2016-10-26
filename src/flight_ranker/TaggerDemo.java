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


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

class TaggerDemo {

  private TaggerDemo() {}

  public static void main(String[] args) throws Exception {
//    if (args.length != 2) {
//      System.err.println("usage: java TaggerDemo modelFile fileToTag");
//      return;
//    }
    MaxentTagger tagger = new MaxentTagger("taggers\\english-left3words-distsim.tagger");
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader("G:\\t.txt")));
    for (List<HasWord> sentence : sentences) {
      List<TaggedWord> tSentence = tagger.tagSentence(sentence);
      System.out.println(Sentence.listToString(tSentence, false));
    }
  }

}
