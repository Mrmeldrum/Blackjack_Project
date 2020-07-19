import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Deck deck;
    Dealer dealer;
    Game game;
    Card card1;
    Card card2;

    @Before
    public void before(){

        card1 = new Card(SuitType.CLUBS, RankType.Ace);
        card2 = new Card(SuitType.HEARTS, RankType.Ace);
        deck = new Deck();
        deck.addCards();
        dealer = new Dealer();
        game = new Game(deck);
//        game.addDealer(dealer);

    }

    @Test
    public void canAddCardsToDealer() {
        assertEquals(2, dealer.getHand().size());
    }

//    @Test
//    public void dealerCanGoBust() {
//        dealer.addCard(card1);
//        dealer.addCard(card2);
//        assertEquals("Dealer has bust", game.dealerStickOrTwist());
//    }
}
