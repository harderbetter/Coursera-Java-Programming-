
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordPlay {

    public boolean isVowel (char ch){
        
        if(ch == 'a' || ch == 'A'||ch == 'e'||ch == 'E'||ch == 'i'||ch == 'I'||ch == 'o'||ch == 'O'||ch == 'u'||ch == 'U')
        {
            return true;
        }else{
            return false;
        }
    
    
    }
    
    
    public void testISvowel(){
    
        char ch = 'A';
    
        boolean b = isVowel(ch);
        System.out.println(b);
    
    }
    
    public String replaceVowels(String phrase, char ch){
    
        StringBuilder changePhrase = new StringBuilder(phrase);
        
        for(int i = 0; i < changePhrase.length(); i++) {
            
            char currChar = changePhrase.charAt(i);
            
            if(isVowel(currChar) == true){
                
                changePhrase.setCharAt(i, ch);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return changePhrase.toString();
    }
    
    public void test_replaceVowels(){
            
        String s =  replaceVowels("Hello World", '*');
        System.out.println(s);
        
    
    }
    
    public String emphasize(String phrase,char ch){
    
         StringBuilder changePhrase = new StringBuilder(phrase);
        
        for(int i = 0; i < changePhrase.length(); i++) {
            
            char currChar = changePhrase.charAt(i);
            
            if(currChar == ch){
                if(i % 2 ==0)
                {
                    changePhrase.setCharAt(i, '*');
                }else{
                    changePhrase.setCharAt(i, '+');
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return changePhrase.toString();
    
    
    
    
    
    }
    
    
    public void test_emphasize(){
    
        String s = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(s);
    
    }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    

