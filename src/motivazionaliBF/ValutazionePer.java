package motivazionaliBF;

import supportoBF.GenPair;

public class ValutazionePer {
  
  /* Stampa lo spazio degli stati, ovvero le permutazioni degli elementi
   * in a[0..a.length). */
  public static void permutazioni(GenPair<Integer, Float>[] a, int j) {
    if (j == a.length) {
      System.out.println(spazioStatiOut(a));
    } else {
      int i = j;
      while (i < a.length) {
        swap(a, j, i);
        permutazioni(a, j + 1);
        swap(a, j, i);
        i = i + 1;
      }
    }
  }
  
  public static String spazioStatiOut(GenPair<Integer, Float>[] a) {
    String s = "[";
    for (int i = 0; i < a.length; i++)
      s += "(" + a[i].pi0() + "," + a[i].pi1() + ")";
    return s + "]";
  }

  /* Individua lo spazio delle soluzioni come spazio dei prefissi delle permutazioni 
   * degli elementi inizialmente in a[0.. a.length):
   * per ogni permutazione p, cerca il prefisso piu' lungo il cui votoMaxDistribuito 
   * non sia maggiore del votoMaxConsentito. Quindi, determina la votazione che
   * il prefisso assegna.                                                         */
  public static void soluzioni(GenPair<Integer, Float>[] a, int votoMaxConsentito, int j) {
    if (j == a.length) {
      System.out.println(soluzioniOut(a,votoMaxConsentito));
    } else {
      int i = j;
      while (i < a.length) {
        swap(a, j, i);
        soluzioni(a, votoMaxConsentito, j + 1);
        swap(a, j, i);
        i = i + 1;
      }
    }
  }

  /* Per ogni permutazione p degli elementi inizialmente in a[0.. a.length), 
   * cerca il prefisso piu' lungo il cui votoMaxDistribuito 
   * non sia maggiore del votoMaxConsentito. Quindi, determina la votazione che
   * il prefisso assegna.                                                         */
  private static String soluzioniOut(GenPair<Integer, Float>[] a, int votoMaxConsentito) {

    /* Segmento iniziale di a[0..a.length) il cui voto massimo distribuito, 
     * indicato da votoMaxCorrente, non supera votoMaxConsentito.          
     * Quindi, il segmento iniziale e' una soluzione.                        */
    int votoMaxCorrente = 0;
    boolean oltreVotoMaxConsentito = false;
    int lunghezzaSoluzione = 0;
    while (lunghezzaSoluzione < a.length && !oltreVotoMaxConsentito) {
      /* Se, votoMaxCorrente sommato al nuovo voto a[lunghezzaSoluzione].pi0() 
       * non sfora votoMax, allora aggiorna votoMaxCorrente. */
      oltreVotoMaxConsentito = (votoMaxCorrente + a[lunghezzaSoluzione].pi0()) > votoMaxConsentito;
      if (!oltreVotoMaxConsentito) {
        votoMaxCorrente += a[lunghezzaSoluzione].pi0();
        lunghezzaSoluzione = lunghezzaSoluzione + 1;
      }
    }
    /* Il prefisso individuato, cioe' la soluzione, e' a[0..lunghezzaSoluzione). */

    /* Votazione che la soluzione a[0..lunghezzaSoluzione) assegna. */
    float votazioneCorrente = 0.0f;
    for (int i = 0; i < lunghezzaSoluzione; i++)
      votazioneCorrente += a[i].pi1();

    /* "Pretty-printing" de:
     * i) permutazione a[0..a.length) esaminata;
     * ii) soluzione a[0..lunghezzaSoluzione) in a[0..a.length);
     * iii) voto massimo votoMaxCorrente fornita dalla soluzione a[0..lunghezzaSoluzione);
     * iv) votazione votazioneCorrente fornita dalla soluzione a[0..lunghezzaSoluzione). */
    return spazioStatiOut(a)
        + " ha una soluzione in a[0.." + lunghezzaSoluzione + ")"
        + " con voto max " + votoMaxCorrente + " e votazione " + votazioneCorrente 
        + ".";    
  }

  /*
   * Stampa la prima delle liste di migliori risposte date, enumerando tutte le
   * permutazioni possibili degli elementi inizialmente in test[0..test.length).
   * Esse si ricavano: i) generando tutte le permutazioni di test[0..test.length)
   * iniziale; ii) per ognuna di tali permutazioni P: ii.1) cercando un indice
   * currentLimit tale che il punteggio totale prodotto da P non superi il massimo
   * consentito; ii.2) confrontando il voto che P assegna ed il miglior voto
   * assegnato fino a quel punto da una qualche permutazione di
   * test[0..test.length) iniziale, visitata prima di P.
   */
  public static GenPair<Integer, Float>[] risposta(GenPair<Integer, Float>[] a, float votoMaxConsentito,
      GenPair<Integer, Float>[] risposta, int j) {

    if (j == a.length) {
      return rispostaOut(a, votoMaxConsentito, risposta);
    } else {
      int i = j;
      while (i < a.length) {
        swap(a, j, i);
        risposta = risposta(a, votoMaxConsentito, risposta, j + 1);
        swap(a, j, i);
        i = i + 1;
      }
      return risposta;
    }
  }

  /* Per ogni permutazione p degli elementi inizialmente in a[0.. a.length):
   * i) cerca il prefisso q di p piu' lungo il cui votoMaxDistribuito non sia maggiore del votoMaxConsentito;
   * ii) determina la votazione che q assegna;
   * iii) calcola sia la votazioneCorrente ricavabile da q, sia l'attualeMiglioreVotazione, disponibile
   * in risposta[0..risposta.length). 
   * iv) Sostituisce risposta[0..risposta.length) con q se attualeMiglioreVotazione < votazioneCorrente. */ 
 private static GenPair<Integer, Float>[] rispostaOut(GenPair<Integer, Float>[] a, float votoMaxConsentito,
      GenPair<Integer, Float>[] risposta) {

    /* Segmento iniziale di a[0..a.length) il cui voto massimo distribuito, 
     * indicato da votoMaxCorrente, non supera votoMaxConsentito.          
     * Quindi, il segmento iniziale e' una soluzione.                        */
    int votoMaxCorrente = 0;
    boolean oltreVotoMax = false;
    int lunghezzaSoluzione = 0;
    while (lunghezzaSoluzione < a.length && !oltreVotoMax) {
      /* Se, votoMaxCorrente sommato al nuovo voto a[lunghezzaSoluzione].pi0() 
       * non sfora votoMax, allora aggiorna votoMaxCorrente. */
      oltreVotoMax = (votoMaxCorrente + a[lunghezzaSoluzione].pi0()) > votoMaxConsentito;
      if (!oltreVotoMax) {
        votoMaxCorrente += a[lunghezzaSoluzione].pi0();
        lunghezzaSoluzione = lunghezzaSoluzione + 1;
      }
    }
    /* Il prefisso individuato, cioe' la soluzione, e' a[0..lunghezzaSoluzione). */

    /* Votazione che la soluzione a[0..lunghezzaSoluzione) assegna. */
    float votazioneCorrente = 0.0f;
    for (int i = 0; i < lunghezzaSoluzione; i++)
      votazioneCorrente += a[i].pi1();

    /* L'attuale migliore votazione e' fornita da risposta[0..risposta.length). 
     * La calcoliamo per confrontarla con votazioneCorrente fornita da
     * a[0..lunghezzaSoluzione).                                        */
    float attualeMiglioreVotazione = 0.0f;
    for (int i = 0; i < risposta.length; i++)
      attualeMiglioreVotazione += risposta[i].pi1();

    /* Se necessario, sostituisce l'attuale risposta[0..risposta.length) 
     * con a[0..lunghezzaSoluzione).                                       */
    GenPair<Integer, Float>[] nuovaRisposta = null;
    if (attualeMiglioreVotazione < votazioneCorrente) {
      nuovaRisposta = new GenPair[lunghezzaSoluzione];
      for (int i = 0; i < lunghezzaSoluzione; i++)
        nuovaRisposta[i] = a[i];
      risposta = nuovaRisposta;

      // Segnala (per motivi didattici) l'aggiornamento della soluzione.    
      System.out.print(spazioStatiOut(risposta));
      System.out.print(" ha una nuova risposta in a[0.." 
      + risposta.length + ").\n");
    }
    return risposta;
  }

  private static void swap(GenPair<Integer, Float>[] a, int i, int j) {
    GenPair<Integer, Float> tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}