
/**
 * 在这里给出对类 CaesarCipher 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.*;
public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        //Write down the alphabet
        StringBuilder e = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                 //System.out.println(e.charAt(i));
                if(Character.isLowerCase(e.charAt(i)))
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                else
                    encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 15;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message="Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
    }
    String encryptTwoKeys(String input, int key1,int key2){
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());        
        StringBuilder e = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";        
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {            
            char currChar = encrypted.charAt(i);            
            int idx = alphabet.indexOf(currChar);            
            if(idx != -1){
                if(i%2==0){               
                char newChar1 = shiftedAlphabet1.charAt(idx);                
                if(Character.isLowerCase(e.charAt(i)))
                    encrypted.setCharAt(i, Character.toLowerCase(newChar1));
                else
                    encrypted.setCharAt(i, newChar1);
                }
                else{
                    char newChar2 = shiftedAlphabet2.charAt(idx);                
                if(Character.isLowerCase(e.charAt(i)))
                    encrypted.setCharAt(i, Character.toLowerCase(newChar2));
                else
                    encrypted.setCharAt(i, newChar2);
                }
            }            
        }        
        return encrypted.toString();
    }
    void testencryptTwoKeys(){
        int key1 = 21;
        int key2=8;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message="Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encryptTwoKeys(message, key1,key2);
        System.out.println( encrypted);
    }
   }

