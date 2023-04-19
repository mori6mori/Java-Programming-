public class CardTester {
    public static void main (String args[]){
        Card c1 = new Card(1, 9);
        Card c2 = new Card(2, 7);

        System.out.println(c1.compareTo(c2));
        System.out.println(c1);
    }
}