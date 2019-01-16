import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        
        int min_num_jumps = 0;
        
        //wrong solution; only passed some test cases
        /*
         int num_ones = 0;
         int num_zero_pairs = 0;
         
         Arrays.sort(c);
         
         //first count num of 1s; they are definite jumps
         //then count all pairs of 0s
         
         for(int i=0; i<c.length; i++){
         if(c[i]==1){
         num_ones++;
         }
         }
         
         for(int j=0; j<c.length-1; j++){
         if(c[j]==c[j+1] && c[j]!=1){
         num_zero_pairs++;
         j+=1;
         }
         }
         
         min_num_jumps = num_ones + num_zero_pairs;
         */
        
        /*
         if (a > b) {
         result = x;
         } else {
         result = y;
         }
         =
         result = a > b ? x : y;
         */
        
        int i = 0;
        
        while(i<c.length-3){ //goes through all clouds up until the last jump
            
            i+= (c[i+2]==0) ? 2:1;
            
            min_num_jumps++;
            
        }
        
        min_num_jumps++; //This is the last jump that will be either a 1 or 2
        
        return min_num_jumps;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] c = new int[n];
        
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        
        int result = jumpingOnClouds(c);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

