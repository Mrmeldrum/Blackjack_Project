import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Dealer dealer;
    Game game;
    Deck deck;

    @Before
    public void before(){
        dealer = new Dealer();
        deck = new Deck();
        deck.addCards();
        game = new Game(deck);
    }

    @Test
    public void getDealer() {
        assertEquals("Dealer", game.dealer.getName());
    }
}
