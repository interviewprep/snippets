import java.io.*;
import java.util.*;

import javax.swing.text.Highlighter.Highlight;

import java.text.*;


public class ArrayIndexEq {

    private static final boolean DEBUGON = true; 
    public static int indexEqualsValueSearch(int []arr) {

        //int ret = bruteForce (arr);
        int ret = bs (arr);
        return ret;
    }

    private static int bs (int []arr) {

        int high = arr.length-1;
        int low = 0;
        int mid = low + (high-low)/2; 
        int ret = -1;
        int count = 0; 
        debug (Arrays.toString (arr));
        
        while (low<=high) { 
            mid =  low + (high-low)/2;
            String msg = "mid:" + mid + " low:" + low + " high:" + high; 
            debug (msg);  
            if (mid == arr[mid]) {
                ret = mid;
                return ret; 
            }
            else if (mid -arr[mid]>0 ) {
                high = mid-1;
            }else if (mid - arr[mid]<0) {
                low = mid+1;
            }
        }
        return -1;
    }

    private static void debug (String msg) {

        if (DEBUGON)
            System.out.println ("[DEBUG]" + msg);
    }
    private static int bruteForce (int []arr) {
        
        // Brute force
        for (int i=0; i < arr.length; i++) { 
            if (arr[i] == i)
                return i;
        }
        return -1;
    }

    public static void main (String []args) {
        myTest (new int[]{0,2,3});
        myTest (new int[]{-1,1,12,15,16});
        myTest (new int[]{-8,0,2,5});
        myTest (new int[]{-1,0,3,6});
    }

    public static void myTest (int []arr) { 

        int ret = indexEqualsValueSearch(arr);
        
        String msg = "ret: " + ret + " Array:" + Arrays.toString(arr);
        if (ret < 0 || ret > arr.length-1)
            msg = "OutOfBound : ret: " + ret;
        else {
            if (ret == arr[ret])
                msg = "Success: " + msg; 
            else
                msg = "Failure: " + msg;
        }
        System.out.println(msg);

    }
}