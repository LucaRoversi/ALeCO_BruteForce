package testsBF;

import org.junit.jupiter.api.Test;

import motivazionaliBF.ValutazionePer;
import supportoBF.GenPair;

class ValutazionePerNoGreedyTest {

  /* Istanza del problema Valutazione 
   * su cui le due strategie greedy descritte non sono ottimali. */
  public static GenPair<Integer, Float>[] noGreedyTest = new GenPair[4];
  public static void initNoGreedyTest() {
    noGreedyTest[0] = new GenPair<Integer, Float>(2, 2.0f);
    noGreedyTest[1] = new GenPair<Integer, Float>(5, 4.6f);
    noGreedyTest[2] = new GenPair<Integer, Float>(4, 3.9f);
    noGreedyTest[3] = new GenPair<Integer, Float>(2, 2.0f);
  }

  @Test
  void testBFPermutazioni() {
    initNoGreedyTest(); // Test semplificato con 4 risposte su cui greedy non funzionano
    System.out.println("%--------------------------------------------");
    System.out.println("Tutte le permutazioni generabili da noGreedyTest.");
    ValutazionePer.permutazioni(noGreedyTest, 0);
  }

  @Test
  void testBFSoluzioni() {
    initNoGreedyTest(); // Test semplificato con 4 risposte su cui greedy non funzionano
    System.out.println("%---------------------------------------------------------------------");
    System.out.println("Tutte le soluzioni di noGreedyTest, ponendo a 9 la votazione massima.");
    ValutazionePer.soluzioni(noGreedyTest, 9, 0);
  }

  @Test
  void testBFRisposta() {
    initNoGreedyTest(); // Test semplificato con 4 risposte su cui greedy non funzionano
    System.out.println("%--------------------------------------------------------------------");
    System.out.println("Risposta estratta da noGreedyTest, ponendo a 9 la votazione massima.");
    /* Il test peggiore possibile assegna votazione totale 0. */
    GenPair<Integer, Float>[] soluzione = new GenPair[1];
    soluzione[0] = new GenPair<Integer, Float>(0, 0.0f);
    System.out.println("Risposta: " 
    + ValutazionePer.spazioStatiOut(ValutazionePer.risposta(noGreedyTest, 9, soluzione, 0)));
  }
}