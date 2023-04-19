/** F2C.java - add your solutiuon to program 1 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class F2C {
    
    public static final void main(String[] args) {

      Scanner input=new Scanner (System.in);  
      System.out.print ("Enter temperature in Fahrenheit: ");
      int a=input.nextInt();
      int b=((a-32)*5/9);
      System.out.println (b+" degree in Celcius");


        
        
        
    }
    
    
}