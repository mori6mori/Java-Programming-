/** Minutes.java - add your solutiuon to program 2 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Minutes {
    
    public static final void main(String[] args) {

        Scanner input=new Scanner (System.in);
        System.out.print ("Enter hours: ");
        int h=input.nextInt ();
        System.out.print ("Enter days: ");
        int d=input.nextInt ();
        System.out.print ("Enter weeks: ");
        int w=input.nextInt ();
        System.out.print ("Enter months: ");
        int y=input.nextInt ();

        int m = h*60+d*60*24+w*60*24*7+y*60*24*365;

        System.out.println("Number of minutes= "+m);
        
        
        
    }
    
    
}