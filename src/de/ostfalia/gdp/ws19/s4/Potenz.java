package de.ostfalia.gdp.ws19.s4;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jannik Feldmann
 *
 */
public class Potenz {

  /**
   * @param y long
   * @param b long
   * @return ist Potenz oder nicht
   */
  public static boolean istPotenz(long y, long b) {

    // mit voschleife hoch addieren bis b+b+b+... == y

    //

    if (y == 1) {
      return true;
    }

    long x = b;

    if (b != 1) {
      for (; x < y;) {
        x = x * b;
      }
    }
    if (x == y) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * @param args ungenutzt
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.ENGLISH);

    System.out.print("Gib die Zahl y an(long):");
    long y = scanner.nextLong();

    System.out.print("Gib die Zahl b an(long):");
    long b = scanner.nextLong();

    scanner.close();
    System.out.println();

    String einekeine = istPotenz(y, b) ? "eine" : "keine";
    System.out.println("" + y + " ist " + einekeine + " Potenz von " + b);
  }
}