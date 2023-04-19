/** Change.java - add your solutiuon to program 3 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Change {
    
    public static final void main(String[] args) {
        
        Scanner input=new Scanner (System.in);
        System.out.print ("Enter Amount recieved: ");
        int r=input.nextInt ();
        System.out.print ("Enter Amount due: ");
        int d=input.nextInt ();
        int change=(r-d);
        int dollar= change/100;
        int quarter= (change%100)/25;
        int dime=((change%100)%25)/10;
        int nickel= (((change%100)%25)%10)/5;
        int pennie=((((change%100)%25)%10)%5)/1;
        System.out.println("Dollars: " + dollar);
        System.out.println("Quarters: " + quarter);
        System.out.println("Dimes: " + dime);
        System.out.println("Nickels: " + nickel);
        System.out.println("Pennies: " + pennie);
       



    

        
        
        
    }
    
    
}