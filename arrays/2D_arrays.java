import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        
        //Close, but got array out of bounds exception
        //dont try and make the center of the hourglass the reference
        //make the first element the refernce like down below
        /*
         int HGS = 0;
         
         for(int i=0; i<5; i++){
         for(int j=0; j<5; j++){
         if(i!=5||j!=5){
         int val = arr[i][j]+arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]                             +arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
         if(val>HGS){
         HGS=val;
         }
         }
         }
         }
         
         return HGS;
         */
        
        int sum=-1000;
        for(int i =0 ; i<4;i++){
            //4 b/c i+2 at 4 would be 6 greater than 5(max) (012345)
            for(int x =0 ; x<4; x++){
                int top = arr[i][x]+arr[i][x+1]+arr[i][x+2];
                int middle = arr[i+1][x+1];
                int bottom = arr[i+2][x]+arr[i+2][x+1]+arr[i+2][x+2];
                if(top+middle+bottom>sum){sum=top+middle+bottom;}
            }
        }
        
        return sum;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int[][] arr = new int[6][6];
        
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = hourglassSum(arr);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
