import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {


        Deck deck = new Deck();
        deck.addCards();
        deck.shuffleCards();
        Game game = new Game(deck);

        game.initializeGame();
        game.playGame();

    }
}
