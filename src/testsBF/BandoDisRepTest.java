package testsBF;

import org.junit.jupiter.api.Test;

import motivazionaliBF.*;
import supportoBF.GenPair;

class BandoDisRepTest {

  /* Gli array area0, area1 ed area2 contengono gli indici dei progetti. 
   * L'ipotesi e' che gli elenchi di progetti di tutte le aree abbiano 
   * la stessa lunghezza. In caso contrario, si aggiungono progetti 
   * fittizi ( 0, Integer.MIN_VALUE): avendo utilita' minima non  
   * saranno mai considerati perche' non concorrono a massimizzare 
   * quanto richiesto.                                               */
  public static GenPair<Integer, Integer>[] area0 = new GenPair[4];
  public static void area0() {
    area0[ 0] = new GenPair<Integer, Integer>( 8, 10);
    area0[ 1] = new GenPair<Integer, Integer>(10, 43);
    area0[ 2] = new GenPair<Integer, Integer>(20, 51);
    area0[ 3] = new GenPair<Integer, Integer>(22, 63);
  }
  
  public static GenPair<Integer, Integer>[] area1 = new GenPair[4];
  public static void area1() {
    area1[ 0] = new GenPair<Integer, Integer>(11, 39);
    area1[ 1] = new GenPair<Integer, Integer>(21, 12);
    area1[ 2] = new GenPair<Integer, Integer>( 0, Integer.MIN_VALUE);
    area1[ 3] = new GenPair<Integer, Integer>( 0, Integer.MIN_VALUE);
  }

  public static GenPair<Integer, Integer>[] area2 = new GenPair[4];
  public static void area2() {
    area2[ 0] = new GenPair<Integer, Integer>( 8, 27);
    area2[ 1] = new GenPair<Integer, Integer>(10,  9);
    area2[ 2] = new GenPair<Integer, Integer>(20, 47);
    area2[ 3] = new GenPair<Integer, Integer>( 0, Integer.MIN_VALUE);
  }

  @Test
  void testSpazioStati() {
    area0();
    area2();
    area1();
    final int numeroAreeIntervento = 3; 

    /* L'array a contiene i "nomi" progetti di ciascuna area,
     * ovvero gli indici con cui identificare i progetti nelle
     * varie aree.                                                     */
    int[] a = new int[area0.length];
    for (int i = 0; i < area0.length; i++)
      a[i] = i;
    
    /* L'array disposizione contiene una disposizione con ripetizioni
     * di 3 elementi, perche' tante sono le aree. Gli elementi sono 
     * presi da una collezione di area0.length (o area1.length, o 
     * area2.length) elementi.                                        */
    int[] disposizione = new int[numeroAreeIntervento];
    System.out.println("-------------- Spazio degli stati ");
    BandoDisRep.spazioStati(area0, area1, area2, a, 0, 
                                  disposizione, numeroAreeIntervento);
  }

  @Test
  void testSoluzioni() {
    area0();
    area2();
    area1();
    final int numeroAreeIntervento = 3; // numero delle aree di intervento

    /* L'array a contiene i "nomi" progetti di ciascuna area,
     * ovvero gli indici con cui identificare i progetti nelle
     * varie aree.                                                     */
    int[] a = new int[area0.length];
    for (int i = 0; i < area0.length; i++)
      a[i] = i;

    int finanziabileTotale = 40;

    /* L'array soluzione contiene le disposizioni con ripetizione di k elementi,
     * che possono essere soluzione, ovvero la cui somma dei finanziamenti richiesti 
     * non supera il valore del finanziabileTotale.                                   */
    int[] soluzione = new int[numeroAreeIntervento];
    System.out.println("-------------- Soluzioni ");
    BandoDisRep.soluzioni(area0, area1, area2, finanziabileTotale, a, soluzione, 0, numeroAreeIntervento);
  }

@Test
  void testRisposta() {
    area0();
    area2();
    area1();
    final int numeroAreeIntervento = 3; // numero delle aree di intervento

    /* L'array a contiene i "nomi" progetti di ciascuna area,
     * ovvero gli indici con cui identificare i progetti nelle
     * varie aree.                                                     */
    int[] a = new int[area0.length];
    for (int i = 0; i < area0.length; i++)
      a[i] = i;

    int finanziabileTotale = 40;

    /* L'array soluzione contiene una delle disposizioni con ripetizione di k elementi,
     * che puo' essere soluzione, ovvero la cui somma dei finanziamenti richiesti 
     * non supera il valore del finanziabileTotale.                                   */
    int[] soluzione = new int[numeroAreeIntervento];
    
    /* L'array risposta contiene la soluzione con la massima utilita'.                */
    int[] risposta  = new int[numeroAreeIntervento];
    System.out.println("-------------- Risposta ");
    BandoDisRep.risposta(area0, area1, area2, finanziabileTotale, a, 
                                  risposta, soluzione, 0, numeroAreeIntervento);
    System.out.println(" Risposta " + BandoDisRep.spazioStatiOut(area0, area1, area2, risposta));
  }
}
