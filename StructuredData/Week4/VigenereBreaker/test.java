
/**
 * 在这里给出对类 test 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
import edu.duke.*;
public class test {
    public void testCaesarCipher(){
        CaesarCipher cc1= new CaesarCipher(4);
        FileResource fr= new FileResource();
        String input=fr.asString();
        String encrypt=cc1.encrypt(input);
        System.out.println(encrypt);
        //CaesarCipher cc1= new CaesarCipher(4);
        System.out.println(cc1.decrypt(encrypt));
    }
    public void testCaesarCracker(){
        CaesarCracker cc= new CaesarCracker('a');
        FileResource fr= new FileResource();
        String input=fr.asString();
        System.out.println(cc.decrypt(input));
        
    }
    public void testVigenereCipher(){
        int[] key={17,14,12,4};
        VigenereCipher vc=new VigenereCipher(key);
        FileResource fr= new FileResource();
        String input=fr.asString();
        String encrypt=vc.encrypt(input);
        System.out.println(encrypt);
        System.out.println(vc.decrypt(encrypt));
    }
}
//HashMap<String, Integer> list = new HashMap<String, Integer>();
        //for(String s:dictionary){
            //for(int i=0;i<s.length();i++){
                //String sub=s.substring(i,i+1);
                //if(!list.containsKey(sub))
                   // list.put(sub,1);
                //else{
                    //int val=list.get(sub);
                    ///list.put(sub,val+1);
                //}
              
         //   }            
      //  }
     //   String mostcommon="";
     //   int mosttimes=0;
       // for(String ch:list.keySet()){
      //      if(list.get(ch)>mosttimes){
          //      ch=mostcommon;
            //    mosttimes=list.get(ch);
          //  }
        //} 
       // return mostcommon;
    //}
