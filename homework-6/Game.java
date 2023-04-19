/*****************************************
 * A template for a Nim game
 ****************************************/ 
import java.util.Random;

public class Game{
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private int difficulty;
    Random random = new Random ();

    public Game(int difficulty){
        // choose difficulty level 
        this.difficulty = difficulty; 
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
    }
     
    public void play(){
        if (difficulty == 2){
            System.out.println("You have chosen the HARD mode.");
        }
        if (difficulty == 1){
            System.out.println("You have chosen the EASY mode.");
        }
        
        /*generate a random marble, Math.random() Getting a random number 
        between 0 (inclusive) and 1 (exclusive)*/
        marbles = 10 +(int)(Math.random()*91);
        System.out.println("There are " + marbles +" marbles in the pile");

        int firstPlayer = random.nextInt(2);
        //int firstPlayer = getFirstPlayer(); 
        if(firstPlayer == 0){
            System.out.println("Computer gets the first move");
        }else if (firstPlayer == 1){
            System.out.println("Human gets the first move");
        }

        while (marbles!=0){
            if (firstPlayer == 0){
            // if firstPlayer == 0, Computer plays first 
                computerPlayer.move(marbles);
                System.out.println("--The computer removed " +computerPlayer.getChoice()+ " marbles--" );
                marbles = marbles - computerPlayer.getChoice();
                System.out.println ("There are "+ marbles+" marbleLeft");
                firstPlayer += 1;
                //human plays 
            }
            else if (firstPlayer == 1){
            // if firstPlayer == 1, human plays first 
                humanPlayer.move(marbles);
                System.out.println("You removed " +humanPlayer.getChoice()+ " marbles");
                marbles = marbles - humanPlayer.getChoice();
                System.out.println ("There are "+ marbles+" marble left in the pile");
                firstPlayer -= 1;

            }
        }
        if (firstPlayer == 0){
            System.out.println("Computer won :( ");
        }else if (firstPlayer == 1){
            System.out.println ("You won! Congrats :)");
        }

    }
  /*
    public static int getFirstPlayer(){
        
        return firstPlayer;
    }  */
    
     // you may wish to add more methods here
    


}