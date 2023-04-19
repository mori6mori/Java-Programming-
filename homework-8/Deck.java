
import java.util.*;
// add your own banner here
//Keyao Liu kl3186
public class Deck {
	
	private Card[] cards;
	private Card card;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		cards = new Card[52];
		for (int i = 0; i < cards.length; i++){
			if (i <= 12){
				card = new Card(1, i+1 );
				cards[i] = card ;
			}else if (i <= 25){
				card = new Card (2, i+1-13);
				cards [i] = card;
			}else if (i <= 38){
				card = new Card (3, i+1-26);
				cards [i] = card;
			}else if (i <= 51){
				card = new Card (4, i+1-39);
				cards [i] = card;
			}
			
		}
		
	}
	
	public void shuffle(){
		// shuffle the deck here
		for (int i = 0; i < 100; i++){
			int rand = (int)(Math.random()*52);
			Card tempCard = cards [0];
			cards[0] = cards[rand];
			cards[rand] = tempCard;
		}
		top = 0;
	}
	
	public Card deal(){
		// deal the top card in the deck
		Card dealCard = cards[top];
		if (top > cards.length -1){
			System.out.println("ERROR: No cards left in the pile!");
		}else{
			top++;
			dealCard = cards[top-1];
		}
		return dealCard;
	}

	public String toString() {
		String d= "";
		for (int i = 0; i < cards.length; i++){
			
			d += cards[i] + "|" ;
		}
		return d;
	}
	
	
	// add more methods here if needed

}
