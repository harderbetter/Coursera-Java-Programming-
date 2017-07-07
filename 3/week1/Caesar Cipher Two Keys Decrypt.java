
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CaesarBreaker {

    public String decrypt(String encrypted){
    
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted,26-dkey);
    
    
    
    }
    
    
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
    
    
    public void testDecrypt(){
     FileResource fr = new FileResource();
     String decrypted = fr.asString();   
     //decrypted = decrypt("ffffffffaca");
     System.out.println("the decryped message is   " +decrypted);
    
    
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
    
    
    public void testhalfOfString(){
    
        String s = halfOfString("Qbkm Zgis", 1); 
        System.out.println("the half of the string is   " +s);
    
    
    }
    
    public int getKey(String s){
    
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    
    
    }
    
    public String decryptTwoKeys(String encrypted){
    
        String oneHalf = halfOfString(encrypted,0);
        String anotherHalf = halfOfString(encrypted,1);
        
        int key1 = getKey(oneHalf);
        int key2 = getKey(anotherHalf);
        
        System.out.println("the key1 is   " +key1);
        System.out.println("the key2 is   " +key2);
        
        CaesarCipher cc = new CaesarCipher();
        String de_oneHalf = cc.encrypt(oneHalf,26-key1);
        String de_anotherHalf = cc.encrypt(anotherHalf,26-key2);
        
        StringBuilder s1 = new StringBuilder(de_oneHalf);
        StringBuilder s2 = new StringBuilder(de_anotherHalf);
        StringBuilder newString = new StringBuilder();
        
        for(int i = 0; i< oneHalf.length(); i++){
            
            newString.append(s1.charAt(i));
            for( int j= 0; j< anotherHalf.length(); j++){
            
              newString.append(s2.charAt(j));
            
            }
        
        }
        
        return newString.toString();
    }
    
    public void testDecryptTwoKeys(){
        String s = decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println("the decrypted string is   " +s);
    
    }
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    

