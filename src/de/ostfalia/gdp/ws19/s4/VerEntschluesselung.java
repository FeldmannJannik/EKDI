package de.ostfalia.gdp.ws19.s4;

import java.util.Locale;
import java.util.Scanner;


/**
 * @author Jannik Feldmann
 *
 */
public class VerEntschluesselung {

  /**
   * @param args unbenutzt
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.ENGLISH);

    System.out.print("Gib den Wert für eingabe ein (String):");
    String eingabe = scanner.nextLine();

    System.out.print("Gib den Wert für n ein (int):");
    int n = scanner.nextInt();

    scanner.close();
    System.out.println(eingabe.length());

    System.out.println("Das Wort " + eingabe + " wird verschlüsselt zu "
        + verschluesseln(eingabe, n) + " und wieder entschlüsselt zu "
        + entschluesseln(verschluesseln(eingabe, n), n) + " .");
  }

  /**
   * @param eingabe String
   * @param n int
   * @return verschlüsselter Text
   */
  public static String verschluesseln(String eingabe, int n) {

    // verschlüsselter String
    String ver = "";

    for (int i = 0; i < eingabe.length(); i++) {

      char x = (char) (eingabe.charAt(i) + (n % 26));

      // Klein- oder Großbuchstabe
      if (eingabe.charAt(i) >= 65 && eingabe.charAt(i) <= 90) {
        // Großbuchstaben 65 - 90

        while (x > 90) {
          // x - 91 + 65, um wieder bei "A" anzufangen
          x = (char) (x - 26);
        }
        ver = ver + x;
      } else if (eingabe.charAt(i) >= 97 && eingabe.charAt(i) <= 122) {
        // Kleinbuchstaben 97 - 122
        while (x > 122) {
          // x - 123 + 97, um wieder bei "a" anzufangen
          x = (char) (x - 26);
        }
        ver = ver + x;
      } else {

        char y = eingabe.charAt(i);
        ver = ver + y;
      }
    }
    return ver;
  }

  /**
   * @param eingabe String
   * @param n int
   * @return entschlüsselter Text
   */
  public static String entschluesseln(String eingabe, int n) {

    // entschlüsselter String
    String ent = "";

    for (int i = 0; i < eingabe.length(); i++) {

      char x = (char) (eingabe.charAt(i) - (n % 26));

      // Klein- oder Großbuchstabe
      if (eingabe.charAt(i) >= 65 && eingabe.charAt(i) <= 90) {
        // Großbuchstaben 65 - 90

        while (x < 65) {
          // x + 91 - 65, um wieder bei "Z" anzufangen
          x = (char) (x + 26);
        }
        ent = ent + x;
      } else if (eingabe.charAt(i) >= 97 && eingabe.charAt(i) <= 122) {
        // Kleinbuchstaben 97 - 122
        while (x < 97) {
          // x + 123 - 97, um wieder bei "z" anzufangen
          x = (char) (x + 26);
        }
        ent = ent + x;
      } else {
        char y = eingabe.charAt(i);
        ent = ent + y;
      }

    }
    return ent;
  }
}