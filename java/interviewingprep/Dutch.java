import java.util.*;

public class Dutch {

    public static int[] SwapDutch (int[]arr) { 
        int []count = new int[3];
        System.out.println (Arrays.toString(arr));

        int v =0;
        for (int i=0; i<arr.length; i++) {
            v=arr[i];
            count[v]+=1;
        }
        
        System.out.println (Arrays.toString(count));
        for (int i=0; i<count[0] ;i++) {
            arr[i] = 0;
        }
        System.out.println (Arrays.toString(arr));

        for (int i=count[0]; i<(count[1]+count[0]) ;i++) {
            arr[i] = 1;
        }
        System.out.println (Arrays.toString(arr));

        for (int i=(count[1]+count[0]); i<arr.length; i++) {
            arr[i] = 2; 
        }

        return arr;
    }

    public static void swap (int arr[], int i, int j) {
        int tmp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main (String []args) {

        System.out.println (Arrays.toString(SwapDutch(new int[]{1,2,1,0,2,0,1,0,2})));
    }
}