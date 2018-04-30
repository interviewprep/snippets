import java.io.*; 
import java.util.*;
import java.text.*; 

public class FindNR {

    
    // The algo is to used BS to find the number
    public static double root (double x, int n) { 
        double low = 0; double high = x; 
        double mid = -1;

        while (true) {

            mid = low + ((high-low)/2.0);
            
           if (isErrorACceptable(mid, n, x))
                return mid;
            if (isGuessNumberGreater(mid, n, x) == true) {
                high = mid-1;  
            }else {
                low = mid +1;
            }
        }
    }


    // Helper class to multiply number x times of root
    // It essentially does number ^root... (root times)
    public static double findNumber (double number, int root) { 
        double tmp = 1;
        for (int i=0; i<root; i++) 
            tmp = tmp * number;

        return tmp;

    }

    // Another helper class
    // returns true if guessNumber root to 'root' is greater than value
    public static boolean isGuessNumberGreater (double guessNumber, int root, double value) {
        
        double tmp = findNumber (guessNumber,root); 
       
        if (tmp < value) return false;
        
        return true;
    }

    // Helper class to check if error is within 0.001 error range
    public static boolean isErrorACceptable (double guessNumber, int root, double value) {
        
        double tmp = findNumber (guessNumber,root); 
        double error = Math.abs(value - tmp);
       
        if (error < 0.001)
            return true; 

        return false; 
    }


    public static void main (String args[]) {
        myTest(9,2);
        myTest(7,3);

    }

    public static void myTest (double x, int r) { 

        double number = root (x,r); 
        
        double diff = Math.abs(Math.pow(x,1.0/r) - number); 
        
        String msg = "x: " + x +  "\tr:"  + r + " number: " + number + "\texpected: " + Math.pow(x,1.0/r);  
        
        msg += ((diff < 0.001)?"\n\nTest Success": "Test fail"); 

        System.out.println (msg);
    }
}