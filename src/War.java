/**
 * class War plays the game where 2 people each have a deck of cards.
 * Both players turn over a card and the player with highest rank card
 * gets both cards. If both cards have the same rank IT'S WAR. Each
 * player puts down a face down card and then each turns over another card.
 * highest rank gets all the cards played.
 * <p>
 * play() to play over and over until one player is out of cards
 *
 * @author Dwight Johnson
 * @version December 8, 2015
 */

import java.util.Scanner;

public class War {
  /**
   * Method play will run the game repeatedly until one player is out of cards
   *
   */
  public static void play() {
    Deck halDeck = new Deck();
    Deck playerDeck = new Deck();
    Deck warPile = new Deck(0); //accommulates the war piles until the winner gets all

    Scanner keyboard = new Scanner(System.in);
    System.out.print("My name is HAL. What's your name: ");
    String playerName = keyboard.nextLine();
    Card halCardDraw;
    Card playerCardDraw;
    halDeck.shuffle();
    playerDeck.shuffle();

    while (!gameOver(halDeck, playerDeck)) {
      halCardDraw = Deck.dealFirstCard(halDeck);
      System.out.println("HAL draws a " + halCardDraw);
      playerCardDraw = Deck.dealFirstCard(playerDeck);
      System.out.println(playerName + " draws a " + playerCardDraw);
      switch (Card.compareCardRanks(halCardDraw, playerCardDraw)) {
        case 1: //hal wins
          System.out.println("Hal takes the cards");
          halDeck = Deck.addCard(halDeck, halCardDraw);
          halDeck = Deck.addCard(halDeck, playerCardDraw);
          while (warPile.cardsLeft() > 0) {
            halDeck = Deck.addCard(halDeck, Deck.dealFirstCard(warPile));
          }
          break;
        case -1: //player wins
          System.out.println(playerName + " takes the cards");
          playerDeck = Deck.addCard(playerDeck, playerCardDraw);
          playerDeck = Deck.addCard(playerDeck, halCardDraw);
          while (warPile.cardsLeft() > 0) {
            playerDeck = Deck.addCard(playerDeck, Deck.dealFirstCard(warPile));
          }
          break;
        case 0: //war
          System.out.println("*+*+*+*+* IT'S WAR!!! *+*+*+*+*");
          warPile = Deck.addCard(warPile, halCardDraw);
          warPile = Deck.addCard(warPile, playerCardDraw);
          break;
      }
      System.out.println();
    }

    if (halDeck.cardsLeft() == 0) {
      System.out.println(playerName + " wins!!!");
    } else {
      System.out.println("Hal wins!!!");
    }
  }

  /**
   * Method gameOver
   *
   * @param player1 deck of cards
   * @param player2 deck of cards
   * @return true if one player is out of cards
   */
  public static boolean gameOver(Deck player1, Deck player2) {
    return (player1.cardsLeft() == 0) || (player2.cardsLeft() == 0);
  }
}
