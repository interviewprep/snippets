import java.io.*;
import java.util.*;

import org.omg.CORBA.DynAnyPackage.InvalidSeq;

public class ArrOfArrProduct {


    public static int[] arrayOfArrayProducts(int[] arr) {

        int n = arr.length;
        int []left = new int [n];
        int []right = new int[n];
        int []prod = new int[n]; 

        for (int i=0; i< n; i++)
            prod[i] = 1;
        left[0] = 1; right[n-1]= 1;

        // left arr
        for (int i=1; i<n; i++) {
            left[i] = arr[i-1] * left[i-1]; 
        }
        // right arr
        for (int j=n-2; j>0; j--) {
            right [j] = arr[j+1] * right[j+1];  
        }
        // prod
        for (int k=0; k<n;k++){ 
            prod[k] = left[k] * right[k];
        }
        return prod;
    }


    public static void main (String []args) {

        test1(new int[]{8,10,2}, new int []{20,16,80});
        test1(new int[]{2,7,3,4}, new int []{84,24,56,42});
    }

    public static void test1 (int []testData1, int []testResult1) {
        
        int []result = arrayOfArrayProducts(testData1);
        String msg = "";

        msg = "testData: " + Arrays.toString(testData1) + " Expected: " + Arrays.toString(testResult1);

        if (areEqual(result, testResult1))
            msg =  "Pass : " + msg;

        else 
            msg = "Fail : " + msg; 

        msg = msg +  "result: " + Arrays.toString(result);
        System.out.println (msg);

    }

    private static boolean areEqual (int []expected, int []actual) {

        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<expected.length; i++) {
            sum1 += expected[i];
            sum2 += actual[i]; 
        }
        return sum1 == sum2;
    }



}