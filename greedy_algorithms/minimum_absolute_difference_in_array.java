import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        
        //Wrong, out of bounds exception
        //Flawed approach; just because the numbers are the smallest
        //Doesnt mean that they are closest together
        /*
         Arrays.sort(arr);
         
         if(arr[0]==0){
         return Math.abs(arr[0]-arr[1]);
         }
         
         int[] pos = new int[arr.length];
         int[] neg = new int[arr.length];
         
         int posIndex = 0;
         int negIndex = 0;
         
         for(int i = 0; i < arr.length; i++){
         
         if(arr[i]<0){
         neg[negIndex] = arr[i];
         negIndex++;
         }else{
         pos[posIndex] = arr[i];
         posIndex++;
         }
         
         }
         
         Arrays.sort(pos);
         Arrays.sort(neg);
         
         return Math.abs(pos[0]-neg[neg.length]);
         */
        
        /*
         We can sort this array and then find the minimum absolute value of the
         elements to the right of each element, because they will always be smaller 
         than something further away, thus reducing the number of comparisons we need to do
         */
        
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length-1; i++){
            
            int currentMin = Math.abs(arr[i]-arr[i+1]);
            min = Math.min(min, currentMin);
            
        }
        
        return min;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int result = minimumAbsoluteDifference(arr);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

