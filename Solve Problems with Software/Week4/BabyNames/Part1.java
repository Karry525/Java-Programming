
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
    public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += 1;
			}
			else {
				totalGirls += 1;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	} 
    void testtotalBriths(){
        FileResource fr = new FileResource();
	totalBirths(fr);
    }
    int getRank(int Year, String Name, String Gender){
        int rankBoy=0;
        int rankGirl=0;
        FileResource fr = new FileResource("data/yob"+Year+".csv");
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("F")){
                rankGirl++;
                if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender))
                    return rankGirl;
            }
            else{
                rankBoy++;
                if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender))
                    return rankBoy;
            }
            
        }
        return -1;
    }
    void testgetRank(){
        System.out.println("The rank is "+getRank(1971,"Frank","M"));
    }
    String  getName (int rank,String Gender,int Year){
        FileResource fr = new FileResource("data/yob"+Year+".csv");
        int rankBoy=0;
        int rankGirl=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("F")){
                rankGirl++;
                if(rankGirl==rank&&Gender=="F")
                    return rec.get(0);
            }
            if(rec.get(1).equals("M")){
                rankBoy++;
                if(rankBoy==rank&&Gender=="M")
                    return rec.get(0);
            }
        }
        return "No Name";
    }
    
    void testgetName(){
        System.out.println("The Name is "+getName(450,"M",1982));
    }
    void whatIsNameInYear(int Year, int newYear, String Name, String Gender){
        int rank=getRank(Year,Name,Gender);
        String newName=getName(rank,Gender,newYear);
        if(Gender.equals("F"))
            System.out.println(Name+" born in "+Year+" would be "+newName+" if she was born in "+newYear);
        if(Gender.equals("M"))
            System.out.println(Name+" born in "+Year+" would be "+newName+" if he was born in "+newYear);
    }
    void testwhatIsNameInYear(){
        whatIsNameInYear(1974,2014,"Owen","M");
    }
    int yearOfHighestRank(String Name, String Gender){
        int HighestRank=-1;
        
        String fileName="";
        int HighestYear=-1;
        DirectoryResource dr = new DirectoryResource();
	for (File f : dr.selectedFiles()) {
	    int rank=0;
            int rankGirl=0;
            int rankBoy=0;
	    FileResource fr = new FileResource(f);
	    for (CSVRecord rec : fr.getCSVParser(false)) {
                if(rec.get(1).equals("F")){
                    rankGirl++;
                    if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender)){
                        rank= rankGirl;
                        
                    }
                    }
                else{
                    rankBoy++;
                    if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender))
                        rank= rankBoy;
                    }
            
            }
            //System.out.println(rank);
            if((rank<HighestRank&&rank!=0)||(HighestRank==-1&&rank!=0)){
                HighestRank=rank;
                fileName = f.getName();
            }
	}
	if(HighestRank!=-1)
	   HighestYear=Integer.parseInt(fileName.substring(3,7));
	return HighestYear;
    }
    void testyearOfHighestRank(){
        System.out.println("The highest rank is in "+yearOfHighestRank("Mich","M"));
        
    }
    double getAverageRank(String Name, String Gender){
        double average=-1.0;
        DirectoryResource dr = new DirectoryResource();
        double sum=0.0;
        double num=0.0;
	for (File f : dr.selectedFiles()) {
	    double rank=0.0;
            double rankGirl=0.0;
            double rankBoy=0.0;
            num++;
	    FileResource fr = new FileResource(f);
	    for (CSVRecord rec : fr.getCSVParser(false)) {
                if(rec.get(1).equals("F")){
                    rankGirl++;
                    if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender)){
                        rank= rankGirl;
                        
                    }
                    }
                else{
                    rankBoy++;
                    if(rec.get(0).equals(Name)&&rec.get(1).equals(Gender))
                        rank= rankBoy;
                    }
            
            }
            sum=sum+rank;
        }
        //System.out.println(sum);
        //System.out.println(num);
        if(sum!=0.0)
            average=sum/num;
        return average;
    }
    void testgetAverageRank(){
        System.out.println("The average rank is "+getAverageRank("Robert","M"));
    }
    int getTotalBirthsRankedHigher (int Year,String Name,String Gender){
        FileResource fr = new FileResource("data/yob"+Year+".csv");
        int rank=getRank(Year,Name,Gender);
        System.out.println(rank);
        int newRank=0;
        int total=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(Gender)){
                newRank++;
                if(newRank<rank)
                
                    total=total+Integer.parseInt(rec.get(2));
            }
        }
        return total;
        
    }    
    void testgetTotalBirthsRankedHigher(){
        System.out.println("The total births number is "+getTotalBirthsRankedHigher(1990,"Emily","F"));
    }
}
