import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;
        
        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }
    
    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;
        
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }
        
        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
            
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            
            this.tail = node;
        }
    }
    
    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));
            
            node = node.next;
            
            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    
    // Complete the sortedInsert function below.
    
    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        
        if(head == null){ //insert in empty list
            
            newNode = head;
            return head;
            
        } else if(data < head.data){ //insert at beginning of list
            
            newNode.next = head;
            head.prev = newNode;
            return newNode;
            
        } else{ //walk through list with 2 pointers
            //you have a "previous" pointer and a "current" pointer
            
            DoublyLinkedListNode previous = null;
            DoublyLinkedListNode current = head;
            
            while (current != null && current.data < data){
                //walking through,
                //havent found where to stop and put newNode in yet
                previous = current;
                current = current.next; //iterate
            }
            
            //ok you broke out of that while loop; now 1 of 2 things happened:
            //either you 1. reached the end of the list so it gets placed last
            //OR 2. now current.data > data so you found where to put it
            
            //option 1:
            if(current == null){ //insert at end of list
                
                previous.next = newNode;
                newNode.prev = previous;
                
                //option 2: (must be by default) (in middle of list somewhere)
            } else{
                
                previous.next = newNode;
                current.prev = newNode;
                newNode.prev = previous;
                newNode.next = current;
                
            }
            
        }
        
        return head;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();
            
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
                llist.insertNode(llistItem);
            }
            
            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);
            
            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        
        scanner.close();
    }
}

