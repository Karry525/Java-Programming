
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.io.*;
public class Part1 {
    String findSimpleGene(String dna){
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
    String dna1="AATGCAATACTAACATAA";
    System.out.println("The dna1 is " + dna1);
    System.out.println("The genen is " + findSimpleGene(dna1));
    String dna2="AATCCAATACTAACATAA";
    System.out.println("The dna2 is " + dna2);
    System.out.println("The genen is " + findSimpleGene(dna2));
    String dna3="AATCAATACTAACATAA";
    System.out.println("The dna1 is " + dna3);
    System.out.println("The genen is " + findSimpleGene(dna3));
}
}
