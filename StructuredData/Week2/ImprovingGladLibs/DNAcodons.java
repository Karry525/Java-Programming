
/**
 * 在这里给出对类 DNAcodons 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;

public class DNAcodons {
    private HashMap<String,Integer> map;
    public DNAcodons(){
        map = new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna){
        dna=dna.toUpperCase();
        if(map.size()!=0)
            map.clear();
        for(int k=start;k+2<dna.length();k+=3){
            String codon=dna.substring(k,k+3);
   
            if (!map.containsKey(codon)){
                
		map.put(codon,1);
            }
	    else {
		map.put(codon,map.get(codon)+1);
	    }
        }
    }
    public String getMostCommonCodon(){
        int max=0;
        String Mostcodon="";
        for(String codon: map.keySet()){
            if(map.get(codon)>max){
                max=map.get(codon);
                Mostcodon=codon;
                
            }
        }
        return Mostcodon;
    }
    public void printCodonCounts(int start, int end){
        for(String codon: map.keySet()){
            //if(map.get(codon)>=start&&map.get(codon)<=end)
                System.out.println(codon+"\t"+map.get(codon));
        }
    }
    public void tester(){
        FileResource fr=new FileResource();
        String dna=fr.asString().trim();
        System.out.println(dna+"a");
        for(int k=0;k<3;k++){
            buildCodonMap(k,dna);
            System.out.println("The number of codons: "+map.size());
            String most=getMostCommonCodon();
            System.out.println("The most common codons: "+most+"\t"+map.get(most));
            printCodonCounts(1,5);
        }
    }
}
