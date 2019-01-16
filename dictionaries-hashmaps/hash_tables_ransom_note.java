import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        
        //DONT SOLVE THIS WAY, USE HASHMAP INSTEAD
        /*
         int note_count = 0;
         
         for(int i=0; i<note.length; i++){
         
         int j = 0;
         
         while(j<magazine.length){
         
         if(note[i]==magazine[j]){
         magazine[j]=null;
         note_count++;
         }
         
         j++;
         
         }
         
         }
         
         String answer = (note_count==note.length) ? "Yes":"No";
         
         System.out.println(answer);
         */
        
        //Really close but not passing all test cases
        /*
         Map<String, Integer> magazineMap = new HashMap<String, Integer>();
         Map<String, Integer> noteMap = new HashMap<String, Integer>();
         
         //populate magazine map
         for(String word : magazine){
         if(!magazineMap.containsKey(word)){
         magazineMap.put(word, 0);
         }
         magazineMap.put(word, magazineMap.get(word)+1);
         }
         
         //populate note map
         for(String word : note){
         if(!noteMap.containsKey(word)){
         noteMap.put(word, 0);
         }
         noteMap.put(word, noteMap.get(word)+1);
         }
         
         for(String key : noteMap.keySet()){
         
         //If magazine doesn't have a word that's
         //on a note, then return false right the way
         if(!magazineMap.containsKey(key)){
         System.out.println("No");
         }
         
         //Now make sure there are enough
         //words on magazine for a given word
         int magazineCount = magazineMap.get(key);
         int noteCount = noteMap.get(key);
         
         if(magazineCount<noteCount){
         System.out.println("No");
         }
         
         }
         
         System.out.println("Yes");
         */
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");
        
        int m = Integer.parseInt(mn[0]);
        
        int n = Integer.parseInt(mn[1]);
        
        String[] magazine = new String[m];
        
        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }
        
        String[] note = new String[n];
        
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        
        checkMagazine(magazine, note);
        
        scanner.close();
    }
}


