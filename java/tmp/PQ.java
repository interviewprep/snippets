import java.util.*; 

public class PQ {

    public void printQ () { 

        PriorityQueue pq = new PriorityQueue<>();
        
        pq.offer(7); 
        pq.offer(2);
        pq.offer(5);
        pq.offer(0);

        System.out.println (pq);
    }

    public static void main (String []args){
        new PQ().printQ();
    }
}