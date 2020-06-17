
/**
 * 在这里给出对类 WordLengths 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;

public class WordLengths {
    void  countWordLengths(FileResource resource, int[] counts){
        int length=0;
        for(String word : resource.words()){
            word = word.toLowerCase();
            length=word.length();
            if(!Character.isLetter(word.charAt(0)))
                length--;
            if(!Character.isLetter(word.charAt(word.length()-1)))
                length--;
            if(length>=counts.length)
                length=counts.length-1;
            if(length>0)
                counts[length]++;
        }       
    }
    void  testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts=new int[31];
        countWordLengths(resource, counts);
        for(int i=0;i<counts.length;i++){
            System.out.println("length "+i+" is "+counts[i]);
        }
        System.out.println("The most length is "+indexOfMax(counts));
    }
    int indexOfMax(int[] values){
        int Max=0;
        for(int k=0;k<values.length;k++){
            if(values[k]>values[Max])
                Max=k;
        }
        return Max;
    }
}
