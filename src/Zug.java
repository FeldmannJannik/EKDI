import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Zug {
  
  static boolean[] strecke = new boolean[240];
  static boolean signal;
  static boolean ampel;
  static boolean doors = true; // true = open, false = closed
  static boolean moving = false; // true = moving, false = standing
  static int speed = 0; // 0 - 100
  static int driven_distance = 0;
  static int t = 0;
  static boolean[] bahnhoefe = new boolean[240];

 public static void main(String[] args) throws IOException {

  for(int i = 1; i >= 1;) {
  
  System.out.println("Welcher Modus soll aktiviert werden?");
  System.out.println();
  System.out.println("mode1 = manuelles fahren");
  System.out.println("mode2 = autonomes fahren");
  
  
  Scanner scanner = new Scanner(System.in);
  
  String mode = scanner.next();

  
  if(mode.equals("mode1")){
   mode1();   
   i = 0;
  } else if(mode.equals("mode2")) {
   mode2();
   i = 0;
  } else {
   System.out.println("Undefinierter Befehl");
   i = 1;
   
  }

  scanner.close();
  }
 } 
  
// mode1 = manuelles Fahren 
public static void mode1() {
 
  // wurde die Endstation erreicht ? else :
  
  System.out.println("Was soll passieren? (Befehl):");
  System.out.println("Beschleunigen = a");
  System.out.println("Entschleunigen = b");
  System.out.println("Türen öffnen = t");
  /*
   * Auf 100 beschleunigen
   * Den nächsten Banhof anfahren
   * ...
   * Die Befehle auch implementieren
   */
  
  Scanner scanner = new Scanner(System.in);
  scanner.useLocale(Locale.ENGLISH);

  String a = scanner.next();
  
  scanner.close();
  
  if(a.equals("d")) {
   System.out.println("Zug beschleunigt um 5");
  } else {
     System.out.println("Leider kein Text gefunden.");
  }
  
  //SysOut aktuelle Position und Situation
 }

public static void mode2() {
 /*
  * if Endstation erreicht sysOut Endstation erreicht -> Beendung des Befehls
  * else
  * Wann kommt das nächste Singnal?
  * Fahre den nächsten Banhof an
  * repeat
  *  
  */
 
 System.out.println("------------------------");
 System.out.println("Endstation erreicht");
 
}


public static void accelerate() {
 if (doors == false) {
  t++;
  speed += 5;
 } else {
  doors = true;
  t++;

 }

}

public static void deccelerate() {
 if (speed == 0) {
  System.out.println("Geschwindigkeit bereits bei 0!");
 } else {
  speed -= 5;
  t++;
 }

}

public static void zeiterhoehung() {
 t++;
}

public static void main(String[] args) { // main

 Scanner scanner = new Scanner(System.in);
 System.out.println("");

 for (int s = 0; s < 240; s++) {
  if (s == 99 || s == 199) {
   strecke[s] = true; // Bahnhof
   if (Math.random() >= 0.5) {
    ampel = false;// Ampel ist rot oder Haltestelle
    bahnhoefe[s] = false;
   } else {
    ampel = true; // Ampel ist gruen
   
   }
  } else {
   strecke[s] = false;
  }
  if (s == 239) {
   System.out.println("Streckenende erreicht!");
   strecke[s] = true;
   ampel = false; // Endstation
   break;
  }
  Zug.zeiterhoehung();
 }
 for (int s = 0; s < 240; s++) {
  
 }
 }



}