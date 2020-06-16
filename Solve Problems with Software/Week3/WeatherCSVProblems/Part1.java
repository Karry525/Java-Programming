
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part1 {
    CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
		
	for (CSVRecord currentRow : parser) {
			
		lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
	}
	
	
	return lowestSoFar;
    
    }
    public void testColdestInDay () {
		FileResource fr = new FileResource();
		CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
		System.out.println("coldest temperature was " + lowest.get("TemperatureF") +
				   " at " + lowest.get("DateUTC"));
	}
public CSVRecord coldestInManyDays() {
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			// use method to compare two records
			lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
		}
		//The largestSoFar is the answer
		return lowestSoFar;
	}
	public void testcoldestInManyDays () {
		CSVRecord lowest = coldestInManyDays();
		System.out.println("coldest temperature was " + lowest.get("TemperatureF") +
				   " at " + lowest.get("DateUTC"));
	}
	public String fileWithColdestTemperature() {
	     String file="";
	     CSVRecord lowestSoFar = null;
	     DirectoryResource dr = new DirectoryResource();
		// iterate over files
	     for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
			// use method to get largest in file.
		CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			// use method to compare two records
		if (lowestSoFar == null) {
			lowestSoFar = currentRow;
			file=f.getName();
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp < lowestTemp) {
				//If so update largestSoFar to currentRow
				lowestSoFar = currentRow;
				file=f.getName();
			}
		}
}
	     return file;
	}

	public CSVRecord getLowestOfTwo (CSVRecord currentRow, CSVRecord lowestSoFar) {
		//If largestSoFar is nothing
		if (lowestSoFar == null) {
			lowestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp < lowestTemp&&currentTemp!=-9999.0) {
				//If so update largestSoFar to currentRow
				lowestSoFar = currentRow;
			}
		}
		return lowestSoFar;
	}

	public void testFileWithColdestTemperature () {
	    
	    String lowestfile = fileWithColdestTemperature();
	    System.out.println("coldest day was in file "+lowestfile);
	    FileResource fr = new FileResource("nc_weather/2014/"+lowestfile);
	    CSVRecord coldest=coldestHourInFile(fr.getCSVParser());
	    System.out.println("Coldest temperature on that day was "+ coldest.get("TemperatureF"));
	    System.out.println("All the Temperatures on the coldest day were:");
	    CSVParser parser=fr.getCSVParser();
	    for(CSVRecord row: parser){
	        System.out.println(row.get("DateUTC")+": "+row.get("TemperatureF"));
	    }
	}
	CSVRecord lowestHumidityInFile(CSVParser parser){
	    CSVRecord lowestH=null;
	    for(CSVRecord row: parser){
	        if(lowestH==null)
	           lowestH=row;
	        else{
	           if(!row.get("Humidity").equals("N/A")){//important!!!
	               double currentTemp = Double.parseDouble(row.get("Humidity"));
	               double lowestTemp = Double.parseDouble(lowestH.get("Humidity"));
	               if(currentTemp<lowestTemp)
	                   lowestH=row;
	           
	       }
	}
}
    return lowestH;
}
    void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+ csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    CSVRecord lowestHumidityInManyFiles(){
	     CSVRecord lowestHSoFar = null;
	     DirectoryResource dr = new DirectoryResource();
		// iterate over files
	     for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
			// use method to get largest in file.
		CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
		if (lowestHSoFar == null) {
			lowestHSoFar = currentRow;
		}
		//Otherwise
		else {
		        if(!currentRow.get("Humidity").equals("N/A")){
			double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
			double lowestTemp = Double.parseDouble(lowestHSoFar.get("Humidity"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp < lowestTemp) {
				//If so update largestSoFar to currentRow
				lowestHSoFar = currentRow;
			}
                       }
		}
		
             }
             return lowestHSoFar;
    }
    void testLowestHumidityInManyFiles() {
        CSVRecord lowestH=lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+lowestH.get("Humidity")+" at "+lowestH.get("DateUTC"));
    }
    double averageTemperatureInFile(CSVParser parser){
        double sum=0;
        double num=0;
        for(CSVRecord row:parser){
            sum=sum+Double.parseDouble(row.get("TemperatureF"));
            num++;
        }
        return sum/num;
    }
    void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+average);
    }
    double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        double sum=0;
        double num=0;
        for(CSVRecord row:parser){
            if(Integer.parseInt(row.get("Humidity"))>=value){
                sum=sum+Double.parseDouble(row.get("TemperatureF"));
                num++;
            }
            
        }
        if(sum==0.0)
            return sum;
        return sum/num;
    }
    void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser,80);
        if(average==0.0)
            System.out.println("No temperatures with that humidity");
        else
            System.out.println("Average Temp when high Humidity is "+average);
    }
}



