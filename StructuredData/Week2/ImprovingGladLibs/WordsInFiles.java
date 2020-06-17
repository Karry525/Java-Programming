
/**
 * 在这里给出对类 WordsInFiles 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;
import java.io.*;
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    public WordsInFiles(){
        map=new HashMap<String, ArrayList<String>>();
    }
    public void addWordsFromFile(File f){
        FileResource fr=new FileResource(f);
        String name=f.getName();
        for(String word: fr.words()){
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<String>());//important!
                ArrayList l=map.get(word);
                l.add(name);
                              
            }
            else{
                if(!map.get(word).contains(name))
                    map.get(word).add(name);
            }
        }
    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles())
            addWordsFromFile(f);
        
    }
    public int maxNumber(){
        int max=0;
        for(String word: map.keySet()){
            if(map.get(word).size()>max)
                max=map.get(word).size();
            
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> list=new ArrayList<String>();
        for(String word: map.keySet()){
            if(map.get(word).size()==number)
                list.add(word);
        }         
        return list;
    }
    public void printFilesIn(String word){
        ArrayList list=map.get(word);
        for(int k=0;k<list.size();k++)
            System.out.println(list.get(k));
    }
    public void tester(){
        buildWordFileMap();
        int max=4;//maxNumber();
        ArrayList<String> list=wordsInNumFiles(max);
        //System.out.println("The greatest number of files a word appears in is "
        //+max+" and there are "+list.size()+" such words: ");
        System.out.println("sea");
        printFilesIn("sea");
        for(int k=0;k<list.size();k++)
            //System.out.println(list.get(k));
            
        for(int i=0;i<list.size();i++){
            
            //System.out.println(list.get(i)+" are in files:");
            //printFilesIn(list.get(i));
        }
        }
    }

