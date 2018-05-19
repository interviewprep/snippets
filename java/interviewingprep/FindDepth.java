import java.util.*;

public class FindDepth {

    public static class TreeNode { 
        int value;

        TreeNode left, right;

        public TreeNode (int value) {
            this.value = value; 
        }
    }
    public static int findDepth (TreeNode root) { 

        if (root == null || isLeaf(root)) return 0;

        int leftH = findDepth(root.left) + 1;
        int rightH = findDepth(root.right) + 1;

        return Math.min (leftH,rightH);
    }
    public static void inOrder (TreeNode root) { 

        TreeNode node = root;

        if (node == null) 
            return;
        inOrder (node.left); 
        System.out.println (node.value);
        inOrder (node.right); 
    }

    public static boolean isLeaf (TreeNode node) { 
        return node.left == null && node.right == null ? true:false;
    }
    
    public static void main (String []args) {

        TreeNode root = new TreeNode(25); 
        root.left = new TreeNode(14); 
        root.right = new TreeNode (34); 

        root.left.left = new TreeNode (8);
        root.left.right = new TreeNode (19);

        root.right.left = new TreeNode (31);
        root.right.right = new TreeNode (41);

        inOrder(root);
        System.out.println ("Height: " + findDepth(root));
    }
}