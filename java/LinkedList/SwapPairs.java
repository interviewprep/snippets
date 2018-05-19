public class SwapPairs {

    public static class Node {

        int value; 
        Node next; 

        public Node (int value){
            this.value = value; 
        }
    }

    public static void traverse (Node head) { 
        Node tmp = head; 
        while (tmp!=null) {
            System.out.print (" " + tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }


    public static void swap (Node head) {

    }
    public static void main (String []args) {

        Node n1 = new Node(1); 
        Node n2 = new Node(2); n1.next = n2; 
0        Node n3 = new Node(3); n2.next = n3; 
        Node n4 = new Node(4); n3.next = n4;

        traverse(n1);

    }
}