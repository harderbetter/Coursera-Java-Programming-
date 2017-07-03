import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+
        alphabetUpper.substring(0,key);
        
        String shiftedAlphabetLower = alphabetLower.substring(key)+
        alphabetLower.substring(0,key);
        int idx;
        
        for(int i = 0; i < encrypted.length(); i++) {
            
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar) == true){
            //Find the index of currChar in the alphabet (call it idx)
             idx = alphabetLower.indexOf(currChar);
            //If currChar is in the alphabet
            //if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetLower.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            
            //Otherwise: do nothing
         }
         
            if(Character.isUpperCase(currChar) == true){
            //Find the index of currChar in the alphabet (call it idx)
            idx = alphabetUpper.indexOf(currChar);
            //If currChar is in the alphabet
            //if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetUpper.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            
            //Otherwise: do nothing
         }
         }
        
        
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 17;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encrypt("First Legion", key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    
    public String encryptTwoKeys(String input, int key1, int key2){
    
        StringBuilder changeInput = new StringBuilder(input);
        int idx;
        for(int i = 0; i < changeInput.length(); i++) {
            
            char currChar = changeInput.charAt(i);
            
            
                if(i % 2 ==0)
                {   
                     String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                     String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        
                     String shiftedAlphabetUpper = alphabetUpper.substring(key1)+
                     alphabetUpper.substring(0,key1);
        
                     String shiftedAlphabetLower = alphabetLower.substring(key1)+
                     alphabetLower.substring(0,key1);
                    
                    
                      if(Character.isLowerCase(currChar) == true){
                          
                          idx = alphabetLower.indexOf(currChar);
                         
                          char newChar = shiftedAlphabetLower.charAt(idx);
                              
                          changeInput.setCharAt(i, newChar);
            
                             
                            }
         
                      if(Character.isUpperCase(currChar) == true){
                                
                          idx = alphabetUpper.indexOf(currChar);
                                
                          char newChar = shiftedAlphabetUpper.charAt(idx);
                                    
                          changeInput.setCharAt(i, newChar);
            
                                    
                                }
                     
                    
                }else{
                    
                    
                     String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                     String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        
                     String shiftedAlphabetUpper = alphabetUpper.substring(key2)+
                     alphabetUpper.substring(0,key2);
        
                     String shiftedAlphabetLower = alphabetLower.substring(key2)+
                     alphabetLower.substring(0,key2);
                    
                    
                      if(Character.isLowerCase(currChar) == true){
                          
                          idx = alphabetLower.indexOf(currChar);
                         
                          char newChar = shiftedAlphabetLower.charAt(idx);
                              
                          changeInput.setCharAt(i, newChar);
            
                             
                            }
         
                      if(Character.isUpperCase(currChar) == true){
                                
                          idx = alphabetUpper.indexOf(currChar);
                                
                          char newChar = shiftedAlphabetUpper.charAt(idx);
                                    
                          changeInput.setCharAt(i, newChar);
            
                                    
                                }
                     
                    
                    
                    
                }
            
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return changeInput.toString();
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    public void testEncryptTwoKeys() {
        int key1 = 23;
        int key2 = 17;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encryptTwoKeys("First Legion", key1, key2);
        System.out.println("key1 is " + key1+ "\n" + "key2 is " + key2 + "\n" + encrypted);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

