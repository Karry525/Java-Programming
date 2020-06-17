
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         // complete constructor
     }
        
     public void readFile(String filename) {
         FileResource fr= new FileResource(filename);
         for(String s: fr.lines()){
             
             LogEntry log= WebLogParser.parseEntry(s);//?!
             records.add(log);
            }
         // complete method
     }
     public void printAllHigherThanNum(int num){
         for(LogEntry le:records){
             int status=le.getStatusCode();
             if(status>num)
                System.out.println(le);
         }
     }
     public int countUniqueIPs(){
         ArrayList<String> unique= new ArrayList<String>();
         for(LogEntry le:records){
             String ipAddr=le.getIpAddress();
             if(!unique.contains(ipAddr))
                unique.add(ipAddr);
             
         }
         return unique.size();
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIP= new ArrayList<String>();
         for(LogEntry le:records){
             String d=le.getAccessTime().toString();
             //System.out.println(d);
             String date=d.substring(8,10);
             System.out.println("date="+date);
             String mon=d.substring(4,7);
             System.out.println("mon="+mon);
             String ipAddr=le.getIpAddress();
             if(date.equals(someday.substring(4,6))&&mon.equals(someday.substring(0,3))&&(!uniqueIP.contains(ipAddr)))
                uniqueIP.add(ipAddr);
                                                                 
         }
         return uniqueIP;
     }
     public int countUniqueIPsInRange (int low, int high){
        int num=0;
        ArrayList<String> uniqueIP= new ArrayList<String>();
        for(LogEntry le:records){
            int status=le.getStatusCode();
            String ipAddr=le.getIpAddress();
            if(status>=low&&status<=high&&(!uniqueIP.contains(ipAddr))){
                num++;
                uniqueIP.add(ipAddr);
            }
        }
        return num;
     }
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String ,Integer> counts=new HashMap<String, Integer>();
         for(LogEntry le:records){
             String ip=le.getIpAddress();
             if(!counts.containsKey(ip))
                counts.put(ip,1);
             else{
                 counts.put(ip,counts.get(ip)+1);
             }
         }
         return counts;
     }
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
         int max=0;
         for(String ip:counts.keySet()){
             if(counts.get(ip)>max)
                max=counts.get(ip);
         }
         return max;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts){
         ArrayList<String> mostip=new ArrayList<String>();
         int max=mostNumberVisitsByIP(counts);
         for(String ip:counts.keySet()){
             if(counts.get(ip)==max)
                mostip.add(ip);
        }       
        return mostip;         
         
     }
     HashMap<String,ArrayList<String>> iPsForDays(){
         HashMap<String,ArrayList<String>> dateIP=new HashMap<String,ArrayList<String>>();
         for(LogEntry le:records){
             String d=le.getAccessTime().toString();
             String date=d.substring(8,10);
             String mon=d.substring(4,7);
             String day=mon+" "+date;
             String ip=le.getIpAddress();
             if(!dateIP.containsKey(day)){                 
                 dateIP.put(day,new ArrayList<String>());                 
             }
             dateIP.get(day).add(ip);                         
                                                                                           
         }
         return dateIP;
     }
     String dayWithMostIPVisits(HashMap<String,ArrayList<String>> dateIP){
         int max=0;
         String maxDate="";
         for(String day:dateIP.keySet()){
             int times=dateIP.get(day).size();
             if(times>max){
                 max=times;
                 maxDate=day;
             }
         }
         return maxDate;
     }
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> dateIP,String date){
         ArrayList<String> mostIP= new ArrayList<String>();
         ArrayList<String> IPs= new ArrayList<String>();
         HashMap<String ,Integer> counts=new HashMap<String, Integer>();
         for(String day:dateIP.keySet()){
             //System.out.println(day);
             if(day.equals(date)){
                 //System.out.println(day);
                 IPs= dateIP.get(day);
                 for(String ip: IPs){
                     if(!counts.containsKey(ip))
                         counts.put(ip,1);
                     else{
                         counts.put(ip,counts.get(ip)+1);
                     }
                 }
             }
             
         }
         mostIP= iPsMostVisits(counts);
         return mostIP;
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
