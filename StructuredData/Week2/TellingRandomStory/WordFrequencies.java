
/**
 * 在这里给出对类 WordFrequencies 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer>myFreqs;
    public WordFrequencies(){
        myWords= new ArrayList<String>();
        myFreqs= new ArrayList<Integer>();
    }
    public void findUnique(){
        if(myWords.size()!=0){
            myWords.clear();
            myFreqs.clear();
        }
        //FileResource resource = new FileResource();
        
        //for(String s : resource.words()){
            //s = s.toLowerCase();
            //int index = myWords.indexOf(s);
            //if (index == -1){
                //myWords.add(s);
                //myFreqs.add(1);
          //  }
            //else {
            //    int freq = myFreqs.get(index);
            //    myFreqs.set(index,freq+1);
          //  }
      //  }
        FileResource fr= new FileResource();
        for(String s: fr.words()){
            s=s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index==-1){
                myWords.add(s);
                myFreqs.add(1);                
            }
            else{
                int val=myFreqs.get(index);
                myFreqs.set(index,val+1);
            }
        
        }     
    }
    public int  findIndexOfMax(){
        int max=0;
        int maxIndex=0;
        for(int k=0;k<myFreqs.size();k++){
            if(myFreqs.get(k)>max){
                max=myFreqs.get(k);
                maxIndex=k;
            }
            
            
        }
        return maxIndex;
    }
    public void test(){
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for(int k=0;k<myWords.size();k++){
            //System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
        }
        int max=findIndexOfMax();
        System.out.println("The word that occurs most often and its count are:"+
        myWords.get(max)+"\t"+myFreqs.get(max));
    }
}
