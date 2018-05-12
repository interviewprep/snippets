import java.util.*;

public class DFSTree {
    public static Node root = null;

    public void DFSTree(Node root) { 

    }

    public static void DFSTraverse (Node root) {
        Stack <Node>s = new Stack<Node>();
        s.push(root);

        while (!s.empty()) {
            // pop from stack
            // add children in stack

            Node c = s.pop();

            if (c.left!=null) s.push (c.left);
            
            if (c.right!=null) s.push(c.right);
            
        }

    }
    public static void DFSTreeInorder (Node root) {

        if (root == null) {
           //System.out.println ("root is null");
           return; 
        }
        
        DFSTreeInorder(root.left); 
        System.out.print (root.data + " ");
        DFSTreeInorder(root.right); 

    }
    public static void main (String []args) {

        root = new Node();
        buildTree1(root);
        DFSTreeInorder(root);
    }

    public static void buildTree1 (Node root) { 

        root.data = 10;
        root.left = new Node(); root.left.data = 6;
        root.left.left = new Node(); root.left.left.data =2;
        root.left.right = new Node(); root.left.right.data =8;
        
        root.right = new Node(); root.right.data = 20; 
        root.right.left = new Node(); root.right.left.data=18;

    }
}

class Node {

    int data; 
    Node left, right; 
}

