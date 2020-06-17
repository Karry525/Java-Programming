
/**
 * 在这里给出对类 CharactersInPlay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> Names;
    private ArrayList<Integer> Freqs;
    public CharactersInPlay(){
        Names= new ArrayList<String>();
        Freqs= new ArrayList<Integer>();
    }
    void update(String person){
        int index=Names.indexOf(person);
        if(index==-1){
            Names.add(person);
            Freqs.add(1);
        }
        else{
            int val=Freqs.get(index);
            Freqs.set(index,val+1);
        }
    }
    void findAllCharacters(){
        FileResource fr= new FileResource();
        for(String line:fr.lines()){
            int index=line.indexOf(".");
             if (index > -1) {
                int nonblank = 0;
                while (nonblank < index) {
                    if (!line.substring(nonblank, nonblank+1).equals(" ")) break;
                    else nonblank = nonblank + 1;
                    
                }
                String person = line.substring(nonblank, index);
                update(person);
            }
        }
    }
    private void charactersWithNumParts(int num1,int num2) {
        int num=0;
        for (int k = 0; k < Names.size(); k++) {
            if (Freqs.get(k)>=num1&&Freqs.get(k)<=num2) {
                System.out.println(Names.get(k) + ": "+ Freqs.get(k)+ "\t");
                num++;
            }
        }
        System.out.println("The number between "+num1+" and "+num2+" are : "+num);
    }
    int MaxFreq(){
        int max=0;
        int maxIndex=0;
        for(int k=0;k<Freqs.size();k++){
            if(Freqs.get(k)>max){
                max=Freqs.get(k);
                maxIndex=k;
            }
            
        }
        return maxIndex;
    }
     public void tester() {
        findAllCharacters();
        for(int k=0;k<Names.size();k++){
            //System.out.println(Names.get(k) + ": "+ Freqs.get(k)+ "\t");
        }
        System.out.println("The main character names are : ");
        charactersWithNumParts(10,15);
        int max=MaxFreq();
        System.out.println("The most names: "+Names.get(max)+"\t"+Freqs.get(max));
    }
    

}
