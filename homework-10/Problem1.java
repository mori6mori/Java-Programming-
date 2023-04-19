
/* Following the specification in the README.md file, provide your 
 * Problem1.java class.
 */

public class Problem1{
    public static void main (String[] args){
        int result = pow(2, 3);
        System.out.println (result); 
        result = pow(5, 2);
        System.out.println (result); 
    }
    public static int pow (int x, int n){
        if (n == 0){
            return 1;
        }
        return x * pow(x, n-1);
    }
}