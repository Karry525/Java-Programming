
/**
 * 在这里给出对类 GladLibMap 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;

public class GladLibMap {


    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> Store;
    private ArrayList<String> Storelabel;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap= new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        myMap= new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] category={"country","color","noun","name","adjective","animal",
            "verb","fruit","timeframe"};
        for(String s:category){
            ArrayList<String> list=readIt(source+ "/"+s+".txt");
            myMap.put(s,list);
        }
        Store=new ArrayList<String>();
        Storelabel=new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (!Storelabel.contains(label)) Storelabel.add(label);
        return randomFrom(myMap.get(label));
        
        
    }
    
    private String processWord(String w){
        
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);        
        String sub = "";
        int index=0;
        while(true){
            sub = getSubstitute(w.substring(first+1,last));
            index=Store.indexOf(sub);
            if(index==-1){
                Store.add(sub);
                return  prefix+sub+suffix;
            }
        }    
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        //System.out.println("s= "+s);
        for(String w : s.split("\\s+")){
            //System.out.println("w= "+w);
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public int totalWordsInMap(){
        int num=0;
        
        for(String label: myMap.keySet()){
            //System.out.println(label);
            num=num+myMap.get(label).size();
        }
        return num;
    }
    public int totalWordsConsidered(){
        int num=0;        
        for(int k=0;k<Storelabel.size();k++){
            //System.out.println(Storelabel.get(k));
            num+=myMap.get(Storelabel.get(k)).size();
        }
        return num;
    }
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nReplaced words: "+Store.size());
        System.out.println("The total word in map: "+totalWordsInMap());
        System.out.println("The total considered word in map: "+totalWordsConsidered());
	}
}
