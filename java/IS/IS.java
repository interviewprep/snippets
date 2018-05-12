import java.util.*;

public class IS { 


    public static void insertion_sort (int []arr) {

        int l = arr.length;
        for (int i=0; i<l; i++) {
            for (int j=i; j>0 && less(arr, j,j-1); j--) {
                System.out.println (Arrays.toString(arr));
                exchange (arr, j,j-1);
                System.out.println (Arrays.toString(arr));

            }
        }
        System.out.println (Arrays.toString(arr));
    }

    public static boolean less( int []arr, int i, int j) {
        return (arr[i] < arr[j]?true: false);
    }
    public static void exchange (int []arr, int i, int j) {

        int temp = arr[j];
        arr[j] = arr[i]; 
        arr[i] = temp;
    }


    public static void main (String []args) {

        IS.insertion_sort(new int[] {4,2,0,1,10});
    }

}