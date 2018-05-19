import java.io.*; 

public class IsTreeBalanced {

    public static class TreeNode {
        int v; 
        TreeNode l,r;

        TreeNode (int v) { this.v = v;}
    }

    public static boolean isBalanced (TreeNode root) { 
    
        int heightL = getHeight (root.l);
        int heightR = getHeight (root.r);

        System.out.println (heightL + "," + heightR);
        if (Math.abs(heightR-heightL) <=1)
            return true;
        return false;
    }

    public static int getHeight (TreeNode root) {

        if (root == null) 
            return 0; 

        int hL = 1+getHeight (root.l); 
        int hR = 1+getHeight (root.r); 

        return Math.max(hL,hR);
    }

    public static void main (String []args) {

        TreeNode root = null;
        root = buildTree (root);
        /**
         *                            40
         *                     23            55
         *                 21      28           
         *              14                  
         * 
         */      
        parseTree(root);   
        System.out.println ("\n\n\n=====================\n\n");
        System.out.println ("Height: " + getHeight(root));
        System.out.println ("Balanced: " + isBalanced(root));

    }

    ////////////////////// Test //////////////////////
    public static TreeNode buildTree (TreeNode root){ 
        root = new TreeNode (40); 
        root.l = new TreeNode (23); root.l.l = new TreeNode(21);  
        root.r = new TreeNode (55); 
    
        return root;
    }
    
    public static void parseTree (TreeNode root) { 
        if (root == null) return;
    
            parseTree(root.l);
            System.out.print (" " + root.v +" ");
            parseTree(root.r);
    }
}