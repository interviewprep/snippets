import java.util.*;

public class FindSum3 {

    public FindSum3() { 

    }

    /**
     * [4,3,1,2] , 6
     * 
     * [4,3], -1 // edge case to check 
     * [4,1], 1 // 
     * [4,2], 0
     * [3,1], 2 // true
     * 
     * 1. go through list 0...n-2 
     * 2.     go through list 1..n-1
     * 3.         add x+i, x+i+1 in hashmap, where key is complement
     * 4.               find if complement exists in arr[x+1+2....n-1] =? return true if yes
     * 
     */
    public boolean DoesSum3Exists (int []arr, int tgt) {
        
        int l = arr.length;
        boolean status = false;
        for (int i=0; i<l-2; i++) {
            for (int j=i+1; j<l-1; j++) {
                int comp = tgt - (arr[i] + arr[j]); 
                status = DoesComplementExists(arr, j+1, comp);
                if (status == true) {
                    System.out.println (" " + arr[i] + " " + arr[j] );
                    return status;
                }
            }
        }

        return status;
    }

    public boolean DoesComplementExists (int []arr, int start, int comp) {

        if (comp < 0) return false;

        for (int i=start; i<arr.length; ++i) {
            if (comp == arr[i]) {
                System.out.print ("\t" + comp);
                return true;
            }
        }
        return false;
    }

    public static void main (String args[]) {

    }
}