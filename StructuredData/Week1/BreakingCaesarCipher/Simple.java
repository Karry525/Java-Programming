
/**
 * 在这里给出对类 Simple 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Simple {
    private String word; 
     private String phrase; 
     public Simple(int number, String w) { 	
          word = w; 	
          phrase = mystery(number, w);          
     }   
     private String mystery(int num, String s) {  	
          String answer = "";  	
          for (int k=0; k<num; k++) {     	
               answer = answer + s;  	
          }  	
          return answer; 
     } 

     public String toString() { 	
          return phrase + " is " + word + " repeated";
     }
}
