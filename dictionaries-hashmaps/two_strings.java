import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        
        
        //use a HashSet not a HashMap (Map != Set)!!!!
        //https://stackoverflow.com/questions/2773824/difference-between-hashset-and-hashmap
        
        Set<Character> s1Set = new HashSet<>();
        Set<Character> s2Set = new HashSet<>();
        
        for(int i=0; i<s1.length();i++){
            s1Set.add(s1.charAt(i));
        }
        
        for(int j=0; j<s2.length();j++){
            s2Set.add(s2.charAt(j));
            if(s1Set.contains(s2.charAt(j))){
                return "YES";
            }
        }
        
        return "NO";
        
        /*
         //Alternate way:
         
         for(int i=0; i<s1.length();i++){
         s1Set.add(s1.charAt(i));
         }
         
         for(int i=0; i<s2.length();j++){
         s2Set.add(s2.charAt(j));
         }
         
         //Perform the intersection of the two sets
         s1Set.retainAll(s2Set);
         
         if(s1Set.size() > 0){
         return "YES";
         }
         
         return "NO";
         */
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();
            
            String s2 = scanner.nextLine();
            
            String result = twoStrings(s1, s2);
            
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

