import edu.duke.*;
import java.util.ArrayList;
import java.io.*;

public class CharactersInPlay {
    private ArrayList<String> persons;
    private ArrayList<Integer> freqs;
    
     public CharactersInPlay() {
        persons = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    
    public void update(String person){
         int index = persons.indexOf(person);
         if (index == -1){
                persons.add(person);
                freqs.add(1);
            }
            else {
                int freq = freqs.get(index);
                freqs.set(index,freq+1);
            }
        }
        
    public void findAllCharacters(){
        
        FileResource resource = new FileResource();
        
        persons.clear();
        freqs.clear();
        
        for(String s : resource.lines())
        {
            StringBuilder sb = new StringBuilder(s);
            int length = s.length();
            int start =0;
            
            for(int i = 0;i<length; i++){
                if(Character.isLetter(sb.charAt(i)) == true){
                    start = i;
                    break;
                }
                
            }
            
            for(int i=0; i<length; i++){
                
                if(sb.charAt(i) == '.'){
                    update(s.substring(start,i));
                    
                    break;
                }
            
            
                
            }
            
        
        }
        
        
        
        }
        
        
    public void tester(){
       findAllCharacters();
       for(int k =0; k < freqs.size(); k++){
        
            System.out.println(persons.get(k) +" "+freqs.get(k));
        }
        System.out.println("    ");
        System.out.println("    ");
        System.out.println("    ");
       charactersWithNumParts(2, 10);
        
        
       }
        
    public void charactersWithNumParts(int num1, int num2){
    
        ArrayList<Integer> indexNeed = new ArrayList<Integer>();
        
        for(int i =0; i<freqs.size(); i++){
        
            if(freqs.get(i)>= num1 && freqs.get(i) <= num2){
            
                indexNeed.add(i);
            
            }
        
        
        
        }
    
    
        
        for(int k =0; k < indexNeed.size(); k++){
        
            System.out.println(persons.get(indexNeed.get(k)) +" "+freqs.get(indexNeed.get(k)));
        }
        
        
        
    
    
    }    
        
        
        
        
}
