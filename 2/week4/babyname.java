
/**
 * Write a description of babyname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class babyname {

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys_name = 0;
        int totalGirls_name = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys_name += 1;
            }
            else {
                totalGirls_name += 1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("name of female girls = " + totalGirls_name);
        System.out.println("name of male boys = " + totalBoys_name);
    }
    
    
        public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public int getRank(int year,String name,String gender)
    {
        int rank = 1;
        int name_number = 0;
        String fileroot = "us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileroot);
        //System.out.println(fileroot);
         for (CSVRecord rec : fr.getCSVParser(false)) {
            
            if (rec.get(1).equals(gender) && rec.get(0).equals(name)) {
                name_number = Integer.parseInt(rec.get(2));
            }
          
        }
        
           for (CSVRecord rec : fr.getCSVParser(false)) {
            
            if (name_number == 0){
                rank = -1;
                break;
            }
            
            if (Integer.parseInt(rec.get(2)) > name_number && rec.get(1).equals(gender)) {
                rank = rank + 1;
            }
          
        }
        
        
        
    
    
        return rank;
    }
    
    
    public void testgetRank (){
        int i;
        i = getRank(1960, "Emily","F");
        System.out.println(i);
        
        
    }
    
    public String getName (int year, int rank, String gender){
      String name = "NO NAME";
      int currentRank = 0;
      
      String fileroot = "us_babynames_by_year/yob" + year + ".csv";
      FileResource fr = new FileResource(fileroot);
        //System.out.println(fileroot);
         for (CSVRecord rec : fr.getCSVParser(false)) {
             
             if(rec.get(1).equals(gender))
             {
               currentRank = currentRank +1;
             }
             
             if (rec.get(1).equals(gender) && rank == currentRank) {
                name = rec.get(0);
                break;
            }
          
        }
      
      
        
        return name;
   
    
    
    
    }
    
    
    
    public void testGetname (){
    
        String i;
        i = getName(1980, 350,"F");
        System.out.println(i);
    
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
      int rank = 0;
      String fileroot = "us_babynames_by_year/yob" + year + ".csv";
      FileResource fr = new FileResource(fileroot);
      int currentRank = 0;
      for (CSVRecord rec : fr.getCSVParser(false)){
            
            if(rec.get(1).equals(gender))
             {
               rank = rank +1;
             }
             
            if (rec.get(1).equals(gender) && rec.get(0).equals(name)) {
                
                break;
            }
        
        
        
        }
      
      String fileroot1 = "us_babynames_by_year/yob" + newYear + ".csv";
      FileResource fr1 = new FileResource(fileroot1);
      
      for (CSVRecord rec : fr1.getCSVParser(false)){
            
            if(rec.get(1).equals(gender))
             {
               currentRank = currentRank +1;
             }
             
            if (rec.get(1).equals(gender) && rank == currentRank) {
                
                System.out.println(name + " born in " + year + " would be " + rec.get(0)+" if born in " + newYear);
                break;
            }
        
        
        
        }
      
      
      
    }
    
    
    public int yearOfHighestRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        FileResource fr;
        int rank = 0;
        int yearOfHighestRank = 0;
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.substring(3,7));
            //System.out.println(year);
            //fr = new FileResource(f);
            if( rank == 0 || rank == -1){
            
                rank = getRank(year,name,gender);
                yearOfHighestRank = year;
            
            }else{
                if(getRank(year,name,gender) != -1 && getRank(year,name,gender) < rank)
            {
                rank = getRank(year,name,gender);
                yearOfHighestRank = year;
            }}
           
        
       }
    
    
       return yearOfHighestRank;
    }
    
    
    public void testYearOfHigestRank(){
    
      int year = yearOfHighestRank("Genevieve","F");
      System.out.println("The year that has highest rank is " + year);
    
    }
    
    public double getAverageRank(String name, String gender){
    
        DirectoryResource dr = new DirectoryResource();
        FileResource fr;
        double totalrank = 0;
        double numberofFile = 0;
        double averageRank = 0;
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.substring(3,7));
            numberofFile = numberofFile + 1;
            //System.out.println(year);
            //fr = new FileResource(f);
            if( totalrank == 0){
            
                totalrank = getRank(year,name,gender);
                
            
            }else{
                
            
                totalrank = getRank(year,name,gender) + totalrank;
                
            }
           
        
       }
       
       if(totalrank ==0){
        
        averageRank = -1;
        
        }else{
        
        averageRank = totalrank/numberofFile;
        
        
        }
        
        
       
       
       return averageRank;
    
    
    
    
    }
    
    public void testGetAverageRank()
    {
    
         double averageRank = getAverageRank("Susan","F");
         System.out.println("The average rank is " + averageRank);
    
    
    
    
    
    
    }
    
    
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
    
                
                String fileroot = "us_babynames_by_year/yob" + year + ".csv";
                FileResource fr = new FileResource(fileroot);
                int currentRank = 0;
                int numberOfSelectedName = 0;
                int numberOfHighRank = 0;
                
                
                for (CSVRecord rec : fr.getCSVParser(false)){
            
                    if(rec.get(0).equals(name) && rec.get(1).equals(gender))
                    {
                        numberOfSelectedName = Integer.parseInt(rec.get(2));
                    }
             
                   
        
                }
    
                for (CSVRecord rec : fr.getCSVParser(false)){
            
                    if(rec.get(1).equals(gender) && Integer.parseInt(rec.get(2)) >= numberOfSelectedName ){
                       
                        
                        if(rec.get(0).equals(name)){
                            
                            continue;
            
                        }
                      
                        
                      numberOfHighRank = numberOfHighRank + Integer.parseInt(rec.get(2));
                    
                      
                    
                    
                    }
                
                
                }
                
                return numberOfHighRank;
                
                }
                    
                   
             
                   
        
                
    
    
               
    
    
    
    
    public void testNumberofHighRank(){
    
        double numberOfHighRank = getTotalBirthsRankedHigher(1990,"Emily","F");
        System.out.println("The NumberofHighRank is " + numberOfHighRank);
        
        
        
        
    
    
    }
    
    
    
    
}
