/**
 * Class Deck simulates a deck of cards and
 * uses the class Card in an array.
 *
 * @author Dwight Johnson
 * @version December 3, 2015
 */
public class Deck {
  Card[] cards;
  private int cardsUsed;

  /**
   * Constructors for objects of class Deck
   * deck has places for numCards but no cards are created or assigned
   */
  public Deck(int numCards) {
    cards = new Card[numCards];
    cardsUsed = 0;
  }

  /**
   * Deck Constructor
   * creates a standard deck with all the cards sorted by suit and rank
   */
  public Deck() {
    cards = new Card[52];
    int index = 0;

    for (int suit = 0; suit <= 3; suit++) {
      for (int rank = 1; rank <= 13; rank++) {
        cards[index] = new Card(suit, rank);
        index++;
      }
    }
    cardsUsed = 0;
  }

  //Methods for class Deck

  /**
   * Method pickRandomInt
   *
   * @param numberOfOptions number of possible integer values including 0
   * @return an integer value >= 0 and < numberOfOptions
   */
  private static int pickRandomInt(int numberOfOptions) {
    return (int) (Math.random() * numberOfOptions);
  }

  /**
   * Method findCard
   *
   * @param deck deck of cards to search
   * @param card to look for in deck
   * @return -1 if not found. If found, the index (location) of the card in the deck.
   */
  public static int findCard(Card[] deck, Card card) {
    for (int i = 0; i < deck.length; i++) {
      if (Card.sameCard(deck[i], card)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Method addCard
   *
   * @param deck to copy
   * @param card to card
   * @return new deck with the given deck with the card added (one card larger in size)
   */
  public static Deck addCard(Deck deck, Card card) {
    int length = deck.cards.length;
    Deck newDeck = new Deck(length + 1);
    for (int c = 0; c < length; c++) {
      newDeck.cards[c] = deck.cards[c];
    }
    newDeck.cards[length] = card;
    return newDeck;
  }

  /**
   * Method subdeck
   *
   * @param deck with cards to select. deck will not be changed.
   * @param low  index start copying cards
   * @param high index to end copying cards
   * @return sub which includes only the cards in the index range between low and high in deck
   */
  public static Deck subdeck(Deck deck, int low, int high) {
    Deck sub = new Deck(high - low + 1);

    for (int i = 0; i < sub.cards.length; i++) {
      sub.cards[i] = deck.cards[low + i];
    }
    return sub;
  }

  /**
   * Method dealFirstCard
   *
   * @param hand to take card from
   * @return first card in deck which is then removed from deck making it one card smaller
   */
  public static Card dealFirstCard(Deck hand) {
    Card leavingCard = hand.cards[0];
    Deck smallerHand = Deck.subdeck(hand, 1, hand.cards.length - 1);
    hand.cards = smallerHand.cards;
    return leavingCard;
  }

  /**
   * Method printDeck
   * This method is probably not needed because toString is more flexible
   * but is still included as it was in the sample program.
   *
   * @param deck to print
   */
  public static void printDeck(Deck deck) {
    for (int i = 0; i < deck.cards.length; i++) {
      Card.printCard(deck.cards[i]);
    }
  }

  /**
   * Method shuffle
   * <p>
   * object method that shuffles to object deck
   */
  public void shuffle() {
    Card tempCard = new Card();
    for (int i = 0; i < cards.length; i++) {
      int randomIndex = pickRandomInt(cards.length);
      tempCard = cards[randomIndex];
      cards[randomIndex] = cards[i];
      cards[i] = tempCard;
    }
    cardsUsed = 0;
  }

  /**
   * Method cardsLeft
   *
   * @return cards left in deck regardless which method is being used to deal
   */
  public int cardsLeft() {
    // As cards are dealt from the deck, the number of cards left
    // decreases.  This function returns the number of cards that
    // are still left in the deck.
    return cards.length - cardsUsed;
  }

  /**
   * Method dealCard
   * Good for games that only deal with one deck.
   * The deck inself isn't changed until it is shuffled after the cards have been all dealt.
   *
   * @return the next available card in the deck and increases cardsUsed
   */
  public Card dealCard() {
    // Deals one card from the deck and returns it.
    if (cardsUsed == 52)
      shuffle();
    cardsUsed++;
    return cards[cardsUsed - 1];
  }

  /**
   * Method toString
   *
   * @return a String containing the suit and rank of the card object
   */
  public String toString() {
    String deckStr = "";
    for (int i = 0; i < cards.length; i++) {
      deckStr = deckStr + cards[i] + "\n";
    }
    return deckStr;
  }
}
