import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the whatFlavors function below.
    //m = money
    static void whatFlavors(int[] costs, int m) {
        
        int[] indexes = new int[]{-1, -1}; //just initialize it for later
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < costs.length; i++) {
            
            int cost = costs[i];
            int diff = m - cost;
            
            if (diff < 0) continue; //skips code under and goes back to start
            
            if (!map.containsKey(diff)) {
                map.put(cost, i + 1);
            } else {
                indexes = new int[]{map.get(diff), i + 1};
                //i+1 to keep 1-indexed
                break;
            }
            
        }
        
        System.out.println(indexes[0] + " " + indexes[1]);
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int[] cost = new int[n];
            
            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }
            
            whatFlavors(cost, money);
        }
        
        scanner.close();
    }
}

