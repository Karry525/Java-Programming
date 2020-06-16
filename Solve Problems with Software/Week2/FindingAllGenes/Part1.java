
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class Part1 {
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
    void testFindStopCodon(){
        String dna1="ATGAATAACTAGTGA";
        System.out.println("The TAA stopindex is "+ findStopCodon(dna1,0,"TAA"));
        System.out.println("The TAG stopindex is "+ findStopCodon(dna1,0,"TAG"));
        System.out.println("The TGA stopindex is "+ findStopCodon(dna1,0,"TGA"));
        
        
    }
    String findGene(String dna,int where){
        int startIndex=dna.indexOf("ATG",where);
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
    void testFindGene(){
        String dna1="TAAAGC";
        System.out.println("The dna1 is  "+ dna1);
        System.out.println("The gene is  "+ findGene(dna1,0));
        String dna2="TATGACCTATTCCATT";
        System.out.println("The dna2 is  "+ dna2);
        System.out.println("The gene is  "+ findGene(dna2,0));
        String dna3="TATGACTAATTGACCTTAATAG";
        System.out.println("The dna3 is  "+ dna3);
        System.out.println("The gene is  "+ findGene(dna3,0));
        String dna4="ATGATG";
        System.out.println("The dna4 is  "+ dna4);
        System.out.println("The gene is  "+ findGene(dna4,0));
    }
    void printAllGenes(String dna){//?
        int startIndex=0;
        while(true){
            String currGene=findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            
           }
           System.out.println(currGene);
           startIndex=dna.indexOf(currGene,startIndex)+currGene.length();
        }
    }
    void testAllGenes(){
        String dna="AATGTAACATGTAG";
        printAllGenes(dna);
    }
}