/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

import org.jfree.util.Log;

/**
 *
 * @author Aniket
 */
public class soundex_api {
    
    private double comparePhonetic(String recognizedApp, String nameApp){		
    Soundex soundex = new Soundex();
    
    //Returns the number of characters in the two encoded Strings that are the same. 
    //This return value ranges from 0 to the length of the shortest encoded String: 0 indicates little or no similarity, 
    //and 4 out of 4 (for example) indicates strong similarity or identical values. 
    double sim=0;
	try {
		sim = soundex.difference(recognizedApp, nameApp);
	} catch (Exception e) {
		Log.e(LOGTAG, "Error during soundex encoding. Similarity forced to 0");
		sim = 0;
	}
    return sim/4;
}
    
}
