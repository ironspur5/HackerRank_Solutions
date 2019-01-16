import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        
        int num_valleys = 0;
        
        char[] step_array = s.toCharArray();
        
        int altitude = 0;
        //if step_array[i] = U then altitude++;
        //if step_array[i] = D then altitude--;
        
        //find an unbroken string of D's that is greater than 1
        //false, if you see a D are there an equivalent amount of U's to get back to 0
        
        for(int i=0; i<n; i++){
            
            if(step_array[i]=='U'){
                altitude++;
            }
            
            else{
                altitude--;
                if(altitude==-1){ //putting the check here for -1 avoids counting a                                        //valley twice (aka at the entrance and exit)
                    num_valleys++;
                }
            }
            
        }
        
        return num_valleys;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String s = scanner.nextLine();
        
        int result = countingValleys(n, s);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

