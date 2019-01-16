import java.io.*;
import java.security.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        
        //Read and save the input String
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        getSHAHEX(s);
        
    }
    
    private static void getSHAHEX(String s) {
        
        try {
            
            //Encode the String using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            
            //Print the encoded value in hexadecimal
            for(byte b : digest){
                System.out.format("%02x", b);
            }
            
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
    }
    
}




