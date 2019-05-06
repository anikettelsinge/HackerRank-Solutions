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
    static boolean v1Flag = false;
    static boolean v2Flag = false;
    static void check(Node root, int v1, int v2) {
        if(root == null) return;
        check(root.left, v1, v2);
        
        if(root.data == v1) v1Flag = true;
        if(root.data == v2) v2Flag = true;
        if(v1Flag && v2Flag) return;
        check(root.right, v1, v2);
    }
	public static Node lca(Node root, int v1, int v2) {
        if(root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node temp;
        Node result = root;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            // System.out.print(temp.data+ " ");
            v1Flag = false;
            v2Flag = false;
            check(temp, v1, v2);
            if(v1Flag && v2Flag) result = temp;
            // queue.remove();
        }

        return result;
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
