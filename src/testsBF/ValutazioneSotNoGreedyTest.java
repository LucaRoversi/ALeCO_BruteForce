package testsBF;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import motivazionaliBF.ValutazioneSot;
import supportoBF.GenPair;

class ValutazioneSotNoGreedyTest {

  static GenPair<Integer, Float>[] noGreedyTest = new GenPair[4];  

  /* Istanza su cui le due strategie greedy date non sono ottimali.  */
  public static void noGreedyTest() {
      noGreedyTest[ 0] = new GenPair<Integer, Float>( 2, 2.0f);
      noGreedyTest[ 1] = new GenPair<Integer, Float>( 5, 4.6f);
      noGreedyTest[ 2] = new GenPair<Integer, Float>( 4, 3.9f);
      noGreedyTest[ 3] = new GenPair<Integer, Float>( 2, 2.0f);
  }
  
  @Test
  void testBFSpazioStati() {
    noGreedyTest();
    System.out.println("%-----------------------------------");
    System.out.println(" Spazio degli stati di noGreedyTest.");
    boolean[] sottoinsieme = new boolean[noGreedyTest.length];
    ValutazioneSot.spazioStati(noGreedyTest, sottoinsieme, 0);
  }

  @Test
  void testBFSoluzioni() {
    noGreedyTest(); 
    System.out.println("%---------------------------------------------------------------------");
    System.out.println(" Tutte le soluzioni di noGreedyTest, ponendo a 9 la votazione massima.");
    boolean[] soluzione = new boolean[noGreedyTest.length];
    ValutazioneSot.soluzioni(noGreedyTest, 9, soluzione, 0);
  }

  @Test
  void testBFRisposta() {
    noGreedyTest(); // Test semplificato con 4 risposte
    System.out.println("%--------------------------------------------------------------------");
    System.out.println(" Risposta ottenuta da noGreedyTest, ponendo a 9 la votazione massima.");
    boolean[] risposta = new boolean[noGreedyTest.length];
    boolean[] soluzione = new boolean[noGreedyTest.length];
    ValutazioneSot.risposta(noGreedyTest, 9, risposta, soluzione, 0);
    System.out.println("Risposta: " + Arrays.toString(risposta));
  }
}