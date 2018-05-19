import java.util.*;

public class Try {

    public static void main (String []args) {

        HashMap <Integer,Integer> m = new HashMap<>();
        Integer []arr = {2,2,3,1};

        for (int i:arr) {
            m.put(i, m.getOrDefault(i, 0)+1);
        }

        System.out.println (m.toString());
    }
}