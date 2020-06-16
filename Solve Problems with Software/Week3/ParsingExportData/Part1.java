
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {
    String countryInfo(String country, CSVParser parser){
        for(CSVRecord record:parser){
            
            if(record.get("Country").equals(country)){
                String mycountry= record.get("Country");
                String items=mycountry+": "+record.get("Exports")+": "+record.get("Value (dollars)");
                return items;
            }
        }
        return "NOT FOUND";
    }
    void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        for(CSVRecord record:parser){
            String exports=record.get("Exports");
            if(exports.contains(exportItem1)&&exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }    
        } 
    }
    int numberOfExporters(CSVParser parser, String exportItem){
        int num=0;
        for(CSVRecord record:parser){
            String exports=record.get("Exports");
            if(exports.contains(exportItem)){
                num=num+1;
            }
        }
        return num;
    }    
    void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record:parser){
            String values= record.get("Value (dollars)");
            if(values.length()>amount.length()){
                System.out.println(record.get("Country")+": "+values);
            }
        }
    }
    void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo("Nauru",parser));
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser,"cotton","flowers");
        //parser = fr.getCSVParser();
        //System.out.println(numberOfExporters(parser,"cocoa"));
        //parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
}