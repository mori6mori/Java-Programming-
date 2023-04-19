
// add your own banner here
//Keyao Liu kl3186
public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
		rank = r;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
		int result = this.getRank()- c.getRank();
		return result;
		/* if return positive then card is rank lower
		if return negative then card rank higher */
	}
	
	public String toString(){
		// use this method to easily print a Card object
		String resultCard;
		String cardSuit= "0";
		String cardRank = "0";
		//The suits represents 1-c:clubs, 2-d:diamonds,
		//3-h:hearts, 4-s:spades
		if(suit==1){
			cardSuit="clubs";
		}else if(suit==2){
			cardSuit="diamonds";
		}else if(suit==3){
			cardSuit="hearts";
		}else if (suit==4){
			cardSuit="spades";
		}
		
		if(rank>1 && rank<11){
			cardRank=""+rank;
		}else if(rank==1){
			cardRank="Ace";
		}else if(rank==11){
			cardRank="Jack";
		}else if(rank==12){
			cardRank="Queen";
		}else if(rank==13){
			cardRank="King";
		}
		
		resultCard=cardRank +" of "+ cardSuit;
		return resultCard;
	}
	// add some more methods here if needed
	public int getRank(){
		return rank;
	}
	public int getSuit(){
		return suit;
	}

	public boolean sameRank(Card c){
		return this.getRank() == c.getRank();
	}
	public int diffRank (Card c){
		return this.getRank() - c.getRank();
	}
	public boolean sameSuit(Card c){
		return this.getSuit() == c.getSuit();
	}
}
