
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class Part3 {
    String findGene(String dna){
        int startIndex=dna.indexOf("ATG");
        if(startIndex==-1)
            return "";
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        int MinIndex=Math.min(Math.min(taaIndex,tagIndex),tgaIndex);
        if(MinIndex==dna.length())
            return "";
        return dna.substring(startIndex,MinIndex+3);
    }
    int findStopCodon(String dna, int startIndex, String stopcodon){
        int currIndex=dna.indexOf(stopcodon,startIndex+3);
        while(currIndex!=-1){
            if((currIndex-startIndex)%3==0)
                return currIndex;
            else
                currIndex=dna.indexOf(stopcodon,currIndex+1);
             
        }
        return dna.length();
    }
    void printAllGenes(String dna){//?
        int startIndex=dna.indexOf("ATG");
        String currGene="";
        while(true){
            
            if(startIndex==-1)
                break;
            int taaIndex=findStopCodon(dna,startIndex,"TAA");
            int tagIndex=findStopCodon(dna,startIndex,"TAG");
            int tgaIndex=findStopCodon(dna,startIndex,"TGA");
            int MinIndex=Math.min(Math.min(taaIndex,tagIndex),tgaIndex);
            if(MinIndex==dna.length())
                break;
            else
                currGene=dna.substring(startIndex,MinIndex+3);
            
            if(currGene.isEmpty())
                break;
            System.out.println(currGene);
            startIndex=dna.indexOf("ATG",startIndex+currGene.length());
        }
    }
    int countGenes(String dna){
        int startIndex=dna.indexOf("ATG");
        String currGene="";
        int num=0;
        while(true){
            
            if(startIndex==-1)
                break;
            int taaIndex=findStopCodon(dna,startIndex,"TAA");
            int tagIndex=findStopCodon(dna,startIndex,"TAG");
            int tgaIndex=findStopCodon(dna,startIndex,"TGA");
            int MinIndex=Math.min(Math.min(taaIndex,tagIndex),tgaIndex);
            if(MinIndex==dna.length())
                break;
            else
                currGene=dna.substring(startIndex,MinIndex+3);
            
            if(currGene.isEmpty())
                break;
            num=num+1;
            startIndex=dna.indexOf("ATG",startIndex+currGene.length());
        }
        return num;
    }
    void testCountGenes(){
        String dna="ATGTAAGATGCCCTAGT";
        System.out.println("DNA has "+countGenes(dna)+" genes");
    }
}
