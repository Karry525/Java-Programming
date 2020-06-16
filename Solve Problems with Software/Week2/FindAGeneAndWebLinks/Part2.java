
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.io.*;
public class Part2 {
String findSimpleGene(String dna,int startCodon,int stopCodon){
        int startcodon=dna.indexOf("ATG");
        if(startcodon==-1)
            return"";
        int stopcodon=dna.indexOf("TAA",startcodon+3);
        if(stopcodon==-1)
            return"";
        if((stopcodon-startcodon)%3==0)
            return dna.substring(startcodon,stopcodon+3);
        else
            return "";
    }
    void testSimpleGene(){
    String dna1="aatgcaatactaacataa";
    String dna=dna1.toUpperCase();
    System.out.println("The dna1 is " + dna1);
    System.out.println("The genen is " + findSimpleGene(dna,dna.indexOf("ATG"),dna.indexOf("TAA",dna.indexOf("ATG")+3)).toLowerCase());
    String dna2="AAATGCCCTAACTAGATTAAGAAACC";
    System.out.println("The dna2 is " + dna2);
    System.out.println("The genen is " + findSimpleGene(dna2,dna2.indexOf("ATG"),dna2.indexOf("TAA",dna2.indexOf("ATG")+3)));
    String dna3="AATCAATACTAACATAA";
    System.out.println("The dna1 is " + dna3);
    System.out.println("The genen is " + findSimpleGene(dna3,dna3.indexOf("ATG"),dna3.indexOf("TAA",dna3.indexOf("ATG")+3)));
}
}
