
// add your own banner here
//Keyao Liu kl3186
import java.util.ArrayList;
public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;/*player can bet between 1-5 tokens
        and win n times as much as original payout*/

	// you may choose to use more instance variables
    private double win;
		
	public Player(){		
	    // create a player here
        hand = new ArrayList <Card>(); 
        bankroll = 50;
        bet = 0;
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
        hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        hand.remove(c);

    }
		
        public void bets(double amt){
            // player makes a bet
            bet = amt;
            if (bet>5){
			    System.out.println("Not enough token");
		    }else if (bet == 0){
                System.out.println("Can't play without token");
            }else{
			    bankroll -= bet;
			    System.out.println("You have "+bankroll+ " left");
            }
        }

        public void winnings(double odds){
            //	adjust bankroll if player wins
            win = odds * bet;
            bankroll += win; 
            
        }
        public double getWin(){
           
            return win; 
        }

        public double getBankroll(){
            // return current balance of bankroll
            return bankroll;
        }

        // you may wish to use more methods here
        public ArrayList<Card> getHand(){
            return hand;
        }


        
}


