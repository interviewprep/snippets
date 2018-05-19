import java.util.*;

public class MaxProf { 


    public static int  findMaxProfit (int []arr) {

        /**
         * Brute force
        for (int i=0; i<arr.length-1;i++) {
            for (int j=i+1; j<arr.length; j++){
                int diff = arr[j] - arr[i]; 
                if ( diff > 0) {
                    if (max < diff) max = diff; 
                }
            }
        }
        */
        int min = arr[0];
        int max = 0; 
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < min) 
                min = arr[i];
            max = findMaxProfitHelper(min, arr[i], max);
        }

        /**
        int max = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - min > max) 
                max = arr[i]-min;
        }
        */

        return max;
    }

    public static int findMaxProfitHelper (int min, int priceOfDay, int prevMax) {

        int max = prevMax;

        if (priceOfDay - min > prevMax)
            max = priceOfDay - min;
        return max;
    }

    public static void main (String []args) {

        System.out.println ("Max profit: " + findMaxProfit (new int[] {1,5,10,12})); // expect 9
    }
}