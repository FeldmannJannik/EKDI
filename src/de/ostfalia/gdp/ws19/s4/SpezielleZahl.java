package de.ostfalia.gdp.ws19.s4;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jannik Feldmann
 *
 */
public class SpezielleZahl {

  /**
   * @param args ungenutzt
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.ENGLISH);

    System.out.print("Gib eine Zahl ein (int):");
    int zahl = scanner.nextInt();

    scanner.close();
    System.out.println();

    // Gibt die quersumme aus:
    // System.out.println(quersumme(zahl));

    // Überprüft die Zahl, ob diese speziell ist oder nicht
    // String einekeine = "";

    /*
     * if(zahl % quersumme(zahl) != 0) { einekeine = "keine"; } else { istSpeziell(zahl); }
     */
    String einekeine = istSpeziell(zahl) ? " ist eine" : " ist keine";

    System.out.println("Die Zahl " + zahl + einekeine + " spezielle Zahl ");
  }

  /**
   * @return quersumme
   * @param zahl quersumme
   */
  public static int quersumme(int zahl) {

    // m = quersumme
    int m = 0;

    while (0 != zahl) {

      // Addiert die letzte Ziffer der Zahl zur Quersumme
      m = m + (zahl % 10);

      // Entfernt die letzte Ziffer von Zahl
      zahl = zahl / 10;
    }
    return m;
  }

  /**
   * @return Ist zahl speziell
   * @param zahl Gegebene Zahl
   */
  public static boolean istSpeziell(int zahl) {

    return zahl % quersumme(zahl) == 0;
  }
}