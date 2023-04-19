public class DeckTester{
    public static void main (String args[]){
        Deck cardDeck = new Deck ();
        System.out.println ("d1: " + cardDeck);
        cardDeck.shuffle();
        System.out.println("d2: " + cardDeck);
        System.out.println("Card dealt: " + cardDeck.deal());

    }
}