import java.io.*;
import java.util.*;

class Solution {
  
  static int indexEqualsValueSearch(int[] arr) {
    System.out.println ("enter");
    int n = arr.length;
    int inx = n + 1, val = -1;
    
    for(int i = 0; i < n; i++) {
      if(i > arr[i]) { 
        System.out.println ("enter1");
        i = (n - i) / 2;
      }
      else if(i < arr[i]) {
      System.out.println ("enter2");
        i = (i - 0) / 2;
      }
      else {
        if(i < inx) {
          inx = i;
          val = arr[i];
          break;
        } 
      }
      System.out.println ("enter3:" + i);
     
    }
    return val;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{-8,0,2,5};
    System.out.println(indexEqualsValueSearch(arr));
  }

}