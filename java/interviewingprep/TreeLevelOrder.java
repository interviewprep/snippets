import java.util.*;

public class TreeLevelOrder { 

    public static class TreeNode {
        int v; 
        TreeNode l,r;

        TreeNode (int v) { this.v = v;}
    }

    public static void printByLevelIterative (TreeNode root) { 

       
    }

    public static void printByLevelRecursive (TreeNode root) {
        
    }

    public static void main (String []args) {
        TreeNode root = null;
        root = buildTree (root);
        /**
         *                            40
         *                     23            55
         *                 21      28    38     78   
         */
        parseTree(root);   
        System.out.println ("\n\n\n=====================\n\n");
        printByLevel(root);
    }


    ////////////////////// Test //////////////////////
    public static TreeNode buildTree (TreeNode root){ 
        root = new TreeNode (40); 
        root.l = new TreeNode (23); root.l.l = new TreeNode(12); root.l.r = new TreeNode (28);
        root.r = new TreeNode (55); root.r.l = new TreeNode (38); root.r.r = new TreeNode (70);
    
        return root;
    }
    
    public static void parseTree (TreeNode root) { 
        if (root == null) return;
    
            parseTree(root.l);
            System.out.print (" " + root.v +" ");
            parseTree(root.r);
    }
    
    
}