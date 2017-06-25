
/**
 * Write a description of coldWheather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class coldWheather {
    public CSVRecord getColdestOfTwo (CSVRecord currentRow, CSVRecord lowestSoFar) {
		//If largestSoFar is nothing
		if (lowestSoFar == null) {
			lowestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if(currentTemp > -1000){
			if (currentTemp < lowestTemp) {
				//If so update largestSoFar to currentRow
				lowestSoFar = currentRow;
			}
		}
      }
		return lowestSoFar;
	}
    
	
		public CSVRecord coldestHourInFile(CSVParser parser) {
		//start with largestSoFar as nothing
		CSVRecord lowestSoFar = null;
		//For each row (currentRow) in the CSV File
		for (CSVRecord currentRow : parser) {
			// use method to compare two records
			lowestSoFar = getColdestOfTwo(currentRow, lowestSoFar);
		}
		//The largestSoFar is the answer
		return lowestSoFar;
	}
    
	public void testLowesttestInDay () {
		FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
		CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
		System.out.println("lowesttest temperature was " + lowest.get("TemperatureF") +
				   " at " + lowest.get("TimeEST"));
	}
    
	public String fileWithColdestTemperature() {
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		File lowestFile = null;
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			// use method to compare two records
			lowestSoFar = getColdestOfTwo(currentRow, lowestSoFar);
			if(lowestSoFar == currentRow){
			 lowestFile = f;
			 }
		}
		//The largestSoFar is the answer
		return lowestFile.getName();
		
	}
	
	public void testFileWithColdestTemperature() {
		String lowest = fileWithColdestTemperature();
		System.out.println("Coldest day was in file " + lowest);
		FileResource fr = new FileResource("nc_weather/2014/"+lowest);
		CSVParser parser = fr.getCSVParser();
		CSVParser parser1 = fr.getCSVParser();
		CSVRecord lowest_CSV = coldestHourInFile(parser);
		System.out.println("lowesttest temperature was " + lowest_CSV.get("TemperatureF"));
		System.out.println("All the Temperatures on the coldest day were:");
		for (CSVRecord currentRow : parser1) {
		    
		  System.out.println(currentRow.get("DateUTC")+" "+currentRow.get("TemperatureF"));
		  
		  
		  }
    }
	
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
		  for (CSVRecord currentRow : parser){
		  
		      if(lowestSoFar == null){
		          lowestSoFar = currentRow;
		  
		  
		      }
		     String s =  currentRow.get("Humidity");
		    if( s.equals("N/A") == false ){  
		    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
			if(currentTemp < lowestTemp){
			 lowestSoFar = currentRow;
			 
			
			 }
		  
		  
		  
		  
		   } 
          }
		
          
        return lowestSoFar;
		  
		  
		  
    
   }
	
    public void testLowestHumidityInFile(){
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        
        System.out.println("Lowest Humidity was " + csv.get("Humidity")+" at "+csv.get("DateUTC"));
    
    
    
    
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
      CSVRecord lowestSoFar = null;
	  DirectoryResource dr = new DirectoryResource();
      
	  
	  for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
			// use method to compare two records
			lowestSoFar = getloewestHumidityOfTwo(currentRow, lowestSoFar);
			
		}
      
		return lowestSoFar;
      
    
    }
    
    public CSVRecord getloewestHumidityOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar){
        if (lowestSoFar == null) {
			lowestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp < lowestTemp) {
				//If so update largestSoFar to currentRow
				lowestSoFar = currentRow;
			}
		}
		return lowestSoFar;
    
    
    }
    
    public void testLowestHumidityInManyFiles(){
      CSVRecord lowestSoFar = lowestHumidityInManyFiles();
      System.out.println("Lowest Humidity was " + lowestSoFar.get("Humidity")+" at "+lowestSoFar.get("DateUTC"));
    
    
    
    }
    
    public double averageTemperatureInFile (CSVParser parser){
    
      double averageTemperature = 0;
      double totalTemperature = 0;
      int total = 0;
      for(CSVRecord currentRow : parser){
        totalTemperature = Double.parseDouble(currentRow.get("TemperatureF")) +totalTemperature;
        total = total +1;
        
        
        }
    
      averageTemperature = totalTemperature/total;
      
      return averageTemperature;
    
    }
    
    public void  testAverageTemperatureInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperature = averageTemperatureInFile(parser);
        
       
        System.out.println("Average temperature in file is " + averageTemperature );
        
        
        
	}
	
	public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
	     double averageTemperature = 0;
         double totalTemperature = 0;
         int total = 0;
	    
	    for(CSVRecord currentRow : parser){
         if(Double.parseDouble(currentRow.get("Humidity")) >= value){
            totalTemperature = totalTemperature + Double.parseDouble(currentRow.get("TemperatureF"));
            total = total + 1;
            
            
            
            }
       
         
        
        
        }
	    
        if(total != 0){
           averageTemperature = totalTemperature/total;
        }
	    return averageTemperature;
	   
	   
	   
	   
	}
	
	public void testAverageTemperatureWithHighHumidityInFile()
	{
	   
	    FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemperatureWithHighHumidityInFile = averageTemperatureWithHighHumidityInFile(parser,80);
        
        if(averageTemperatureWithHighHumidityInFile == 0)
        {
          System.out.println("No temperatures with that humidity ");
        
        }else{
        System.out.println("Average Temp when high Humidity is " + averageTemperatureWithHighHumidityInFile );
        
        }
	   
	   
	   
	   
	   
	
	   
	   }
	
	
	
	
}
	
	
	
	
	
	
	
    

