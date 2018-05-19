import java.util.*;


public class FindMin {

    public static int findMinDist (int []arr, int x, int y) {

        HashMap <Integer,ArrayList<Integer>>m = new HashMap<Integer,ArrayList<Integer>>();

        if (arr.length <=0) 
            throw new RuntimeException("Empty array");

        for (int i=0; i<arr.length; i++) {
            ArrayList<Integer> l; 
            if (m.containsKey(arr[i])) {
                l = m.get(arr[i]);
                l.add(i);
            }else 
            {
                l = new ArrayList<Integer>();
                l.add(i);
                m.put(arr[i], l);
            }
        }
        System.out.println ("Main");
        System.out.println (Arrays.toString(arr));
        System.out.println (x + " " + y);
        
        int ret = findMinDistHelper(m, arr, x, y);
        return ret;
    }

    public static int findMinDistHelper (HashMap <Integer, ArrayList<Integer>> m, int []arr, int x, int y) {

        System.out.println ("Helper");
        System.out.println (m.toString());
        System.out.println (Arrays.toString(arr));
        System.out.println (x + " " + y);

        ArrayList<Integer> lx = m.get(x); 
        ArrayList<Integer> ly = m.get(y);
        
        if (lx == null || ly == null)
            throw new RuntimeException ("Unable to find .." + arr[x] + "," + arr[y] + ".. in map");
        
        int maxDist = 0;
        for (Integer _x: lx) {
            for (Integer _y:ly) {
                int diff = Math.abs(_x - _y);
                if (maxDist < diff) maxDist = diff;

            }
        }
        return maxDist;
    }

    public static void main(String []args) {

        int []arr = {1,3,6,2,7,9,8,2};                                                                                                 
        if (findMinDist(arr, 3,9)==4) {
            System.out.println ("Passes ... (3,9)->4");
        }
        else
        {
            System.out.println ("Fails ... (3,9)->4");
        }
        if (findMinDist(arr, 2,8)==1) {
            System.out.println ("Passes ... (2,8)->1");
        }else 
        {
            System.out.println ("Fails ... (2,8)->1");
        }
    }
}