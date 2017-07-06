
/**
 * Write a description of Word_lengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;



public class Word_lengths {

    public void countWordLengths(FileResource resource, int [] counts){
    
        int arraylength = counts.length -1;
       // FileResource resource = new FileResource("data/common.txt");
       for(String s : resource.words()){
            int stringLength = s.length();
			StringBuilder sb = new StringBuilder(s);
			if(Character.isLetter(sb.charAt(0)) == true && Character.isLetter(sb.charAt(stringLength -1)) == true){
			   if(stringLength <= arraylength){
			     
			       counts[stringLength] = counts[stringLength ] +1;
			     }else{
			     
			     counts[arraylength] = counts[arraylength] +1;
			     
			     
			     }
			     
			 
			 }
			
			if(Character.isLetter(sb.charAt(0)) == false && Character.isLetter(sb.charAt(stringLength-1)) == true){
			    int actualLength = stringLength -1;
			    
			    if(actualLength < 0){
			     
			        continue;
			     }
			     
			    if(actualLength <= arraylength){
			     
			       counts[actualLength ] = counts[actualLength ] +1;
			     }else{
			     
			     counts[arraylength] = counts[arraylength] +1;
			     
			     
			     }
			     
			 
			 }
			 
			if(Character.isLetter(sb.charAt(0)) == true && Character.isLetter(sb.charAt(stringLength-1)) == false){
			    int actualLength = stringLength -1;
			    if(actualLength < 0){
			     
			        continue;
			     }
			     
			    if(actualLength <= arraylength){
			     
			       counts[actualLength ] = counts[actualLength ] +1;
			     }else{
			     
			     counts[arraylength] = counts[arraylength] +1;
			     
			     
			     }
			     
			 
			 }
			 
			 if(Character.isLetter(sb.charAt(0)) == false && Character.isLetter(sb.charAt(stringLength-1)) == false){
			    int actualLength = stringLength -2;
			    if(actualLength < 0){
			     
			        continue;
			     }
			    if(actualLength <= arraylength){
			     
			       counts[actualLength ] = counts[actualLength ] +1;
			     }else{
			     
			     counts[arraylength] = counts[arraylength] +1;
			     
			     
			     }
			     
			 
			 }
			 
			 
			 
			 
		}
        
        
        }
    
    
    public void testCountWordLengths(){
        
            FileResource resource = new FileResource();
            int []counts = new int[31];
            countWordLengths(resource,counts);
            for(int i=0; i< counts.length; i++){
                if(counts[i]==0){continue;}
             System.out.println("lengh = " + i + "  has  " + counts[i] + " words;");
            
            
            }
            
            int i = indexOfMax(counts);
            System.out.println("index of max = "+ i );
    }
    
    public int indexOfMax(int[] values){
        int max = values[0];
        int index =0;
        for(int i=0; i<values.length; i++){
            
            
            if(values[i]> max){
            
                max = values[i];
                index = i;
            
            }
        
        
        }
        
        return index;
    
    
    
    }
    
    
    
    
    
    
}
