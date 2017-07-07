import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
    
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+
                          alphabet.substring(0,key);
        mainKey = key;
    
    }
    
    
    
    
    public String encrypt(String input) {
        
        StringBuilder encrypted = new StringBuilder(input);
        
     
        int idx;
        
        for(int i = 0; i < encrypted.length(); i++) {
            
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar) == true){
             
             idx = alphabet.indexOf(Character.toUpperCase(currChar));
           
               
                char newChar = shiftedAlphabet.charAt(idx);
               
                encrypted.setCharAt(i, Character.toLowerCase(newChar));
            
            
         }
         
            if(Character.isUpperCase(currChar) == true){
            
                idx = alphabet.indexOf(currChar);
            
                char newChar = shiftedAlphabet.charAt(idx);
               
                encrypted.setCharAt(i, newChar);
            
            
         }
         }
        
        
        
        return encrypted.toString();
    }
    
    public void testEncrypted() {
        
  
        String encrypted = encrypt("First Legion");
        System.out.println("the encrypted message is " + encrypted);
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
         return cc.encrypt(input);
    
    
    }
    
   
    
    
}
