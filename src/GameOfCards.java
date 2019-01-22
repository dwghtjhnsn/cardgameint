/**
 * GameOfCards demonstrates how to use arrays, classes, and objects
 * by playing a card game with a deck of cards.
 *
 * @author (Dwight Johnson)
 * @version (December 3, 2015)
 */

import java.util.Scanner;

public class GameOfCards {
  /**
   * Method getInt
   *
   * @param maxValue largest interger that will be a valid answer
   * @return an int value between 1 and maxValue inclusive
   */
  public static int getInt(int maxValue) {
    Scanner keyboard = new Scanner(System.in);
    int intAnswer = 0;
    boolean valid = false;
    do {
      if (keyboard.hasNextInt()) {
        intAnswer = keyboard.nextInt();
        valid = (intAnswer <= maxValue && intAnswer >= 1);
        if (!valid) {
          keyboard.nextLine();
          System.out.print("Enter a number between 1 and " + maxValue + ": ");
        }
      } else {
        keyboard.nextLine();
        System.out.print("Enter only a number: ");
      }

    } while (!valid);
    return intAnswer;
  }

  /**
   * main executable for class GameOfCards
   * includes a menu with basic validation
   *
   */
  public static void main(String[] args) {
    System.out.println("Welcome to CS 1 Card Game Central");
    System.out.println("Choose your game:");
    System.out.println("     1. High Card Draw");
    System.out.println("     2. War");
    System.out.println("     3. Black Jack");
    System.out.println("     4. Quit");
    System.out.print("Enter Choice: ");
    int choice = getInt(4);
    System.out.println("----------------------------------\n\n");

    switch (choice) {
      case 1:
        HighCardDraw.play(); //uses static methods so no object needs to be created
        break;
      case 2:
        War.play(); //uses static methods so no object needs to be created
        break;
      case 3:
        BlackJack.play(); //uses static methods so no object needs to be created
        break;
      default:
        System.out.println("Come back later when you are ready to play...");
    }
  }
}
