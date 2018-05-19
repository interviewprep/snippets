import java.util.*;

public class FindVol { 

    public static int findVol (int []arr) {

        /**
        int vol = 0;
        for (int i=0; i<arr.length ; i++) {
            if (i ==0 || i == arr.length-1)
                continue; 
 
            int mleft = findMaxLeft (arr, i);
            int mright = findMaxRight (arr,i);

            int h=Math.min(mleft, mright);
            System.out.println ("l: "+ mleft + " r:" + mright + " h:" + h + " arr[i];" + arr[i]);
            int volC = h - arr[i]; 
            if (volC > 0)
                vol = vol + volC;

        }
        return vol;
        */
        int []arrLR = populateArrLR (arr);
        System.out.println ("arrLR: " + Arrays.toString(arrLR));

        int []arrRL = populateArrRL (arr);
        System.out.println ("arrRL: " + Arrays.toString(arrRL));

        int []minArr = calculateMinArr (arrLR, arrRL);
        System.out.println ("minArr: " + Arrays.toString(minArr));
    
        int vol = 0;
        for (int i=1; i<arr.length-1; i++) {
            System.out.println ("min:" + minArr[i] + " arr:" + arr[i]);
            vol = vol + (minArr[i]-arr[i]);
        }

        return vol;
    }

  

    public static int[] calculateMinArr (int []arr1, int []arr2) {

        int []min = new int[arr1.length];

        for (int i=0; i< arr1.length; i++) {
            min[i] = Math.min(arr1[i], arr2[i]);
        }
        return min;
    }

    public static int[] populateArrLR (int []arr) {

        int max = 0;
        int []arrLR = new int[arr.length];

        for (int i=0;i<arr.length;i++) {
            if (i==0) {
                max = arr[0];
                System.out.println ("max: " + max);
                arrLR[0] = -1; 
            }else{ 
                if (max < arr[i]) { 
                    max = arr[i];
                }
                arrLR[i]  = max;

            }
        }
        return arrLR;
    }

    public static int[] populateArrRL (int []arr){

        int max = 0;
        int []arrRL = new int[arr.length];

        for (int i=arr.length-1;i>0;i--) {
            if (i==arr.length-1) {
                max = arr[i];
                arrRL[i] = -1; 
            }else{ 
                if (max < arr[i]) { 
                    max = arr[i];
                }
                arrRL[i]  = max;

            }
        }
        return arrRL;
    }

    public static int findMaxLeft (int []arr, int col) {

        int max = 0;
        for (int i=col-1; i>=0; i--) {
            if (arr[i] > max) max = arr[i];                                                                                                                                                                                                             
        }
        return max;
    }

    public static int findMaxRight (int []arr, int col) {

        int max = 0;
        for (int i=col+1; i<arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void main (String []args) {

        System.out.println ("Vol: " + findVol (new int[] {5,1,3,4}));
    
        
    }
}