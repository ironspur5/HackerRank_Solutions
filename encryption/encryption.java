import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the encryption function below.
    static String encryption(String s) {
        
        int string_length = s.length();
        double sqrt_len = Math.sqrt(string_length);
        int columns = (int)Math.ceil(sqrt_len);
        int rows = (int)Math.floor(sqrt_len);
        
        //longer of the 2 will be the outside iterator of the grid
        int len = (rows > columns) ? rows : columns;
        
        String result = "";
        
        for(int i = 0; i < len; i++){
            
            for(int j = i; j < string_length; j = j + columns){
                
                char ch = s.charAt(j);
                result += ch; //add on until you hit bottom
                
            }
            
            //add a space to start process again
            result += " ";
            
        }
        
        return result;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = scanner.nextLine();
        
        String result = encryption(s);
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

