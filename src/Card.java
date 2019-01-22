/**
 * class Card simulates a playing card with a rank and suit.
 *
 * @author (Dwight Johnson)
 * @version (December 1, 2015)
 */
public class Card {
  public final static int CLUBS = 0,       // Codes for the 4 suits.
          DIAMONDS = 1,
          HEARTS = 2,
          SPADES = 3;

  public final static int ACE = 1,          // Codes for the non-numeric cards.
          JACK = 11,        //  Cards 2 through 10 have their
          QUEEN = 12,       //   numerical values for their codes.
          KING = 13;

  private int suit; // 0-> Clubs; 1->Diamonds; 2->Hearts; 3->Spades
  private int rank; // 0 -> empty :::: 1 through 13 -> Ace through King

  /**
   * Constructors for objects of class Card
   */
  public Card() {
    this.suit = 0;
    this.rank = 0;
  }

  public Card(int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  //This method is not as useful as toString method below
  public static void printCard(Card card) {
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"narf", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    System.out.println(ranks[card.rank] + " of " + suits[card.suit]);
  }

  public static boolean sameCard(Card card1, Card card2) {
    return (card1.suit == card2.suit && card1.rank == card2.rank);
  }

  public static int compareCard(Card card1, Card card2) {
    int value1 = 0;
    int value2 = 0;
    if (card1.rank == 1) {
      value1 = 14;
    } else {
      value1 = card1.rank;
    }
    if (card2.rank == 1) {
      value2 = 14;
    } else {
      value2 = card2.rank;
    }
    if (value1 > value2) {
      return 1;
    }
    if (value1 < value2) {
      return -1;
    }
    if (card1.suit > card2.suit) {
      return 1;
    }
    if (card1.suit < card2.suit) {
      return -1;
    }
    return 0;
  }

  public static int compareCardRanks(Card card1, Card card2) {
    int value1 = 0;
    int value2 = 0;
    if (card1.rank == 1) {
      value1 = 14;
    } else {
      value1 = card1.rank;
    }
    if (card2.rank == 1) {
      value2 = 14;
    } else {
      value2 = card2.rank;
    }
    if (value1 > value2) {
      return 1;
    }
    if (value1 < value2) {
      return -1;
    }
    return 0;
  }

  //methods for class Card
  public int getRank() {
    return rank;
  }

  public int getSuit() {
    return suit;
  }

  public String getSuitAsString() {
    // Return a String representing the card's suit.
    // (If the card's suit is invalid, "??" is returned.)
    switch (suit) {
      case SPADES:
        return "Spades";
      case HEARTS:
        return "Hearts";
      case DIAMONDS:
        return "Diamonds";
      case CLUBS:
        return "Clubs";
      default:
        return "??";
    }
  }

  public String getRankAsString() {
    // Return a String representing the card's value.
    // If the card's value is invalid, "??" is returned.
    switch (rank) {
      case 1:
        return "Ace";
      case 2:
        return "2";
      case 3:
        return "3";
      case 4:
        return "4";
      case 5:
        return "5";
      case 6:
        return "6";
      case 7:
        return "7";
      case 8:
        return "8";
      case 9:
        return "9";
      case 10:
        return "10";
      case 11:
        return "Jack";
      case 12:
        return "Queen";
      case 13:
        return "King";
      default:
        return "??";
    }
  }

  public String toString() {
    // Return a String representation of this card, such as
    // "10 of Hearts" or "Queen of Spades".
    return getRankAsString() + " of " + getSuitAsString();
  }

}
