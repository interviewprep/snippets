import java.util.*;

public class is { 


    public static int[] inssort (int []arr) { 

        
        for (int i=0; i<arr.length;i++) {

            for (int j=i; j>0 && less(arr[j], arr[j-1]); j--) {
                exch(arr, j, j-1);
            }
        }
        return arr; 
    }

    private static boolean  less (int x, int y) {

        return x<y?true: false; 
    }

    private static  void exch (int []arr, int x, int y) {
        int tmp = arr[y];
        arr[y] = arr[x];
        arr[x] = tmp;
    }
    public static void main (String []args) { 

        System.out.println (Arrays.toString (inssort(new int[] {4,3,5,1,0})));
    }
}