import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {


    Deck deck1;
    Player player;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before() {
        deck1 = new Deck();
        player = new Player("Niall");
        deck1.addCards();
        deck1.shuffleCards();
        card1 = new Card(SuitType.HEARTS, RankType.Ace);
        card2 = new Card(SuitType.DIAMONDS, RankType.Ace);
        card3 = new Card(SuitType.CLUBS, RankType.Five);
        card4 = new Card(SuitType.HEARTS, RankType.Five);
    }

    @Test
    public void canTakeAddCard() {
        deck1.dealPlayer(player);
        deck1.dealPlayer(player);
        assertEquals(2, player.getHand().size());
        assertEquals(50, deck1.getCards().size());
    }

    @Test
    public void canCountCards() {

        deck1.addCards();
        deck1.shuffleCards();
        deck1.dealPlayer(player);
        deck1.dealPlayer(player);
        assertEquals(true, player.cardCount() > 0);
    }

    @Test
    public void canGetSoft17TwoAces() {
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);

        assertEquals(17, player.cardCount());
    }

    @Test
    public void canGet12FromTwoAces() {
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);

        assertEquals(12, player.cardCount());
    }
}
