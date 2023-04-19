/* Following the specification in the README.md file, provide your 
 * Problem2.java class.
 */
import java.util.Arrays;

 public class Problem2{
    public static void main (String[] args){
       //create a main method that builds an array of String objects and then sort that array with Arrays.sort.
        String[] words = {"yes", "no", "rabbit", "cane"};
        
        //sort BEFORE search 
        Arrays.sort(words); 
        //print out the sorted array 
        for (int i = 0; i < words.length; i++){
            System.out.println (words[i]);
        }
              
        int loc = binarySearch(words, "no");
        System.out.println("The word no appear at: " + loc);
        loc = binarySearch(words, "bad");
        System.out.println("The word bad appear at: " + loc);
        loc = binarySearch(words, "cane");
        System.out.println("The word cane appear at: " + loc);
        loc = binarySearch(words, "yes");
        System.out.println("The word yes appear at: " + loc);
    }

    public static <E extends Comparable<E>>       
    int binarySearch(E[] a, E x){

        return binarySearch (a, x, 0, a.length-1);

    }
    // if not static then we have to create an object in the problem 2 class to invoke this method on
    private static <E extends Comparable<E>>       
        int binarySearch(E[] a, E x, int low, int high){
            
            int mid;

            if (low > high){
                return -1;
            }
            
            mid = (high + low)/2;
          
            int compareResult = a[mid].compareTo(x);
            if (compareResult < 0){
                low = mid + 1;

            }else if (compareResult > 0){
                high = mid - 1;
                
            }else {
                return mid;
            }

            return 0 + binarySearch(a, x, low, high); 
         
    }

 }
