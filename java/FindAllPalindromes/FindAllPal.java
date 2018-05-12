import java.util.*;

public class FindAllPal {

    public static boolean is_a_palindrome (String target, int i, int j) {

        while (i<j) { 
            if (target.charAt(i) != target.charAt(j)) 
                return false;
            i++; j--;
        }
        return true;
    }

    public static int find_all_palindromes(String arr) {

        int count = 0;

        for (int i=0 ; i< arr.length(); i++) {
            for (int j=i+1; j<arr.length(); j++) {

                if (is_a_palindrome(arr, i, j))
                {
                    System.out.println (arr.substring(i,j) + " is a palindrome");
                    count++;
                }
            }
        }
        return count;
    }

    public static void main (String []args) {
        // some tests
        /**
        String arr1 = "aba"; String arr2 = "ababa";
        String arr3 = "ababc"; String arr4 = "ababac";
        System.out.println (arr1 + " " + is_a_palindrome(arr1, 0, 2));
        System.out.println (arr2 + " " + is_a_palindrome(arr2, 0, 4));
        System.out.println (arr3 + " " + is_a_palindrome(arr3, 0, 4));
        System.out.println (arr4 + " " + is_a_palindrome(arr4, 0, 5));
        */
        
        // other tests

        System.out.println ("count:" + find_all_palindromes("aabbbaa"));


    }
}