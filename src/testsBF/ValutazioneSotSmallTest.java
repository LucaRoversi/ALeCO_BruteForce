package testsBF;

import org.junit.jupiter.api.Test;

import motivazionaliBF.*;
import supportoBF.GenPair;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ValutazioneSotSmallTest {

  static GenPair<Integer, Float>[] smallTest = new GenPair[4];

  /* Istanza ridotta del test diriferimento. */
  public static void initSmall() {
    smallTest[0] = new GenPair<Integer, Float>( 4, 3.0f);
    smallTest[1] = new GenPair<Integer, Float>(10, 8.0f);
    smallTest[2] = new GenPair<Integer, Float>( 3, 1.5f);
    smallTest[3] = new GenPair<Integer, Float>( 2, 2.0f);
  }

//  @Test
  void testSpaceState() {
    initSmall();
    System.out.println("%-----------------------------------");
    System.out.println(" Spazio degli stati di smallTest.");
    boolean[] solution = new boolean[smallTest.length];
    ValutazioneSot.spazioStati(smallTest, solution, 0);
  }

  @Test
  void testSolutions() {
    initSmall(); 
    System.out.println("%--------------------------------");
    System.out.println(" Tutte le soluzioni di smallTest,");
    System.out.println(" ponendo a 13 la votazione massima.");
    boolean[] solution = new boolean[smallTest.length];
    ValutazioneSot.soluzioni(smallTest, 13, solution, 0);
  }

//  @Test
  void testAnswer() {
    initSmall(); // Test semplificato con 4 risposte
    System.out.println("%----------------------------------");
    System.out.println(" Risposta (answer) ottenuta da smallTest,");
    System.out.println(" ponendo a 13 la votazione massima.");
    boolean[] answer = new boolean[smallTest.length];
    boolean[] solution = new boolean[smallTest.length];
    ValutazioneSot.risposta(smallTest, 13, answer, solution, 0);
    System.out.println("Risposta: " + Arrays.toString(answer));
  }
}
