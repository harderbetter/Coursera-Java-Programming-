
import edu.duke.*;
import java.util.ArrayList;


public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    
    private String checkPunctuation( String s){
        int length = s.length();
        
        StringBuilder sb =  new StringBuilder(s);
        if(Character.isLetter(sb.charAt(0)) == false && Character.isDigit(sb.charAt(0)) == false ){
        
            s = s.substring(1);
            
            sb =  new StringBuilder(s);
            length = s.length();
        } 
        
        if(Character.isLetter(sb.charAt(length-1)) == false && Character.isDigit(sb.charAt(length-1)) == false ){
        
            s = s.substring(0,length-1);
            
        
        } 
        
        return s;
        
    
    }
    
    /*public void testCheckPunctuation(){
    
        String s = ";hello;";
        s= checkPunctuation(s);
        
        System.out.println("string is "+s);
    
    }*/
    
    public void findUnique(){
        FileResource resource = new FileResource();
        
        myWords.clear();
        myFreqs.clear();
        
        for(String s : resource.words()){
            s = s.toLowerCase();
           // s = checkPunctuation(s);
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    
    
    public void tester(){
        findUnique();
        System.out.println("unique words: "+myWords.size());
        for(int k =0; k < myWords.size(); k++){
        
            System.out.println(myFreqs.get(k) +" "+myWords.get(k));
        }
        int index = findMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    
    
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    
    
}
