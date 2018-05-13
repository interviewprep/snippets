import java.util.*;
import java.util.concurrent.*;

public class HackerR1 { 

    public static CopyOnWriteArrayList <Listing> l=new CopyOnWriteArrayList <>(); // master list of listing
    public static ArrayList<String> r = new ArrayList<String>(); // paginated results

    public static class Listing { 
        
        Integer hostId; 
        Integer listing_id; 
        Float score;
        String city; 
        
        public Listing (int hostId, int listid, float score, String city) {
            this.hostId = hostId;
            this.listing_id = listid;
            this.score = score; 
            this.city = city; 
        }
        
        @Override
        public String toString() {

            return hostId + "," + listing_id + "," + score + "," + city;
        }
    }

    public static class ListingComparator implements Comparator<Listing> {
        public int compare (Listing l1, Listing l2) {
            if (l1.score < l2.score)
                return 1;
            else if (l1.score > l2.score)
                return -1;
            else
                return 0;
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
        Collections.sort(l, new ListingComparator());

    }

    public static void populateHashMap (int host_id, int listid, float score, String city) {
    
        Listing listing = new Listing(host_id, listid, score,city);
        l.add(listing);
    }

    public static void addListingToList (Listing listing) {
        r.add(listing.toString());
    }
    public static String[] paginate (int num, String[] results) {

        int length = results.length; 
        populateHashMap(results);

        CopyOnWriteArrayList<Integer> visited = new CopyOnWriteArrayList<>();
        int counter_l = 0;
        int counter = 0;
        while(counter_l < length) {
            for (Listing listing:l) {
                if(counter < 5){
                    addListingToList(listing); counter++; counter_l++;
                    l.remove(listing);
                }       
                if (counter == num){

                    counter = 0; 
                    r.add("===== PAGINATION =====");
                }
            }
            
        }

        System.out.println ("==========results =============");
        String []arr_r = new String[r.size()];
        int counter_arr_r = 0;
       
        for (String s: r) {
            System.out.println(s);arr_r[counter_arr_r] = s;
            ++counter_arr_r; 
        }
        return arr_r;
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
        paginate(3,results);
    }

    // ################Testing - TDD ###########################
    public static void test_populateHashMap_INPArrayString_OUTNone (String []results) {
        
        populateHashMap(results);

        for (Listing list:l) {
            System.out.println (list);
        }


    }

}