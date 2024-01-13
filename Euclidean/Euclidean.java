/**
 * This class represents the Euclidean algoritm for calculating
 * the Greatest Common Divisor of two integers, using both recursive
 * and iterative solutions.
 * 
 * @author 
 * @version 
 */
public class Euclidean
{
    // complete the recursive version below
    public static int gcdRecursive(int m, int n)
    {
        if (m % n == 0) {
            return n;
        }
        else {
            return gcdRecursive(n, m % n);
        }
    }

    // complete the iterative version below
    public static int gcdIterative(int m, int n)
    {
        while (m % n != 0) {
            int tempn = n;
            int tempm = m;
            m = tempn;
            n = tempm % tempn;
        }
        return n;
    }
}
