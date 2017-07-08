import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class TestCaesarCipherTwo {
     
    public int maxIndex(int[] vals){
    
        int maxDex = 0;
        for(int k=0; k<vals.length;k++){
            if(vals[k] > vals[maxDex]){
                maxDex =k;
            }
        
        }
        return maxDex;
            }
    
    
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k = 0; k < message.length();k++){
        
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
            
                counts[dex] +=1;
            
            }
        
        }
        return counts;
        
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
    
    public String breakCaesarCipher(String input){
        
        String halfOfString0 = halfOfString(input,0);
        String anotherHalfOfString1 = halfOfString(input,1);
        
        TestCaesarCipher cc0 = new TestCaesarCipher();
        TestCaesarCipher cc1 = new TestCaesarCipher();
        
        String de_String0 = cc0.breakCaesarCipher(halfOfString0);
        String de_String1 = cc1.breakCaesarCipher(anotherHalfOfString1);
        
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
    
    public void simpleTests(){
    
        //FileResource fr = new FileResource();
        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";//fr.asString(); 
        CaesarCipherTwo cc = new CaesarCipherTwo(21,8);
        String encrypt = cc.encrypt(input);
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println("the encrypted message is " + encrypt);
        System.out.println("the decrypted message is " + decrypt);
        
        String estimate = breakCaesarCipher(encrypt);
        System.out.println("the estimated decrypted message is " + decrypt);
    
    }
}
