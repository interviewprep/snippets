import java.util.*;

/**
 *  {0,0,1,0,2,2,1,1} --> {0,0,0,1,1,1,2,2}
 * 
 */
public class MoveZeroesToLeftOnesTwosToRight {


    public static void move (int []arr) {

        // Step 1. Move all zeroes to left and twos to right

        int l = arr.length;
        int left = 0;
        int right = l-1;
    
        while (left<right) {
            if (arr[left] == 0){
                left++;
                continue;
            }
            
            if (arr[right] == 1 || arr[right] == 2){
                right--;
                continue;
            }
        
            swap(left,right,arr);      

        }

        // [let ... length-1] contains 1,2
        right = l-1;

        while (left<right) {
            if (arr[left] == 1){
                left++;
                continue;
            }
            
            if (arr[right] == 2){
                right--;
                continue;
            }
        
            swap(left,right,arr);      

        }
    }

    public static void swap (int i, int j, int []arr) {
        System.out.println ("Swapping " + arr[i] + " " + arr[j]);
        System.out.println ("Before: " + Arrays.toString(arr));
        int tmp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = tmp;
        System.out.println ("after: " + Arrays.toString(arr));
    }

    public static void main (String []args) {
        
        int []arr = new int[] {0,0,1,0,2,2,1,1};
        System.out.println (Arrays.toString(arr));
        move (arr);
        System.out.println (Arrays.toString(arr));
        
    }
}