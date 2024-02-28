package motivazionaliBF;

import supportoBF.GenPair;

public class BandoDisRep {

  /* Elenca terne (x,y,z) di progetti, in cui x e' un progetto dell'area0, y uno
   * dell'area1 e z uno dell'area2. Ipotizzando che ogni area abbia lo stesso
   * numero di progetti, diciamo n, l'elenco e' costruito generando tutte le
   * disposizioni con ripetizione di 3 elementi presi tra gli n disponibili. Ad
   * esempio, la disposizione (1,1,1) individua una terna di progetti formata dal
   * primo progetto di ogni area. Invece, una disposizione (3,1,n) individua una
   * terna composta dal terzo progetto in area0, dal primo in area1 e dall'ultimo,
   * l'n-esimo, in area2.
   */
  public static void spazioStati(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, int[] a, int j, 
      int[] disposizione, int k) {
    if (j == k) {
      System.out.println(spazioStatiOut(area0, area1, area2, disposizione));
    } else {
      int i = 0;
      while (i < a.length) {
        disposizione[j] = a[i];
        swap(a, i, j);
        spazioStati(area0, area1, area2, a, j + 1, disposizione, k);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  /* Pubblica una terna di progetti. La singola componente dipende dal livello
   * nella disposizione al quale ci troviamo.                                   */
  public static String spazioStatiOut(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, int[] disposizione) {
    String risultato = "[";
    for (int i = 0; i < disposizione.length; i++)
      switch (i) {
      case 0:
        risultato += disposizione[i]+":"+area0[disposizione[i]].toString()+",";
        break;
      case 1:
        risultato += disposizione[i]+":"+area1[disposizione[i]].toString()+",";
        break;
      case 2:
        risultato += disposizione[i]+":"+area2[disposizione[i]].toString()+",";
        break;
      default:
      }
    return risultato.substring(0, risultato.length()-1) + "]";
  }

  /* Elenca terne soluzione, non "solo" disposizioni generiche con ripetizione.
   * Ogni soluzione e' un'istanza di a[0..k) la cui richiesta di finanziamento non
   * eccede finaziabileTotale.                                                     */
  public static void soluzioni(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, 
      int finanziabileTotale, 
      int[] a, int[] soluzione, int j, int k) {
    if (j == k) {
      System.out.print(soluzioniOut(area0, area1, area2, finanziabileTotale, soluzione));
    } else {
      int i = 0;
      while (i < a.length) {
        soluzione[j] = a[i];
        swap(a, i, j);
        soluzioni(area0, area1, area2, finanziabileTotale, a, soluzione, j + 1, k);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  /* Individua una soluzione. Accumula in richiestaTotale la somma dei
   * finanziamenti elencati in soluzione[0..soluzione.length). Se richiestaTotale
   * non e' eccessiva, rimanendo al di sotto di finanziabileTotale, siamo di
   * fronte ad una soluzione.                                                      */
  private static String soluzioniOut(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, 
      int finaziabileTotale, 
      int[] soluzione) {

    String risultato = "";

    /* La richiestaTotale e' la somma delle richieste dei progetti in
     * soluzione[0..soluzione.length).                                     */
    int richiestaTotale = 0;
    for (int i = 0; i < soluzione.length; i++)
      richiestaTotale += (i == 0) ? area0[soluzione[i]].pi0()
          : (i == 1) ? area1[soluzione[i]].pi0() : area2[soluzione[i]].pi0();

    if (0 <= richiestaTotale && richiestaTotale <= finaziabileTotale) {
      risultato = spazioStatiOut(area0, area1, area2, soluzione) + " con richiesta totale " + richiestaTotale + "<="
          + finaziabileTotale + ".\n";
    }

    return risultato;
  }

  /* Elenca terne risposta, ovvero soluzioni che migliorano l'utilita' dell'ultima
   * risposta trovata.                                                              */
  public static void risposta(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, 
      int finanziabileTotale, 
      int[] a, 
      int[] risposta, 
      int[] soluzione, int j, int k) {
    if (j == k) {
      System.out.print(rispostaOut(area0, area1, area2, finanziabileTotale, 
                             risposta, soluzione));
    } else {
      int i = 0;
      while (i < a.length) {
        soluzione[j] = a[i];
        swap(a, i, j);
        risposta(area0, area1, area2, finanziabileTotale, a, 
                                        risposta, soluzione, j + 1, k);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  /* Individua una risposta. */
  private static String rispostaOut(
      GenPair<Integer, Integer>[] area0, 
      GenPair<Integer, Integer>[] area1,
      GenPair<Integer, Integer>[] area2, 
      int finaziabileTotale, 
      int[] risposta, 
      int[] soluzione) {
    String risultato = "";

    /* Accumula in richiestaTotale la somma dei finanziamenti elencati in
     * soluzione[0..soluzione.length).                                       */
    int richiestaTotale = 0;
    for (int i = 0; i < soluzione.length; i++) {
      richiestaTotale += (i == 0) ? area0[soluzione[i]].pi0()
          : (i == 1) ? area1[soluzione[i]].pi0() : area2[soluzione[i]].pi0();
    }

    /*
     * Accumula in utilitaCorrente la somma delle utilita' dei singoli progetti
     * elencati in soluzione[0..soluzione.length).
     */
    int utilitaCorrente = 0;
    for (int i = 0; i < soluzione.length; i++) {
      utilitaCorrente += (i == 0) ? area0[soluzione[i]].pi1()
          : (i == 1) ? area1[soluzione[i]].pi1() : area2[soluzione[i]].pi1();
    }

    /*
     * Accumula in utilitaMaxAttuale la somma delle utilita' dei singoli progetti
     * elencati in risposta[0..risposta.length) che e' la migliore risposta trovata
     * sinora.
     */
    int utilitaMaxAttuale = 0;
    for (int i = 0; i < risposta.length; i++) {
      utilitaMaxAttuale += (i == 0) ? area0[risposta[i]].pi1()
          : (i == 1) ? area1[risposta[i]].pi1() : area2[risposta[i]].pi1();
    }

    /* Se richiestaTotale non e' eccessiva, rimanendo al di sotto di
     * finanziabileTotale, siamo di fronte a una nuova risposta quando
     * utilitaMaxAttuale e' inferiore a utilitaCorrente.                    */
    if (0 <= richiestaTotale && 
           richiestaTotale <= finaziabileTotale && 
                  utilitaMaxAttuale < utilitaCorrente) {

      for (int i = 0; i < soluzione.length; i++)
        risposta[i] = soluzione[i];

      risultato = spazioStatiOut(area0, area1, area2, risposta) + " nuova risposta con richiesta totale "
          + richiestaTotale + "<=" + finaziabileTotale + " e utilita' totale " + utilitaCorrente + ".\n";
    }
    return risultato;
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}