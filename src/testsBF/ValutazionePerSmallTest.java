package testsBF;

import org.junit.jupiter.api.Test;

import motivazionaliBF.ValutazionePer;
import supportoBF.GenPair;

class ValutazionePerSmallTest {

  /* Istanza ridotta del test di riferimento. */
  static GenPair<Integer, Float>[] smallTest = new GenPair[4];
  public static void initSmallTest() {
    smallTest[0] = new GenPair<Integer, Float>(2, 2.0f);
    smallTest[1] = new GenPair<Integer, Float>(3, 3.0f);
    smallTest[2] = new GenPair<Integer, Float>(3, 1.5f);
    smallTest[3] = new GenPair<Integer, Float>(10, 8.0f);
  }

  @Test 
  void testBFSpaceState() {
    initSmallTest();
    System.out.println("%---------------------------------");
    System.out.println(" Spazio degli stati per smallTest.");
    ValutazionePer.permutazioni(smallTest, 0);
  }

  @Test 
  void testBFSolutions() {
    initSmallTest();
    System.out.println("%-------------------------------------------------------------------");
    System.out.println(" Tutte le soluzioni di smallTest, ponendo a 13 la votazione massima.");
    ValutazionePer.soluzioni(smallTest, 13, 0);
  }

  @Test 
  void testBFAnswer() {
    initSmallTest();
    System.out.println("%---------------------------------------------------------------------------");
    System.out.println(" Risposta (answer) estratta da smallTest, ponendo a 13 la votazione massima.");
    /*
     * Il test peggiore possibile assegna votazione totale 0.
     */
    GenPair<Integer, Float>[] solution = new GenPair[1];
    solution[0] = new GenPair<Integer, Float>(0, 0.0f);
    System.out.println("Risposta: " 
       + ValutazionePer.spazioStatiOut(ValutazionePer.risposta(smallTest, 13, solution, 0)));
  }
}