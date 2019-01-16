import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    
    
    public static int height(Node root) {
        
        //use recursion
        //check height of left and height of right and compare
        
        int leftHeight = -1; //was 0 but answer always gave me 1 more
        int rightHeight = -1;
        
        if (root != null){
            
            if (root.left != null){
                leftHeight = height(root.left);
            }
            if (root.right != null){
                rightHeight = height(root.right);
            }
            
        }
        
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
        //move to next step in recursion through the "+1"
        
    }
    
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
