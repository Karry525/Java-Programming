
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("short-test_log");
        LA. printAll();
        // complete method
    }
    public void testUniqueIP(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        int num=LA.countUniqueIPs();
        System.out.println("number of IPAddresses: "+num);
    }
    public void testprintAllHigherThanNum(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog1_log");
        int num=400;
        System.out.println("The staus> "+num+":");
        LA.printAllHigherThanNum(num);
    }
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        ArrayList<String> ip=LA.uniqueIPVisitsOnDay("Sep 24");
        System.out.println(ip.size());
        for(int k=0;k<ip.size();k++)
            System.out.println(ip.get(k));
            
    }
    public void testcountUniqueIPsInRange(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        int num=LA.countUniqueIPsInRange(400,499);
        System.out.println("The number of ipAddr: "+num);
    }
    public void testcountVisitsPerIPandMost(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        HashMap<String, Integer> hm=LA.countVisitsPerIP();
        for(String ip:hm.keySet()){
            System.out.println(ip+" visited "+hm.get(ip)+" times");
        }
        System.out.println("The maximum visit number: "+LA.mostNumberVisitsByIP(hm));
    }
    public void testiPsMostVisits(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        HashMap<String, Integer> counts=LA.countVisitsPerIP();
        ArrayList mostIP=LA.iPsMostVisits(counts);
        for(int k=0;k<mostIP.size();k++)
            System.out.println(mostIP.get(k));;
    }
    public void testiPsForDays(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> dateIP=LA.iPsForDays();
        for(String day:dateIP.keySet()){
            System.out.println(day);
            ArrayList<String> ips=dateIP.get(day);
            for(int k=0;k<ips.size();k++)
                System.out.println(ips.get(k));
        }
        System.out.println("The day with most IP: "+LA.dayWithMostIPVisits(dateIP));
        
    }    
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer LA=new LogAnalyzer();
        LA.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> dateIP=LA.iPsForDays();
        ArrayList<String> mostIP=LA.iPsWithMostVisitsOnDay(dateIP,"Sep 29");
        System.out.println(mostIP.size());
        for(int k=0;k<mostIP.size();k++)
            System.out.println(mostIP.get(k));
    }
    
}
