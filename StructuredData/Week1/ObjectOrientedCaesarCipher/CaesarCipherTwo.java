
/**
 * 在这里给出对类 CaesarCipherTwo 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1;
    private int mainkey2;
    public CaesarCipherTwo(int key1,int key2){
        mainkey1=key1;
        mainkey2=key2;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
    }
    String encrypt(String input){
        CaesarCipher cc1 = new CaesarCipher(mainkey1);
        CaesarCipher cc2 = new CaesarCipher(mainkey2);
        String input1="";
        String input2="";
        int k;
        for(k=0;k<input.length();k+=2){
            //sb.insert(message.length()-1,message.charAt[k]);
            input1=input1+input.charAt(k);
        }
        for(k=1;k<input.length();k+=2){
            //sb.insert(message.length()-1,message.charAt[k]);
            input2=input2+input.charAt(k);
        }
        String a=cc1.encrypt(input1);
        String b=cc2.encrypt(input2);
        //System.out.println("a="+a.length());
        //System.out.println("b="+b.length());
        int index1=0;
        int index2=0;
        String sb="";
        for( k=0;k<input.length();k++){
            //System.out.println("k%2="+k%2);
            if(k%2==0){
                //System.out.println("k%2="+k%2);
                sb=sb+a.charAt(index1);
                index1++;
                //System.out.println("index1="+index1);
            }
            else{
                sb=sb+b.charAt(index2);
                index2++; 
                //System.out.println("index2="+index2);
            }
    }
    return sb;
}
    String decrypt(String input){
        CaesarCipher cc1 = new CaesarCipher(26-mainkey1);
        CaesarCipher cc2 = new CaesarCipher(26-mainkey2);
        String input1="";
        String input2="";
        int k;
        for(k=0;k<input.length();k+=2){
            //sb.insert(message.length()-1,message.charAt[k]);
            input1=input1+input.charAt(k);
        }
        for(k=1;k<input.length();k+=2){
            //sb.insert(message.length()-1,message.charAt[k]);
            input2=input2+input.charAt(k);
        }
        String a=cc1.encrypt(input1);
        String b=cc2.encrypt(input2);
        //System.out.println("a="+a.length());
        //System.out.println("b="+b.length());
        int index1=0;
        int index2=0;
        String sb="";
        for( k=0;k<input.length();k++){
            //System.out.println("k%2="+k%2);
            if(k%2==0){
                //System.out.println("k%2="+k%2);
                sb=sb+a.charAt(index1);
                index1++;
                //System.out.println("index1="+index1);
            }
            else{
                sb=sb+b.charAt(index2);
                index2++; 
                //System.out.println("index2="+index2);
            }
    }
    return sb;
    }
}
