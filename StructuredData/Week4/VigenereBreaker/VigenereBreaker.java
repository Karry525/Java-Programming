import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder total=new StringBuilder();
        for(int k=whichSlice; k<message.length(); k+=totalSlices){
            total.append(message.substring(k,k+1));
        }
        String totalslice=total.toString();
        
        return totalslice;
    }
    public void testsliceString(){
        System.out.println(sliceString("abcdefghijklm", 0, 5) );
    }
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        String slice="";
        CaesarCracker cc=new CaesarCracker(mostCommon);
        for(int k=0;k<klength;k++){
            slice=sliceString(encrypted,k,klength);
            key[k]=cc.getKey(slice);
        }
        return key;
    }
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dic=new HashSet<String>();
        for(String line:fr.lines()){
            line=line.toLowerCase();
            dic.add(line);
        }
        return dic;
    }
    public int countWords(String message, HashSet<String> dictionary){
        String[] words=message.split("\\W+");
        //System.out.println("The number of all words "+words.length);
        int num=0;
        for(int k=0;k<words.length;k++){
            String word=words[k].toLowerCase();
            if(dictionary.contains(word))
                num++;
        }
        return num;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int mostwords=0;
        int klength=0;
        String real="";
        StringBuilder sb=new StringBuilder (mostCommonCharIn(dictionary));
        char ch=sb.charAt(0);
        for(int k=1;k<=100;k++){
            
            int[] key=tryKeyLength(encrypted,k,ch);
            
            VigenereCipher vc=new VigenereCipher(key);
            String decrypted=vc.decrypt(encrypted);
            
            int words=countWords(decrypted,dictionary);
            if(words>mostwords){
                mostwords=words;
                klength=k;
                real=decrypted;
            }              
        }
        System.out.println("The length of key: "+klength);
        System.out.println("words= "+mostwords);
        return real;
    }    
    public String breakForLanguage2(String encrypted, HashSet<String> dictionary){
        int mostwords=0;
        int klength=0;
        String real="";
        StringBuilder sb=new StringBuilder (mostCommonCharIn(dictionary));
        char ch=sb.charAt(0);
        //for(int k=1;k<=100;k++){
            int k=encrypted.length();
            int[] key=tryKeyLength(encrypted,k,ch);
            
            VigenereCipher vc=new VigenereCipher(key);
            String decrypted=vc.decrypt(encrypted);
            
            int words=countWords(decrypted,dictionary);
            //if(words>mostwords){
                mostwords=words;
                klength=k;
                real=decrypted;
            //}              
        //}
        //System.out.println("The length of key: "+klength);
        System.out.println("words= "+mostwords);
        return real;
    }    
    public void testtryKeyLength(){
        FileResource fr= new FileResource();        
        int[] key=tryKeyLength(fr.asString(),4,'e');
        for(int k=0;k<4;k++)
            System.out.println(key[k]);
    }
    public String mostCommonCharIn(HashSet<String> dictionary){
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        String all = "abcdefghijklmnopqrstuvwxyz";
        for (int k = 0; k < 26; k++) {
            count.put(all.substring(k,k+1),0);
        }
        
       
        for (String word: dictionary) {
            word = word.toLowerCase();
            String[] letters = word.split("");
            for (String letter: count.keySet()) {
                for (String le: letters) {
                    if (le.equals(letter)) count.put(letter, count.get(letter)+1);
                }
            }
        }

        int max = 0;
        String result=null;
        
        for (String letter: count.keySet()) {
            if (max < count.get(letter)) {
                max = count.get(letter);
                result = letter;
            }
        }
        
        return result;
    }
        
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages){
        int mostwords=0;
        String real="";
        String lang="";
        for(String language: languages.keySet()){
            
            String decrypted=breakForLanguage2(encrypted,languages.get(language));
            int words=countWords(decrypted,languages.get(language));
            if(words>mostwords){
                mostwords=words;
                real=decrypted;
                lang=language;
            }
            
                
        }
        System.out.println("The decrypted message: "+real);
        System.out.println("Language: "+lang);
    }
    public void breakVigenere () {       
        //WRITE YOUR CODE HERE
        HashMap<String,HashSet<String>> hm=new HashMap<String,HashSet<String>>();
        FileResource fr=new FileResource("messages/secretmessage3.txt");
        String input=fr.asString();
        //int[] key=tryKeyLength(input,4,'e');
        //VigenereCipher vc=new VigenereCipher(key);
        //for(int k=0;k<4;k++)
            //System.out.println(key[k]);
        //String decrypted=vc.decrypt(input);
        //System.out.println(decrypted);
        DirectoryResource dr=new DirectoryResource();
        //FileResource English= new FileResource("dictionaries/English");
        //HashSet<String> dictionary= readDictionary(English);
        for(File f:dr.selectedFiles()){
            FileResource fr2 = new FileResource(f.toString());
            HashSet<String> result = new HashSet<String>();
            for (String line: fr2.lines()) {
                line = line.toLowerCase();
                result.add(line);
            }
            hm.put(f.getName(), result);
            System.out.println("Finished reading "+f.getName());
            
        }
        
        breakForAllLangs(input,hm);
    }
    
}
