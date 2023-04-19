/*****************************************
 * A template for a computer Nim player
 ****************************************/ 

 //which random method to use 
import java.util.Random;
public class Computer{
    
    private int mode;
    private int choice;
    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
    public void move(int marblesLeft){
        Random r = new Random();
        if (marblesLeft > 1){
            if (mode == 2){
            // if difficulty high comp play smart, mode = 0
                 
                  if (marblesLeft == 3 || marblesLeft == 7 || marblesLeft == 15 
                  || marblesLeft == 31 || marblesLeft == 63){
                    /*if marbleLeft is 3, 7, 15, 31, 63 play random no matter what mode*/
                        if (marblesLeft <= 3){
                            choice = 1;
                        }else{
                            choice = (int)(Math.random()*((marblesLeft/2))+1);
                        }
                  }
            

                  else{ // play smart
                    if(marblesLeft > 63){
                        choice = marblesLeft - 63;
                    }else if(marblesLeft > 31){
                        choice = marblesLeft - 31;
                    }else if(marblesLeft > 15){
                        choice = marblesLeft - 15;
                    }else if(marblesLeft > 7){
                        choice = marblesLeft - 7;
                    }else if(marblesLeft > 3){
                        choice = marblesLeft - 3;
                    }else if(marblesLeft == 2){
                        choice = marblesLeft - 1;
                    }else{
                        choice = 1;
                    }
                  }
            }
            else if (mode == 1){
            // if difficulty low, computer play dumb, mode = 1
                //System.out.println("You have chosen the EASY mode.");
                //choice = r.nextInt(marblesLeft/2)+1;
                if (marblesLeft <= 3){
                    choice = 1;
                }else{
                    choice = (int)(Math.random()*((marblesLeft/2))+1);
                }

            }
        }
    }

    public int getChoice(){
         return choice;
    }
    
    

}
