
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.io.*;
public class Part3 {
    Boolean twoOccurrences(String stringa,String stringb){
        int pos=stringb.indexOf(stringa);
        if(pos==-1)
            return false;
        if((stringb.indexOf(stringa,pos+1))!=-1)
            return true;
        else
            return false;
    }
    String lastPart(String stringa,String stringb){
        int pos=stringb.indexOf(stringa);
        if(pos==-1)
            return stringb;
        return stringb.substring(pos+stringa.length(),stringb.length());//importan!!!
    }
    void testing(){
        String a1="by";
        String b1="A story by Abby Long";
        System.out.println("String a1 is "+a1);
        System.out.println("String b1 is "+b1);
        System.out.println(twoOccurrences(a1,b1));
        String a2="an";
        String b2="banana";
        System.out.println("String a2 is "+a2);
        System.out.println("String b2 is "+b2);
        System.out.println(twoOccurrences(a2,b2));
        System.out.println(lastPart(a2,b2));
        String a3="atg";
        String b3="ctgtatgta";
        System.out.println("String a3 is "+a3);
        System.out.println("String b3 is "+b3);
        System.out.println(twoOccurrences(a3,b3));
        System.out.println(lastPart(a3,b3));
        String a4="zoo";
        String b4="cama";
        System.out.println("String a3 is "+a4);
        System.out.println("String b3 is "+b4);
        System.out.println(lastPart(a4,b4));
        
        
 
    }
}
