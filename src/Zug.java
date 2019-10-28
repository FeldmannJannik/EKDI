import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import javax.net.ssl.SSLContext;
import javax.sound.midi.VoiceStatus;
import javax.xml.bind.annotation.XmlAccessOrder;

import org.xml.sax.SAXNotSupportedException;

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

 public static void main(String[] args){

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
  while(finalDestination() == false){
  System.out.println("Was soll passieren? (Befehl):");
  System.out.println("Beschleunigen = a");
  System.out.println("Entschleunigen = b");
  System.out.println("Türen öffnen/schließen = t");
  /*
   * Auf 100 beschleunigen
   * Den nächsten Banhof anfahren
   * ...
   * Die Befehle auch implementieren
   */
  
  Scanner scanner = new Scanner(System.in);
  scanner.useLocale(Locale.ENGLISH);

  String eingabe = scanner.next();
  
  scanner.close();

  switch(eingabe)
  {
   case "a": 
      anweisung_1;
      break; 
   case "b": 
      anweisung_2;
      break; 
   case "t": 
      anweisung_3;
       break; 
   default:
      System.out.println("");
  }
  
  if(a.equals("a")) {
   accelerate();
  }
  //SysOut aktuelle Position und Situation
 }
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
  
  int red = 239;
  for (int s = 0; s < 240; s++) {
   for (int i = s; i < 240; i++) {
    if (strecke[i] == true) {
     red = i;
     break;
    }
   }
    if(speed / 5 >= next_red_signal_in(s, red)) {
      deccelerate();
      if (speed == 0) {
       trainStation();
      }
     }
    else if ((speed / 5) + 1 <= next_red_signal_in(s, red)) {
     holdSpeed();
     }
    else {
     accelerate();
    }
    
  }
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

public static void holdSpeed() {
 t += 1;
}


public static void zeiterhoehung() {
 t++;
}

public static boolean areDoorsOpen() {
  
  if (doors == false) {
  return false;
} else {
  return true;
}
}

public static void openDoors() {
  
  if(doors == false){
  doors = true;
  t += 1;
}
}

public static void closeDoors() {
  if(doors == true){
    doors = false;
  t += 1;
  }
}

public static boolean finalDestination() {
  
  if((driven_distance - 1) == strecke.length) {
    return true;
  } else {
    return false;
  }
}

public static int next_signal_in(int stelle, final int obstacle1, final int obstacle2 ) {
  if (stelle < obstacle1) {
   return obstacle1 - stelle;
  }
  else {
   return obstacle2 - stelle;
  }
 }

public static boolean trainIsMoving() {
  if(speed == 0) {
    return false;
  } else {
    return true;
  }
}

public static int next_red_signal_in(int position, int red_signal) {
  return red_signal - position;
 }

public static int drivenDistance(int position) {
   return position;
}

public static void brakeWarning(int position) {
for (int s = position; s < 240; s++) {
    
    final int obstacle1 = 99;
    final int obstacle2 = 199;
    
    if (s == obstacle1 || s == obstacle2) {
      
     strecke[s] = true; // Bahnhof
     if (Math.random() >= 0.5) {
      ampel = false;// Ampel ist rot oder Haltestelle
      bahnhoefe[s] = false;
     } else {
      ampel = true; // Ampel ist gruen 
      strecke[s] = false;
     }
     
    } else {
     strecke[s] = false;
    }
}

for (int s = position; s < 240; s++) {
  while(strecke[s] == true) {
    s += 1;
  }
  
  // distanceTillTrainStation
  int dtts = s - position;
  
  //momentaner Bremsweg
  int mb = speed * 2 / 10;
  int bremsenIn = 0;
  
  
  //Kommenden Bremspunkt berechnen !!
  if(20 - speed / 5 == 0) {
    bremsenIn = dtts - speed / 5;
  } else {
    bremsenIn = 20 - speed / 5;
  }
  
  
  if(bremsenIn > 0) {
    System.out.println("Bremsen in " + bremsenIn + " wird empfohlen.");
  } else if(bremsenIn < 0){
    System.out.println("Bremspunkt verpasst für den nächsten Bahnhof.");
    brakeWarning(position);
  } else {
    System.out.println("Jetzt bremsen wird empfohlen.");
  }
}
}

public static void trainStation() {
  
  openDoors();
  t++;
  closeDoors();
  accelerate();
  
 }





























}