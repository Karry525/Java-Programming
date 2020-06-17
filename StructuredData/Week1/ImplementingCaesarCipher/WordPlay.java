
/**
 * 在这里给出对类 WordPlay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class WordPlay {
    Boolean isVowel(char ch){
        Boolean b=false;
        StringBuilder encrypted = new StringBuilder("aeiou");
        for(int i=0; i<encrypted.length();i++){
            if(Character.toLowerCase(ch)==encrypted.charAt(i))
                b=true;
        }
        return b;
    }
    void testisVowel(){
        char ch='A';
        if(isVowel(ch))
            System.out.println(ch+" is vowel");
        else
            System.out.println(ch+" is not vowel");
        
    }
    String replaceVowels(char ch,String phase){
        StringBuilder encrypted = new StringBuilder(phase);
        for(int i=0; i<encrypted.length();i++){
            char currchar=encrypted.charAt(i);
            if(isVowel(currchar)){
                encrypted.setCharAt(i, ch);
            }
        }
        return encrypted.toString();
    }
    void testreplaceVowels(){
        System.out.println(replaceVowels('*',"HelloWorld"));
    }
    String emphasize(char ch, String phase){
        int idx=0;
        StringBuilder encrypted = new StringBuilder(phase);
        for(int i=0; i<encrypted.length();i++){
            char currchar=encrypted.charAt(i);
            if(Character.toLowerCase(currchar)==Character.toLowerCase(ch)){
                
                if((i+1)%2==0)
                    encrypted.setCharAt(i, '+');
                else
                    encrypted.setCharAt(i, '*');
            } 
               
        }
        return encrypted.toString();
    }
    void testemphasize(){
        System.out.println(emphasize('a',"dna ctgaaactga"));
        System.out.println(emphasize('a',"Mary Bella Abracadabra")); 
    }
}
