import java.util.*;

public class MoveZeroeToLeftOnesToRight {

    public static int[] MoveArr (int []arr) {

        int i; 
        int j;

        i=0; j=arr.length-1;

        while (i<j) {

            if (arr[i]==0) {
                i++;        
                continue;
            } 
            if (arr[j]==1) {
                j--;
                continue;
            }
            swap(i,j,arr);

        }
        return arr;
    }

    public static void swap (int x, int y, int[]arr) {

        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;

    }
    public static void main (String []args) {

        int []arr = {1,1,1,1,0};

        System.out.println (Arrays.toString(MoveArr(arr))); 
    }
    
}