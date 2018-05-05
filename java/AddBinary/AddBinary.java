import java.util.*;

public class AddBinary {

    public String addBinary (String a, String b) {
        
        int i_a=ConvBinToDec(a);
        int i_b =ConvBinToDec(b);

        int sum = i_a + i_b; 

        int []bin_num = new int[32];
        int l = bin_num.length;

        int quot = sum; int i =0;
        while (quot != 0) { 
            bin_num[l-1-i] = quot %2;
            quot = quot/2; i++;
        }
        return Arrays.toString(bin_num);
        
    }

    public int ConvBinToDec (String n) { 
        
        int sum = 0;
        for (int i=0; i<n.length(); i++) {
            int number = (int)(n.charAt(i)-'0');
            System.out.println ("number: "+ number);
            if (number == 1) {
                sum = sum + (int)Math.pow(2,i);
            }
            else {

            }
        }
        System.out.println ("sum:" + sum);
        return sum;
        
    }

    public static void main (String []args) {

        AddBinary b = new AddBinary();
        System.out.println (b.ConvBinToDec("110"));
        System.out.println (b.addBinary("11", "1"));
        
    }
}