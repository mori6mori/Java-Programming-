/*****************************************
 * A template for a Human Nim player
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice;
    private Scanner input;
    
    public Human(){
        choice = -1;
    }
    
    public void move(int marblesLeft){
        // your code here
        //System.out.println("There are" + marblesLeft + " marbles");
        int option;
        if (marblesLeft ==1){
            option = 1;
        }else{
            option = marblesLeft/2;
        }
        System.out.println("Please take maximum " + option + 
        " marbles and miminum " + 1 + " marble: ");
        Scanner input = new Scanner (System.in);
        choice = input.nextInt();
    }

    public int getChoice(){
        return choice;
    }
}
