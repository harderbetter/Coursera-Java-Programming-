import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestCaesarCipher {
    
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
    
    public void simpleTests(){
    
        FileResource fr = new FileResource();
        String input = fr.asString(); 
        CaesarCipher cc = new CaesarCipher(23);
        String encrypt = cc.encrypt(input);
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println("the encrypted message is " + encrypt);
        System.out.println("the decrypted message is " + decrypt);
        
        String estimate = breakCaesarCipher(encrypt);
        System.out.println("the estimated decrypted message is " + decrypt);
    
    }
    
    
    public String breakCaesarCipher(String input){
    
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int key = maxDex -4;
        if(maxDex <4){
            key = 26 - (4-maxDex);
        }
        
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(input);
    
    
    }
    
    
    

}
