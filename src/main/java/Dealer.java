import java.util.ArrayList;

public class Dealer {

    private String name;
    private ArrayList<Card> hand;
    private Boolean isBust;

    public Dealer(){
        this.name = "Dealer";
        this.hand = new ArrayList<Card>();
        this.isBust = false;
    }

    public void setBust(Boolean bust) {
        isBust = bust;
    }

    public Boolean getIsBust() {
        return isBust;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card){
        this.hand.add(card);
    }


    public String printCards() {
        String result;
        Boolean containsAce = false;
        ArrayList<String> cardString = new ArrayList<String>();
        for (Card card : this.hand) {
            String cardDetails = card.toString();
            cardString.add(cardDetails);
            if (card.getRank() == RankType.Ace){
                containsAce = true;
            }
        }
        String sentence = new String();
        for (String card : cardString){
            sentence += (card + " and a ");
        }
        if (containsAce && cardCount() != 21) {
            result = sentence.substring(0, sentence.length() - 7) + ", total: (soft)" + cardCount() + ".";
        } else {
            result = sentence.substring(0, sentence.length() - 7) + ", total: " + cardCount() + ".";
        }
        return result;
    }

    public int cardCount(){
        int handTotal = 0;
        int aceCount = 0;
        for (int i = 0; i < this.hand.size(); ++ i){
            handTotal += this.hand.get(i).getValueFromEnum();
            if (this.hand.get(i).getRank() == RankType.Ace){
                aceCount += 1;
            }
        }

        while (handTotal > 21 && aceCount > 0){
            handTotal -= 10;
            aceCount -= 1;
        }
        return handTotal;
    }


}
