import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the makeAnagram function below.
    static int makeAnagram(String s1, String s2) {
        
        //Wrong way
        //Think it is wrong because hash sets dont allow for duplicate values
        /*
         Set<Character> hashSetA = new HashSet<>();
         Set<Character> hashSetB = new HashSet<>();
         
         int count = 0;
         
         for(int i=0; i<a.length(); i++){
         hashSetA.add(a.charAt(i));
         }
         
         for(int j=0; j < b.length(); j++) {
         hashSetB.add(b.charAt(j));
         }
         
         Set<Character> intersection = new HashSet<>(hashSetA);
         //use the copy constructor
         intersection.retainAll(hashSetB);
         
         for(int i2=0; i2<a.length(); i2++){
         if(!intersection.contains(a.charAt(i2))){
         count++;
         }
         }
         
         for(int j2=0; j2<b.length(); j2++){
         if(!intersection.contains(b.charAt(j2))){
         count++;
         }
         }
         
         return count;
         */
        
        //Build a frequency map for each string
        //Compare the frequency maps, each time
        //adding the difference to a deletions variable
        //return deletions
        
        Map<Character, Integer> s1Frequency = new HashMap<>();
        Map<Character, Integer> s2Frequency = new HashMap<>();
        int deletions = 0;
        
        // https://www.tutorialspoint.com/java/util/hashmap_put.htm
        for (int i = 'a'; i <= 'z'; i++) {
            s1Frequency.put((char) i, 0);
            s2Frequency.put((char) i, 0);
        }
        
        // https://www.tutorialspoint.com/java/util/hashmap_get.htm
        for (char c : s1.toCharArray())
            s1Frequency.put(c, s1Frequency.get(c) + 1);
        
        for (char c : s2.toCharArray())
            s2Frequency.put(c, s2Frequency.get(c) + 1);
        
        // https://www.tutorialspoint.com/java/util/hashmap_keyset.htm
        for (char letter : s1Frequency.keySet()) {
            int f1 = s1Frequency.get(letter);
            int f2 = s2Frequency.get(letter);
            
            deletions += Math.abs(f1 - f2);
        }
        
        return deletions;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String a = scanner.nextLine();
        
        String b = scanner.nextLine();
        
        int res = makeAnagram(a, b);
        
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

