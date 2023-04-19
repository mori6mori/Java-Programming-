
// add your own banner here
//Keyao Liu kl3186
// next step is write code for each pair and make sure the return matches with 
import java.util.Collections; 
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	// you'll probably need some more here
	private ArrayList<Card> hand;
	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		p = new Player();
		cards = new Deck();
		hand = p.getHand();

        for (int i = 0; i< testHand.length; i++ ){
            Card card;
            int rank = Integer.parseInt(testHand[i].substring(1));
            char suitChar = testHand[i].charAt(0);
            int suit = 0;
            if ( suitChar == 'c' ){
                suit = 1;
            }else if(suitChar == 'd'){
                suit = 2;
            }else if (suitChar == 'h'){
                suit = 3;
            }else if (suitChar == 's'){
                suit = 4;
            }
            card = new Card(suit, rank);
			p.addCard(card);
		}
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
		cards.shuffle();	
		

		for (int i = 0; i < 5; i++){
			p.addCard(cards.deal());
			//hand = new ArrayList<Cards>();
			hand = p.getHand();
		}

	}
	
	public void play(){
		// this method should play the game	
		Scanner s = new Scanner (System.in);
		System.out.println("This the hand dealt to you: ");
		for ( Card c : hand){
			System.out.println ( c );
		}
		System.out.println("How many cards you want to remove (0-5)? ");
		int rej = s.nextInt();
        if (rej < 0 || rej > 5){
				System.out.println("Incorrect card to remove. Please enter a number between 1-5 ");
				rej = s.nextInt();
		}
		for (int i = 0; i < rej; i++){
			int c = 5-i;
			System.out.println("Which card do you want to remove (1-"+ c +")?");
			int cardRej = s.nextInt();
			if (cardRej < 1||cardRej>c){
				System.out.println("Incorrect card to remove. Please re-enter a new number");
                cardRej = s.nextInt();
		    }
			p.removeCard (hand.get(cardRej-1));
			for ( Card newC : hand){
				System.out.println ( newC );
			}
		}
		for (int i = 0; i < rej; i++){
			p.addCard(cards.deal());
		}
		System.out.println("This is your final hand!");
		for ( Card c : hand){
			System.out.println ( c );
		}

		System.out.println("You can bet between 1-5 tokens: ");
		int b = s.nextInt();
		p.bets(b);
		String ckHand = checkHand(hand);
		System.out.println("You got: "+ ckHand + " & won: " + p.getWin() +" tokens");
		System.out.println("Current Bankroll: " + p.getBankroll());
	}
		

		

	
	public ArrayList<Card> sortHand(ArrayList <Card> hand){
		//sort the hand so rank from small to large 
		Collections.sort(hand);
		return hand;

	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		int win = 0;
		String tempString = " ";
		hand = sortHand(hand);
		if (onePair(hand)==1){
			win = 1;
			tempString = "one pair";
		}else if (fullHouse(hand)==1){
			win = 6;
			tempString ="fullHouse";
		}else if (twoPair(hand)==1){
			win = 2;
			tempString = "two pair";
		}else if (fourKind(hand)==1){
			win = 25;
			tempString = "Four of a Kind";
		}else if (threeKind(hand)==1){
			win = 3;
			tempString = "Three of a kind";
		}else if (royalFlush(hand)){
			win = 250;
			tempString = "royalFlush";
		}else if (straightFlush(hand)){
			win = 50;
			tempString = "straightFlush";
		}else if (straight(hand)){
			win =4;
			tempString = "straight";
		}else if (flush(hand)){
			win =5;
			tempString = "flush";
		}else{
			tempString = "no pair";
		}
		p.winnings((double)win);
		return tempString;
		
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
	public void makeHand (){
		hand = new ArrayList<Card>();
		for (int i=0; i < 5; i++){
			p.addCard(cards.deal()) ;
		}
	}
	
	public int onePair(ArrayList<Card> hand){
		
		Card currentCard;
		int pair = 0;
		int i = 0;
		while (i < hand.size()-1){
			currentCard = hand.get(i);
			if (currentCard.sameRank(hand.get(i+1)) && threeKind(hand)!= 1){
				pair++;
				i++;
			}else {
				i++;
			}
		}
		return pair;
	}
	
	public int twoPair(ArrayList<Card> hand){
		int pair = 0;
        if (onePair(hand) == 2){
			pair = 1;
		}else{
			pair = 0;
		}
		return pair;
	}

	public int threeKind (ArrayList<Card> hand){
		if (fullHouse(hand)==1){
			return 0;
		}else if (fourKind(hand)==1){
			return 0;
		}else if (hand.get(0).sameRank(hand.get(2))
			|| hand.get(1).sameRank(hand.get(3))
			|| hand.get(2).sameRank(hand.get(4))){
				return 1;
		}else{
			return 0;
		}
	}
	public boolean straight (ArrayList<Card> hand){
        boolean b = false;
	
		if (hand.get(4).diffRank(hand.get(0))==4){
			b = true;
		}else if (hand.get(0).getRank()==1 && hand.get(4).getRank()==13 &&
			hand.get(4).diffRank(hand.get(1))==3 ){
			b = true;
		}

		if (royalFlush(hand)){
			b = false;
		}
        
		return b;
	}

	public boolean flush (ArrayList<Card> hand){
		boolean b = true;
		for (Card c : hand){
			int i = 0;
            while (i<hand.size()-1){
			    if (!c.sameSuit(hand.get(i+1))){
				    b = false;
			    }
				i++;
			}
		}
		if (onePair(hand)>0){
			b = false;
		}else if (straightFlush(hand)){
			b = false;
		}else if (royalFlush(hand)){
            b = false;
        }
		return b;
	}

	public int fullHouse (ArrayList<Card> hand){
		if (hand.get(0).sameRank(hand.get(2))&& hand.get(3).sameRank(hand.get(4))){
			return 1; 
		}else if (hand.get(0).sameRank(hand.get(1))&& hand.get(2).sameRank(hand.get(4))){
			return 1; 
		}
		else{
			return 0;
		}
	}

	public int fourKind (ArrayList<Card> hand){
        if (hand.get(0).compareTo(hand.get(3))==0 ||
        hand.get(1).compareTo(hand.get(4))==0){
            return 1;
        }
		
		return 0;
	}

	public boolean straightFlush (ArrayList<Card> hand){
		boolean b = true;
		if (!straight(hand)){
			b = false;
		}else if (royalFlush(hand)){
			b = false;
		}
        for (Card c : hand){
			int i = 0;
            while (i<hand.size()-1){
			    if (!c.sameSuit(hand.get(i+1))){
				    b = false;
			    }
				i++;
			}
		}
        return b;
	}
	

    public boolean royalFlush (ArrayList<Card> hand){
        boolean b = true;

		if (hand.get(0).getRank()==1 && hand.get(4).getRank()==13 &&
			hand.get(4).diffRank(hand.get(1))==3 ){
			b = true;
		}else{
			b = false;
		}

		for (Card c : hand){
			int i = 0;
            while (i<hand.size()-1){
			    if (!c.sameSuit(hand.get(i+1))){
				    b = false;
			    }
				i++;
			}
		}

        return b;
		
	}



	
}
