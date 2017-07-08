import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1,int key2){
    
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+
                          alphabet.substring(0,key1);
        
        shiftedAlphabet2 = alphabet.substring(key2)+
                          alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
        
    
    }
    
       public String halfOfString(String message, int start){
        int stringLength = message.length();
        StringBuilder sb = new StringBuilder(message);
        StringBuilder newString = new StringBuilder();
        if(start == 0){
        
            for(int i = 0; i<stringLength; i = i+2){
        
                newString.append(sb.charAt(i));
        
            }
        
        }else{
        
       
        
            for(int i = 1; i<stringLength; i = i+2){
        
                newString.append(sb.charAt(i));
        
            }
        
        
        }
    
        return newString.toString();
    
    
    }
     
    
    public String encrypt(String input) {
        
        String halfOfString0 = halfOfString(input,0);
        String anotherHalfOfString1 = halfOfString(input,1);
        
        CaesarCipher cc0 = new CaesarCipher(mainKey1);
        CaesarCipher cc1 = new CaesarCipher(mainKey2);
        
        String en_String0 = cc0.encrypt(halfOfString0);
        String en_String1 = cc1.encrypt(anotherHalfOfString1);
        
        
        StringBuilder s1 = new StringBuilder(en_String0);
        StringBuilder s2 = new StringBuilder(en_String1);
        StringBuilder newString = new StringBuilder();
        
        for(int i = 0; i< en_String0.length(); i++){
            
            newString.append(s1.charAt(i));
            
            if(i< en_String1.length()){
                
                newString.append(s2.charAt(i));
            }
            
            }
        
        
        return newString.toString();
    }
    
    
    public String decrypt(String input){
    
        
        String halfOfString0 = halfOfString(input,0);
        String anotherHalfOfString1 = halfOfString(input,1);
        
        CaesarCipher cc0 = new CaesarCipher(mainKey1);
        CaesarCipher cc1 = new CaesarCipher(mainKey2);
        
        String de_String0 = cc0.decrypt(halfOfString0);
        String de_String1 = cc1.decrypt(anotherHalfOfString1);
        
        
        StringBuilder s1 = new StringBuilder(de_String0);
        StringBuilder s2 = new StringBuilder(de_String1);
        StringBuilder newString = new StringBuilder();
        
        for(int i = 0; i< de_String0.length(); i++){
            
            newString.append(s1.charAt(i));
            
            if(i< de_String1.length()){
                
                newString.append(s2.charAt(i));
            }
            
            }
        
        
        return newString.toString();
    
    
    }
    
    
    
    
}
