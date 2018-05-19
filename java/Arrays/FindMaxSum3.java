import java.util.*;
public class FindMaxSum3 {

    public static int findSum3 (int []arr, int k) { 

        int max = 0;;

        int i=0;
        
        while (i<=arr.length-k) {
            
            if (i==0) {
                for (int j=0; j<k; j++) {
                    max += arr[j];
                    System.out.println ("max: " + max);
                }
            }else {
                System.out.println ("i " + i);
                int tmp = (max - arr[i-1]) + arr[i+k-1];
                System.out.println (" " + tmp + " " + max);
                if (tmp > max) 
                    max = tmp;
            }
            i++;
        }
        return max;
    }
    public static void main (String []args) {

        System.out.println(findSum3(new int[]{2,1,2,4,3},3));
    }
}