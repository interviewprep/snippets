import java.util.*;

public class Segment {

    public static boolean can_segment (String s, Set <String>dict) {
        HashSet <String>solved = new HashSet<String>();
        boolean ret = can_segment_helper(s, dict, solved);
        System.out.println (solved.toString());
        return ret;
    }


    public static boolean can_segment_helper (String s, Set <String> dict, HashSet<String> solved) {

        for (int i=0; i<s.length(); i++) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if(second == null || second.length() ==0 || dict.contains(second))
                    return true;

                if (solved.contains(second) == false) {
                    if(can_segment_helper(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }

        }
        return false; 
    }

    public static void main (String []args) {

        Set<String> dict = new HashSet<>(Arrays.asList("hello", "hell", "on", "now"));
        
        System.out.println (can_segment("hello now", dict));

    }
}