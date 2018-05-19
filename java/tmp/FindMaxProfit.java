import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;
import org.omg.SendingContext.RunTime;

public class FindMaxProfit {

    public FindMaxProfit() {

    }

    public int findMaxProfit (int []arr) {

        int maxProfit = arr[0];
        int minPrice = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < minPrice) { 
                minPrice = arr[i];
            }
        }
        return maxProfit;
    }

    public static void main (String []args) {

        Test_MaxProfit t = new Test_MaxProfit(); 
        t.test_findMaxProfit_Expect100();
    }

}

class Test_MaxProfit {

    FindMaxProfit p = new FindMaxProfit(); 

    public void test_findMaxProfit_Expect100 () {
        int maxProfit = p.findMaxProfit(new int []{10,23,100,4});
        
        if(maxProfit != 100)
            throw new RuntimeException("Fails..." + maxProfit);
        System.out.println ("\n FindMaxProfit PASSES!!!");
    }

}