import java.util.*;

public class SubArr { 

    public static int subarraySum (int []nums, int k) {

        // brute force
        int count = 0; 
        /**
        for (int i=0; i< nums.length-1; i++) {

            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    System.out.println ("i : " + i + " j:" + j);
                    count++;
                }
            }
        }
        */

        HashMap<Integer,Integer> m= new HashMap<Integer, Integer>();

        int sum = 0;
        m.put(0,1);
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];   
            if (m.containsKey(sum-k)) {
                count += m.get(sum-k);   
            }
            m.put (sum,m.getOrDefault(sum,0) + 1);            
        }
        System.out.println (m);
        return count;
    }
    public static void main (String []args) {

        //System.out.println ("Count: " + subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
        System.out.println ("Count: " + subarraySum(new int[]{1,1,1}, 2));
    }
}