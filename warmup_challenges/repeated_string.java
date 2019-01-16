import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import static java.lang.Math.toIntExact;

public class Solution {
    
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        
        /*
         long num_occurences = 0;
         
         char[] string_2_arr = s.toCharArray();
         */
        
        //Wrong, didnt account for if the string doesnt finish
        //aka partial string is written at end
        //and it thinks n is the amount of times the string is repeated
        //that is false, n is the length of the string that goes on for
        /*
         for(int i=0; i<arr.length; i++){
         if(arr[i]=='a'){
         num_occurences++;
         }
         }
         
         num_occurences = num_occurences*n;
         */
        
        //create char array that will house new data
        //this array length should be size n
        //and should have nested for loop copying s for value = n/s.length
        //remainder should be the last things to copy from s
        //then count oocurences in the created char array
        
        //Also wrong way, restart below
        /*
         int n2 = toIntExact(n);
         
         char[] result_arr = new char[n2];
         
         int remainder = n2%string_2_arr.length; //need to keep remainder as long to avoid
         //lossy conversion
         
         for(int i=0; i<n2-remainder; i++){ //should be n - remainder of n/string_2_arr
         for(int j=0; j<string_2_arr.length; j++){
         result_arr[i]=string_2_arr[j];
         }
         }
         
         for(int k=n2-remainder; k<n2; k++){
         for(int k2=0; k2<string_2_arr.length; k2++){
         result_arr[k]=string_2_arr[k2];
         }
         }
         
         for(int i2=0; i2<n2; i2++){
         if(result_arr[i2]=='a'){
         num_occurences++;
         }
         }
         
         return num_occurences;
         */
        
        long countForSubstring = 0;
        
        long totalCount = 0;
        
        //determines num a's in one substring
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                countForSubstring++;
            }
        }
        
        long divisor = n/s.length();
        
        //total a's in almost complete string
        totalCount = countForSubstring*divisor;
        
        long remainder = n%s.length();
        
        //counts rest of a's in remainder of last partial substring
        for(int i2=0; i2<remainder; i2++){
            if(s.charAt(i2)=='a'){
                totalCount++;
            }
        }
        
        return totalCount;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = scanner.nextLine();
        
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        long result = repeatedString(s, n);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

