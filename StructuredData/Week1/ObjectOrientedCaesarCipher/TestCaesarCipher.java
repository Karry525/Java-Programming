
/**
 * 在这里给出对类 TestCaesarCipher 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
public class TestCaesarCipher {
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
    void  simpleTests(){
        FileResource fr=new FileResource();
        String encrypted =fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String en=cc.encrypt(encrypted);
        System.out.println("The encrypted message is "+en);
        String de=cc.decrypt(en);
        System.out.println("The decrypted message is "+de);
        System.out.println("The decrypted message is "+ breakCaesarCipher(en));
    }
    String breakCaesarCipher(String input){
        int[] freqs=countLetters(input);
        int maxDex =maxIndex(freqs);
        //System.out.println(maxDex);
        int dkey=maxDex-4;
        if(maxDex<4){
            dkey=26-(4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.encrypt(input);
    }
}
