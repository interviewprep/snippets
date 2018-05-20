import java.util.*;

public class TreeLevelOrder { 

    public static class TreeNode {
        int v; 
        TreeNode l,r;

        TreeNode (int v) { this.v = v;}
    }

   
    public static TreeNode marker = new TreeNode(-999);

    public static void printByLevelQ (TreeNode root) {

        Queue <TreeNode>q = new ArrayDeque<>();
        
        TreeNode cur = root; 
        q.add(cur);
        q.add(marker);

        while (!q.isEmpty()) {
            cur = q.remove(); 

            //System.out.println ("cur.v + :" +cur.v);
            if (cur.v != -999) {
                System.out.print (" " + cur.v);
                if (cur.l != null) { 
                    q.add (cur.l); 
                }
                if (cur.r != null) {
                    q.add (cur.r); 
                }
            }else{
                System.out.println();                
                q.add(new TreeNode(-999));
                
                if (q.size() == 1) break;    
            }
            
           
        }
        System.out.println();
    }

    public static void main (String []args) {
        TreeNode root = null;                                                                                                
        root = buildTree (root);
        /**
         *                            40
         *                     23            55
         *                 12      28    38     70   
         */
        //parseTreeInOrder(root);   
        //parseTreePreOrder(root);
        System.out.println ("\n\n\n========PRINT BY LEVEL=============\n\n");
        printByLevelQ(root);
    }


    ////////////////////// Test //////////////////////
    public static TreeNode buildTree (TreeNode root){ 
        root = new TreeNode (40); 
        root.l = new TreeNode (23); root.l.l = new TreeNode(12); root.l.r = new TreeNode (28);
        root.r = new TreeNode (55); root.r.l = new TreeNode (38); root.r.r = new TreeNode (70);
    
        return root;
    }


    // RootLeftRight
    public static void parseTreePreOrder (TreeNode root) { 
        
        if (root == null) return;
        System.out.println (root.v);
        parseTreePreOrder(root.l);
        parseTreePreOrder(root.r);

    }


    //LeftRootRight
    public static void parseTreeInOrder (TreeNode root) { 
        if (root == null) return;
    
            parseTreeInOrder(root.l);
            System.out.print (" " + root.v +" ");
            parseTreeInOrder(root.r);
    }
    
    
}