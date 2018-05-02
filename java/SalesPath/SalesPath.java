import java.io.*;
import java.util.*;

class SalesPath {
 
  static class Node {
      
    Node left, right;
    int cost;

    Node(int cost) {
      this.cost = cost;
      left = right = null;
    }
  }

       
  public static int getCheapestCost(Node rootNode) {
    // your code goes here

    if (rootNode == null) {
        return 0;
    }
    int cost = rootNode.cost;

    // there are nodes
    int value = Math.min(getCheapestCost (rootNode.left),getCheapestCost(rootNode.right)); 

    return cost+value ;
    
 }
  
    
  /*********************************************
   * Driver program to test above method     *
   *********************************************/
  public static void main(String[] args) {
    Node root = new Node(0);
    buildTree(root); 
    inOrderTraverse(root);
    System.out.println ("Cheapest cost: " + getCheapestCost(root));
  }

  public static void buildTree (Node root) {
     root.left = new Node(5); root.right = new Node (15);
     root.left.left = new Node (3); root.left.right = new Node (7);
     root.right.left = new Node (-7); root.right.right = new Node (21);
  }

  public static void inOrderTraverse (Node root) {

    if (root == null) return; 
    inOrderTraverse(root.left);      
    System.out.print (" " + root.cost);
    inOrderTraverse(root.right);
   
  }
}


