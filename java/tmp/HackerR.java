import java.util.*;
public class HackerR { 

    public static class Listing { 
        Integer listing_id; 
        Float score;
        String city; 

        public Listing (int listid, float score, String city) {
            this.listing_id = listid;
            this.score = score; 
            this.city = city; 
        }
        
        @Override
        public String toString() {

            return listing_id + "," + score + "," + city;
        }

    }

    public static class ListComparator implements Comparator<Listing> {
        public int compare (Listing l1, Listing l2) {
            if (l1.score < l2.score)
                return 1;
            else if (l1.score > l2.score)
                return -1;
            else
                return 0;
        }
    }

    public static TreeMap<Integer, PriorityQueue<Listing>> m = new TreeMap<Integer, PriorityQueue<Listing>>();

    public static void populateHashMap (int host_id, int listid, float score, String city) {
        Listing listing = new Listing(listid, score,city);
        
        if (m.containsKey(host_id) == false) {
            PriorityQueue <Listing> q = new PriorityQueue<>(new ListComparator());
            q.add(listing);
            m.put (host_id, q);    
        }   
        else {
            PriorityQueue <Listing>q = m.get(host_id);
            q.add (listing);
        } 
    }

    public static void populateHashMap (String []results) {

        for (int i=0; i< results.length; i++) {
            String []arr = results[i].split(",");
            populateHashMap(
                Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]),
                Float.parseFloat(arr[2]),
                arr[3]
            );
        }

    }

    static boolean addListingToList (int key, ArrayList<String>l) {
        PriorityQueue<Listing> q = m.get(key);

        if (q.size() <=0) {
            //System.out.println("Empty queue");
            return false; 
        }
            
        String s = String.valueOf(key)+ "," + q.poll().toString();
        //System.out.println ("Adding:" + s + " to queue");
        l.add(s);
        return true;
    }

    static String[] paginate (int num, String []results) {

        /**
         * algo is quite straight forward .. but it takes time to code
         * 
         * Populate the structure in map with key as hostId and the Listing 
         *    - Design Choice #1 TreeMap because I want to sort hostId
         *    - Design Choice #2 PQ for Listing because I want to deque by score
         * Step 1. Populate the HashMap
         * Step 2 - go through the all the keys in the hashmap
         * Step 3 -    keep track of global counter (to check that you going through all results)&&
         *                   a counter for pagination
         * Step 4 - if your pagination counter < 5, you need to reset to the search to the beginning of the map
         * Step 5-         s.t that you publish all possible listing
         * Step 6-  if pagination counter>5, reset and go to 2
         * 
         * Bug #1: It is not sorting by score on each page
         *         To fix this, we need to change the structure to Listing to include 
         *         host id and put in a List with sorting order per score
         */
        int length = results.length; 
        ArrayList<String> r = new ArrayList<String>();
        populateHashMap(results);

        int counter_l = 0; 
        int counter = 0;
        ArrayList<Integer> keyList = new ArrayList<>();
        while (counter_l < length) {

            for (int key: m.keySet()){
                if(addListingToList(key, r)){
                    ++counter; 
                    ++counter_l;

                    // does that key has more listing, if yes, store it
                    // as we need to publish
                    PriorityQueue <Listing>q= m.get(key);
                    if (q.size() !=0) {
                        keyList.add(key);
                    }
                }

                if (counter == num){
                    counter = 0;
                    r.add("=======Pagination======");
                }else {
                    for (int key1: keyList) {
                        boolean status = addListingToList(key1,r); 
                        if(status) {
                            ++counter; ++counter_l;
                            if (counter ==5) {
                                counter =0;
                                r.add("========= Pagination ===========");
                            }
                        }
                        
                    }

                }
            }
           
        }  

        System.out.println ("==========results =============");
        for (String s: r) 
            System.out.println(s);

        return null; 
    }

    public static void main (String []args) {

        String []results = 
        {
            "1,28,300.1,San Francisco", 
            "4,5,209.1,San Francisco", 
            "20,7,208.1,San Francisco", 
            "23,8,207.1,San Francisco", 
            "16,10,206.1,Oakland", 
            "1,16,205.1,San Francisco", 
            "1,31,204.6,San Francisco", 
            "6,29,204.1,San Francisco", 
            "7,20,203.1,San Francisco", 
            "8,21,202.1,San Francisco", 
            "2,18,201.1,San Francisco", 
            "2,30,200.1,San Francisco", 
            "15,27,109.1,Oakland", 
            "10,13,108.1,Oakland", 
            "11,26,107.1,Oakland", 
            "12,9,106.1,Oakland", 
            "13,1,105.1,Oakland", 
            "22,17,104.1,Oakland", 
            "1,2,103.1,Oakland", 
            "28,24,102.1,Oakland", 
            "18,14,11.1,San Jose", 
            "6,25,10.1,Oakland", 
            "19,15,9.1,San Jose", 
            "3,19,8.1,San Jose", 
            "3,11,7.1,Oakland", 
            "27,12,6.1,Oakland", 
            "1,3,5.1,Oakland", 
            "25,4,4.1,San Jose", 
            "5,6,3.1,San Jose", 
            "29,22,2.1,San Jose", 
            "30,23,1.1,San Jose"
        };
        
        //test_populateHashMap_INPArrayString_OUTNone(results);
        
        paginate(5, results);
    }

    // ################Testing - TDD ###########################
    public static void test_populateHashMap_INPArrayString_OUTNone (String []results) {
        
        populateHashMap(results);

        for (int k:m.keySet()) {
            System.out.println (k + "\t" + m.get(k).toString());
        }


    }
}