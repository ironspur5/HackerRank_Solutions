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
    
    public static Node lca(Node root, int v1, int v2) {
        while(root!=null){
            if(root.data < v1 && root.data < v2){
                //if the root is bigger than both then look right
                //since "both" it is a "common" ancestor
                //this assumes unique values in tree; and set up as
                //traditional binary search tree
                root = root.right;
            }else if(root.data > v1 && root.data > v2){
                //if root is bigger than both then look left
                root = root.left;
            }else{
                break;//breaks out of the while loop
            }
        }
        return root;//a new root wasnt set from an if condition so you found
        //your answer
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
