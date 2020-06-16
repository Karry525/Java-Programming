
/**
 * 在这里给出对类 Part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
public class Part4 {//important!!!
     void printUrls(String url) { 
       URLResource myurl = new URLResource(url); 
        for(String word : myurl.words()) { 
            int pos=word.toLowerCase().indexOf("youtube.com") ;
             if(pos!= -1) { 
                int beg = word.lastIndexOf("\"",pos); 
                
               int end = word.indexOf("\"", pos+1); 
        
               System.out.println(word.substring(beg+1, end)); 
                
            } 
        } 

        }
     void testing(){
         printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
     }
}