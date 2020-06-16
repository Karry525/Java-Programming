
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class Part2 {
    int howmany(String stringa,String stringb){
        int start=stringb.indexOf(stringa);
        int num=0;
        while(true){
            if(start==-1)
                break;
            num=num+1;
            start=stringb.indexOf(stringa,start+stringa.length());
        }
        return num;
    }
    void testHowMany(){
        String a1="GAA";
        String b1="ATGAACGAATTGAATC";
        System.out.println("The a1 occurs "+howmany(a1,b1)+" times");
        String a2="AA";
        String b2="ATAAAA";
        System.out.println("The a2 occurs "+howmany(a2,b2)+" times");
    }
}
