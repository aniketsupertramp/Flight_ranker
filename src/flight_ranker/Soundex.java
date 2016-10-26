/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight_ranker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aniket
 */

				
	class Soundex{
    private static int getConsonantCode( char ch ){
        String codeList[] = { "BFPV", "CGJKQSXZ","DT","L","MN","R" };
        int code = 0;
        for( int i = 0 ; i < codeList.length ; i++ ){
             if( codeList[i].indexOf(ch) >= 0 ) {
                code = i+1;
            }
        }
        return code;
    }
    private static boolean isVowel( char ch ){
        return (new String("AEIOUaeiou")).indexOf(ch) >= 0 ;
    }
    public static String getSoundexCode( String str ){
        str=str.toUpperCase();
        String soundexCode = "" + str.charAt(0), temp="";
        int length = str.length();
        char curr, prev, next;{ }
        String dropList = "AEIOUYHW";
        for( int i=1 ; i< length ; i++ ){
            curr = str.charAt(i);
            prev = str.charAt( i-1 );
            if( ( curr=='H' || curr == 'W') && i != length-1 ){
                if( temp.length() >= 2) temp=temp.substring(1);
                next=str.charAt( i+1 );
                if( isVowel(curr) && getConsonantCode( prev ) == getConsonantCode( next ) ){
                    temp += prev+prev;
                    i=i+1;
                }else if( getConsonantCode( prev ) == getConsonantCode( next ) ){
                    temp += prev;
                    i=i+1;
                }
            }else if( getConsonantCode( curr ) != getConsonantCode( prev ) ){
                if( dropList.indexOf( curr ) == -1 ){
                    temp += curr;
                }
            }
        }
        temp = ( temp + "0000" ).substring( 0, 3 );
        for( int i = 0; i<=2 ; i++ ){
            soundexCode += getConsonantCode( temp.charAt( i ) );
        }
        return soundexCode;
    }
    
    public static int edit_distance(String str,String curr)
    {
        int l1 = str.length();
        int l2 = curr.length();
        
        char[] str1 = str.toCharArray();
        char curr1[] = curr.toCharArray();
        
        int tab[][] = new int[l1+1][l2+1];
        
        for(int i = 0;i<l2+1;i++)
        {
         tab[0][i] = i;  
        }
        
        for(int i = 0;i<l1+1;i++)
        {
         tab[i][0] = i;  
        }
        
        for(int i=1;i<l1+1;i++)
        {
            for(int j=1;j<l2+1;j++)
            {
                if(str1[i-1]==(curr1[j-1]))
                {
                     tab[i][j] = tab[i-1][j-1];
                     
                }
                
                else{
                    tab[i][j] = 1+ minm(tab[i-1][j-1],tab[i-1][j],tab[i][j-1]);
                }
               
            }
        }
        
        return tab[l1][l2];
    }
    
    public static void soundex_match(String str) throws FileNotFoundException, IOException
    {
        String str_code = getSoundexCode(str);
        
        BufferedReader br = new BufferedReader(new FileReader("G:\\words_db.txt"));
        String sCurrentLine;
         while ((sCurrentLine = br.readLine()) != null) {
               
             if(getSoundexCode(sCurrentLine).equals(str_code))
             {
                int min =  edit_distance(str,sCurrentLine);
                if(min<=2)
                {
                     //System.out.println(min);
                     System.out.println(sCurrentLine);  
                }
               
                   
             }
             
         }
                       
              
        
    }
    
    public static void main( String []args ) throws IOException{
        //System.out.println( getSoundexCode( "Ashcraft" )+" "+"A261" );
        //System.out.println( getSoundexCode( "Ashcroft" )+" "+"A261" );
     
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        System.out.println("Similar words are: ");
        soundex_match(str);
         
    }

    private static int minm(int tab, int tab0, int tab1) {
        tab=tab>tab0?tab0:tab;
        tab = tab>tab1?tab1:tab;
        
        return tab;
        
    }
}