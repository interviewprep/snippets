public class ReverseLL {
    static ListNode head = new ListNode(4);

    public static void main (String args[]) {
        ListNode tmp = new ListNode(10); head.next = tmp; 
        tmp = new ListNode(14); head.next.next = tmp;

        traverseLL();
        reverseLLIter();
        traverseLL();

    }

    public static void traverseLL () {

        ListNode cur = head;

        while (cur!=null) {
            System.out.print (cur.val + "->" + " ");
            cur = cur.next;
        } 
        System.out.println();
    }

    public static void reverseLLIter () { 

        ListNode cur = head;
        ListNode prev = null; 
        ListNode next = null; 
        while (cur!=null) {
             System.out.println ("cur:" + cur.val);
             next = cur.next; 
             cur.next = prev; 
             prev=cur;
             cur=next; 
        }
        
        head = prev; 
        System.out.println ("Head: " + head.val);
    }

} 

class ListNode { 
    int val; 
    ListNode next;

    ListNode() {}
    ListNode (int val) {this.val = val;}
}