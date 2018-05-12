import java.util.*;

public class FlattenDic {

    static HashMap<String,String> res = new HashMap<>();
    
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        
        for (String key:dict.keySet()){
            System.out.println ("key:" + key);

            Object value = dict.get(key);
            if (value instanceof String){
                res.put(key, (String)dict.get(key));
            }else if (value instanceof HashMap) {
                HashMap<String, Object> sub1 = (HashMap)value;
                flattenDictionary(sub1);
            }
        }
        
        return res;
    }

    public static void main (String []args) {
        HashMap <String,Object>m2 = new HashMap<>();
        
        HashMap <String,Object>m3 = new HashMap<>();
        HashMap <String,Object>m4 = new HashMap<>();
        HashMap <String,Object>m5 = new HashMap<>();

        m5.put ("", "1");
        m4.put ("d", "3");
        m4.put ("e", m5); 

        m3.put ("c", m4);
        m3.put ("b", "3");
        m3.put ("a", "2");

        m2.put ("Key2", m3);

        m2.put("Key1", "1");
        
        
        
        
        System.out.println (m2);
        flattenDictionary(m2);
        System.out.println (res);
    }
}