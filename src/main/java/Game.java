import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;

    public Dealer getDealer() {
        return dealer;
    }

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.dealer = new Dealer();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }


    public void playersTurn() {
        for (Player player : getPlayers()) {
            Boolean isFinished = false;
            Scanner sort = new Scanner(System.in);
            String playerChoice;
            if (player.cardCount() == 21) {
                System.out.println("Blackjack!");
                isFinished = true;
            }
            while (!isFinished){
                System.out.println(player.getName() + ", you have " + player.printCards() + " Would you like to Stick or Twist?");
                playerChoice = sort.nextLine();
                if ("twist".equals(playerChoice.toLowerCase())){
                    deck.dealPlayer(player);
                    player.checkBust();
                    if (player.getIsBust()){
                        isFinished = true;
                        System.out.println("Is bust on " + player.cardCount());
                    }
                } else if ("stick".equals(playerChoice.toLowerCase())) {
                    System.out.println(player.getName() + " has stuck with " + player.cardCount());

                    isFinished = true;
                } else {
                    System.out.println("Please enter Stick or Twist");
                }
            }

            // OG method

//            if (player.cardCount() == 21) {
//                System.out.println("blackjack");
//            } else {
//                Scanner sort = new Scanner(System.in);
//                String playerChoice;
//                System.out.println(player.getName() + ", you have " + player.printCards() + " Would you like to Stick or Twist?");
//                playerChoice = sort.nextLine();

//                while (!"stick".equals(playerChoice.toLowerCase())) {
//                        if ("twist".equals(playerChoice.toLowerCase())) {
//                            deck.dealPlayer(player);
//                            player.checkBust();
//                            if (player.getIsBust()){
//                                System.out.println(player.getName() + " has bust");
//                                break;
//                            } else {
//                                System.out.println(player.getName() + " now as " + player.printCards());
//                                System.out.println("Would you like to Stick with " + player.cardCount() + " or twist?");
//                                Scanner sort2 = new Scanner(System.in);
//                                playerChoice = sort2.nextLine();
//                            }
//                        }
//                }
//            }
        }
    }

    public void dealerTurn(){
        while (dealer.cardCount() < 16){
            deck.dealDealer(dealer);
        }
        if (dealer.cardCount() > 21){
            System.out.println("Dealer has bust");
            this.dealer.setBust(true);
        } else {
            System.out.println("Dealer stands at " + dealer.cardCount());
        }

    }


    public void dealPlayers(){
        for (Player player: getPlayers()) {
            deck.dealPlayer(player);
            deck.dealPlayer(player);
            System.out.println(player.getName() + " was dealt " + player.printCards());
        }
    }

    public void cardsToDealer(){
        this.deck.dealDealer(this.dealer);
        this.deck.dealDealer(this.dealer);
        System.out.println("Dealer was dealt " + dealer.getHand().get(0).toString() + " and ?????");
    }

    public void setUpPlayers(){
        Scanner capacity = new Scanner(System.in);
        String numOfPlayers;

        System.out.println("Number of players: ");
        numOfPlayers = capacity.nextLine();

        System.out.println("Number of player: " + Integer.parseInt(numOfPlayers));

        for (int i = 0; i < Integer.parseInt(numOfPlayers); ++ i){
            Scanner in = new Scanner(System.in);
            String userName;

            System.out.println("Player " + (i+1) +", enter your name:");
            userName = in.nextLine();

            Player player = new Player(userName);
            addPlayer(player);

        }
    }

    public void initializeGame(){

        setUpPlayers();
        cardsToDealer();
        dealPlayers();

    }

    public void endResults(){
        System.out.println("Results summery: ");
        for (Player player: getPlayers()){
            int playerScore = player.cardCount();
            int dealerScore = dealer.cardCount();
            if (player.getIsBust()){
                System.out.println(player.getName() + " bust at " + playerScore);
                System.out.println(dealer.getName() + " won with " + dealerScore);
            } else if (dealer.getIsBust()){
                System.out.println(dealer.getName() + " bust at " + dealerScore);
                System.out.println(player.getName() + " won with " + playerScore);
            } else if (playerScore == dealerScore) {
                System.out.println(player.getName() + " and " + dealer.getName() + " draw with " + playerScore);
            } else if (playerScore > dealerScore){
                System.out.println(player.getName() + " beat " + dealer.getName() + " with a hand of " + playerScore + " vs " + dealerScore);
            } else {
                System.out.println(dealer.getName() + " beat " + player.getName() + " with a hand of " + dealerScore + " vs " + playerScore);
            }
        }
    }

    public void playGame(){

        playersTurn();
        dealerTurn();
        endResults();

    }

}