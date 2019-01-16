import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        
        //Really wrong and too complicated
        /*
         Arrays.sort(arr);
         int min = Integer.MAX_VALUE;
         
         for(int i = 0; i < arr.length-1; i++){
         int currentMin = Math.abs(arr[i]-arr[i+1]);
         min = Math.min(min, currentMin);
         }
         
         int[] group = new int[k];
         int groupCounter = 0;
         
         for(int i = 0; i < arr.length-1; i++){
         if(Math.abs(arr[i]+arr[i+1])==min){
         group[groupCounter]=arr[i];
         groupCounter++;
         group[groupCounter]=arr[i+1];
         }
         }
         
         for(int i = groupCounter; i < k-2; i++){
         group[i]=arr[i];
         }
         
         int max = group[k-1];
         int min2 = group[0];
         
         return max-min2;
         */
        
        /*
         Initial Thoughts: Since we only care about finding the smallest diff
         between the min and the max, we can just compare the start and end point      of all reasonable pairs. To limit the number of comparisons we make, we       can first sort our list that way, we know that all interior elements of       the list are also valid. Then we can do a linear check to see what the        min diff subarray is.
         */
        
        Arrays.sort(arr);
        int unfairness = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length-k+1; i++) {
            unfairness = Math.min(arr[i+k-1] - arr[i], unfairness);
            //Keeps a running min of the beginning and end of subarrays
        }
        
        return unfairness;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }
        
        int result = maxMin(k, arr);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

