package de.ostfalia.gdp.ws19.s4;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jannik Feldmann
 *
 */
public class TextAnalyse {

  /**
   * @param args unbenutzt
   *
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.ENGLISH);

    System.out.print("Gib den Wert für text ein (String):");
    String text = scanner.nextLine();

    System.out.print("Gib den Wert für endungen ein (int):");
    String endung = scanner.next();

    scanner.close();
    System.out.println();

    System.out.println("Der String: " + text + " hat " + zaehleEndungen(text, endung)
        + " Worte/ Wörter die auf " + endung + " enden.");

  }

  /**
   * @param endung gesuchte Endung
   * @param text   gegebener Text
   * @return gibt Anzahl der gesuchten Endungen zurück
   */
  public static int zaehleEndungen(String text, String endung) {

    // Anzahl Endungen
    int aEndungen = 0;
    int t = text.length();
    int e = endung.length();

    // Durchlaufe einmal den kompletten String
    for (int i = 0; i <= t - e; i++) {
      // System.out.println("Gehe in For-Schleife i" + i);
      // System.out.print(aEndungen);

      // überprüft die nächsten Zeichen
      int ueberprueft = 0;

      // durchlaufe die länge des Strings endung
      for (int x = 0; x < e; x++) {
        // System.out.println("Gehe in For-Schleife x" + x);

        // überprüfe die nächsten e Zeichen, ob diese mit endung übereinstimmen
        if (text.charAt(i + ueberprueft) == endung.charAt(x)) {
          ueberprueft += 1;
          // System.out.println("Char At i stimmt mit endung an Stelle x überein");

          // Wurde der gesamte String endung überprüft?
          if (x == endung.length() - 1) {
            // System.out.println("Die letzten Wörter stimmten mit endungen überein");

            // War der überprüfte String eine Endung?
            if (i + ueberprueft == text.length()) {

              // Der überprüfte String war ein Ende eines Wortes
              // System.out.println("Das Textende wurde erreicht");
              aEndungen += 1;

              // War der überprüfte String eine Endung?
              // Ist das nächste Zeichen des Textes ein Sonderzeichen? 32 = "Leerzeichen" ; 33 = ! ;
              // 44 = , ; 46 = . ; 63 = ?
            } else if (text.charAt(i + ueberprueft) == 33 || text.charAt(i + ueberprueft) == 44
                || text.charAt(i + ueberprueft) == 46 || text.charAt(i + ueberprueft) == 63
                || text.charAt(i + ueberprueft) == 32) {

              // Der überprüfte String war ein Ende eines Wortes
              // System.out.println("Ein Sonderzeichen folgt");
              aEndungen += 1;

            }
          }

          // Stimmt das aktuelle Zeichen vom Text nicht mehr mit dem aktuellen Zeichen von endung
          // überein?
        } else {
          break;
        }
      }
    }
    return aEndungen;
  }
}