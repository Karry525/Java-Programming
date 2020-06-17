
/**
 * 在这里给出对类 CaesarBreaker 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;

public class CaesarBreaker {
    public int[] countLetters(String message) {
        int [] counters = new int [26];
        for (int i = 0; i < 26; i++) {
            counters[i] = 0;
        }
        String alph = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            int position = alph.indexOf(message.charAt(i));
            if (position != -1) 
                counters[position] += 1;
        }
        
        return counters;
    }
    public int maxIndex(int[] vals){
        int maxDex=0;
        for(int k=0;k<vals.length;k++){
            if(vals[k]>vals[maxDex])
                maxDex=k;
        }
        return maxDex;
    }    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs=countLetters(encrypted);
        int maxDex =maxIndex(freqs);
        //System.out.println(maxDex);
        int dkey=maxDex-4;
        if(maxDex<4){
            dkey=26-(4-maxDex);
        }
        String message = cc.encrypt(encrypted, 26 - dkey);
        return message;
    }
    void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt("Heelo!", 17);
        System.out.println(message);
        message = decrypt(message);
        System.out.println(message);
    }
    String halfOfString(String message, int start){
        String newMessage="";
        for(int k=start;k<message.length();k+=2){
            //sb.insert(message.length()-1,message.charAt[k]);
            newMessage=newMessage+message.charAt(k);
        }
        return newMessage;
    }
    void testhalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    int getKey(String s){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs=countLetters(s);
        int maxDex =maxIndex(freqs);
        //System.out.println(maxDex);
        
        int dkey=maxDex-4;
        if(dkey<0){
            dkey=26-(4-maxDex);
        }
        return dkey;
    }
    String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String part1=halfOfString(encrypted,0);
        String part2=halfOfString(encrypted,1);
        int key1=getKey(part1);
        int key2=getKey(part2);
        System.out.println("The keys are "+key1+" and "+key2);
        String a=cc.encrypt(part1,26-key1);
        String b=cc.encrypt(part2,26-key2);
        System.out.println("a="+a.length());
        System.out.println("b="+b.length());
        int index1=0;
        int index2=0;
        String sb="";
        for(int k=0;k<encrypted.length();k++){
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
    void testdecryptTwoKeys(){
        CaesarCipher cc = new CaesarCipher();
        FileResource fr = new FileResource();
        String encrypted =fr.asString();
        //String encrypted="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        System.out.println(decryptTwoKeys(encrypted));
    }
}
