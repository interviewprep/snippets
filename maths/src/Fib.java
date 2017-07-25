// Proving https://www.mathsisfun.com/numbers/fibonacci-sequence.html
// In this code, I was trying to see if Golden ratio can be used
// to calculate the Fibonanci numbers
public class Fib {
  public static double GOLDEN_RATIO=1.618034; 
  public static void main (String []args){ 
    System.out.println (fib(15)); 
    System.out.println (fibF(15));
  }

  // Using the recursion as per definition
  public static int fib(int n) {
    if (n <= 0)
      return 0;
    if (n == 1)
      return 1; 
    return fib (n-1) + fib (n-2);
  }
  // Using the Golden ratio
  public static int fibF(int n) {
    // fib(n) = golden^n - (1-golden)^n / sqrt(5)
    //          A-B / C 
    double a =  Math.pow(GOLDEN_RATIO, n);
    double b =  Math.pow((1-GOLDEN_RATIO), n);
    double c = Math.sqrt(5);
    
    return (int) ((a-b)/c);
  }
}
