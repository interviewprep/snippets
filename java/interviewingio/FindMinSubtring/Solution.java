/*
Write a function that takes an input string and a character set and returns the minimum-length substring which contains every letter of the character set at least once, in any order
If you don't find a match, return an empty string

Example:
Input: "aabbcb"
Alphabet: {'a', 'b', 'c'}
Output: "abbc"

Input: "aaaaaaaaaabbbbbbbbccccccccsbabbbccc"
Alphabet: {'a', 'b', 'c'}
Output: "csba"

Input: "aaaaaaaaaabbbbbbbbccccccccsbabbbccc"
Alphabet: {'a', 'b', 'c', 'f'}
Output: ""
*/  

// https://repl.it/repls/BumpyPlumDungbeetle 



import java.io.*;
import java.util.*;

class Solution {
  
  // s - string "aabbcb"
  // t - pattern  "abbc"
  
  public static String minWin (String s, Set<Character> t) { 
  
    
    // Algo 
    // Step .1 (Map) Capture all counts in target string (long string) 
    // Step 2.  (Map) Capture all char count in s (pattern characters).
    // Step 3... now wat...?? 
    //           
    HashMap<Character, Integer> target = new HashMap <> (); 
    
      String result = ""; 

    // populate this
    for (Character c : t) {
       if (target.containsKey(c)) {
            target.put(c,target.get(c) + 1);
       }else {
          target.put(c,1);
       }
    }
    HashMap<Character, Integer> map = new HashMap <> (); 
    int left =0;
    int minLen = s.length()+1; 
    int count =0; /// total mapped chars?? 
    
    // go through th string
    for (int i=0; i<s.length(); i++) {
    
       char c = s.charAt(i);
      
      // the complexity is here.... so bear with me
      if (t.contains(c)){ 
      
          if (map.containsKey(c)) {
          
             if (map.get(c) < target.get(c)) {
                 // increase the count
                 count++;
             }else {
                map.put(c,1);
                count++; 
             }
          }
      }
      
      // now at this stage I have hit pattern length, i got a substring... 
      
      if (count == t.size()) {
      
          char sc = s.charAt(left); 
        while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
            if (map.containsKey(sc) && map.get(sc) > target.get(sc))
              map.put(sc, map.get(sc)-1);
            left++;
            sc = s.charAt(left); 
        }
        if (i-left+1 < minLen) {
           result = s.substring(left, i+1); 
           minLen = i-left + 1; 
        }
      }
    
    }
    
    // Step 2
    // character counter for s 
    return result; 

  }
  
  public static void main(String[] args) {
    /**
    
    Example:
Input: "aabbcb"
Alphabet: {'a', 'b', 'c'}
Output: "abbc"

Input: "aaaaaaaaaabbbbbbbbccccccccsbabbbccc"
Alphabet: {'a', 'b', 'c'}
Output: "csba"

Input: "aaaaaaaaaabbbbbbbbccccccccsbabbbccc"
Alphabet: {'a', 'b', 'c', 'f'}
Output: ""

    */
    Set<Character> chars = new HashSet<>();
    chars.add('a');
    chars.add('b');
    chars.add('c');
    System.out.println(minWin("aabbcb", chars));    
    
  }
}
