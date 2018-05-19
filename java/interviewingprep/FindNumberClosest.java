import java.util.*;

public class FindNumberClosest {

    public static class TreeNode {
        int v; 
        TreeNode l,r;

        TreeNode (int v) { this.v = v;}
    }

    public static boolean findNumber (TreeNode root, int t) { 

        TreeNode tmp = root; 

        /** iterative   
        if (tmp == null) return false;

        while (tmp != null) { 

            if (t < tmp.v) {
                tmp = tmp.l; 
            }else if (t > tmp.v) {
                tmp = tmp.r; 
            }
            else if (t == tmp.v) {
                return true;
            }
        }

        */

        // recursive
        
        boolean found = false;
        if (tmp == null) 
            return false; 

        if (tmp.v == t) {
            found = true; 
        }
        else if (tmp.v < t) {
            found = findNumber (root.r, t);
        }
        else if (tmp.v > t) {
            found = findNumber (root.l, t);
        }
        
        return found;
    }

    public static int findClosestNumber (TreeNode root, int t) {
        TreeNode tmp = root; 
`
        return -1; 
    }

    public static void main (String args[]){ 

        TreeNode root = null;
        root = buildTree (root);
        /**
         *                            40
         *                     23            55
         *                 21      28    38     78   
         */
        parseTree(root);


        //// Test 1 
        System.out.println ();
        System.out.println ();
        System.out.println ("findNumber(23): " + findNumber(root, 20)); // expects true
        System.out.println ("findNumber(-23): " + findNumber(root, -23)); // expects true
        System.out.println ("findNumber(78): " + findNumber(root, 78)); // expects true

        System.out.println ();
        System.out.println ();
        System.out.println ("findClosestNumber(23): " + findClosestNumber(root, 24)); // expects 23
        System.out.println ("findClosestNumber(51): " + findClosestNumber(root, 55)); // expects 55
        System.out.println ("findClosestNumber(41): " + findClosestNumber(root, 40)); // expects 40
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
