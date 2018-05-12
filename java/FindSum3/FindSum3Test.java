import java.util.*; 

public class FindSum3Test { 

    FindSum3 fs = new FindSum3();

    public void test_DoesSum3Exists_ExpectsTrue () {

        int []arr = { 4,3,1,2,0,6};
        int tgt = 7; 
        if (!fs.DoesSum3Exists(arr,tgt)) {
            System.out.println ("test_DoesSum3Exists_ExpectsTrue FAILS");    
            throw new RuntimeException("Could not find sum3:" + Arrays.toString(arr) + " tgt:" + tgt);
        }
        System.out.println ("\ntest_DoesSum3Exists_ExpectsTrue passes");
        
    }

    public void test_DoesComplementExists_ExpectsTrue () { 

        int arr[] = {5,10,1,4,2};
        int target = 7; // target - arr[i] = complement
        int start = 1;
        int end = arr.length-1;

        if (!fs.DoesComplementExists(arr, start, 4)) {
            System.out.println ("test_DoesComplementExists_ExpectsTrue FAILS");    
            throw new RuntimeException("Cant sum3" + Arrays.toString(arr));
        }
        System.out.println ("\ntest_DoesComplementExists_ExpectsTrue passes");
    }

    public static void main (String args[]) {

        FindSum3Test fst = new FindSum3Test();
        fst.test_DoesComplementExists_ExpectsTrue();
        fst.test_DoesSum3Exists_ExpectsTrue();
        
    }

}