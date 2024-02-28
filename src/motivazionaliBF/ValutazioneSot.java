package motivazionaliBF;

import supportoBF.GenPair;

public class ValutazioneSot {

  /* Stampa tutti i sottoinsiemi delle risposte in a[0.. a.length). */
  public static void spazioStati(GenPair<Integer, Float>[] a, boolean[] sottoinsieme, int j) {
    if (j == a.length) {
      System.out.println(spazioStatiOut(a, sottoinsieme));
    } else {
      spazioStati(a, sottoinsieme, j + 1);
      sottoinsieme[j] = !sottoinsieme[j];
      spazioStati(a, sottoinsieme, j + 1);
      sottoinsieme[j] = !sottoinsieme[j];
    }
  }

  private static String spazioStatiOut(GenPair<Integer, Float>[] a, boolean[] sottoinsieme) {
    String s = "[";
    for (int i = 0; i < a.length; i++)
      s += (sottoinsieme[i] ? // include coppia
          "(" + a[i].pi0() + "," + a[i].pi1() + ")" : "" // esclude coppia
      );
    return s + "]";
  }

  /*
   * Stampa tutte le soluzioni, cioe' i sottoinsiemi di risposte che sono 
   * potenziali risposte: sottoinsiemi in grado di assegnare un voto massimo 
   * che non supera quello consentito.
   */
  public static void soluzioni(GenPair<Integer, Float>[] a, int votoMaxConsentito
      , boolean[] soluzione, int j) {
    if (j == a.length) {
      System.out.print(soluzioniOut(a, votoMaxConsentito, soluzione));
    } else {
      soluzioni(a, votoMaxConsentito, soluzione, j + 1);
      soluzione[j] = !soluzione[j];
      soluzioni(a, votoMaxConsentito, soluzione, j + 1);
      soluzione[j] = !soluzione[j];
    }
  }

  private static String soluzioniOut(GenPair<Integer, Float>[] a, int votoMaxConsentito, boolean[] soluzione) {
    /* Valore del votoMaxCorrente distribuito da soluzione[0..soluzione.length). 
     * Usa soluzione[i] per determinare il valore in a[i]. */
    int votoMaxCorrente = 0;
    for (int i = 0; i < soluzione.length; i++)
      votoMaxCorrente += (soluzione[i] ? a[i].pi0() : 0);

    /* Valore della votazioneCorrente distribuita da soluzione[0..soluzione.length). 
     * Usa soluzione[i] per determinare il valore in a[i]. */
    float votazioneCorrente = 0;
    for (int i = 0; i < soluzione.length; i++)
      votazioneCorrente += (soluzione[i] ? a[i].pi1() : 0);

    /* "Risultato" */
    String messaggio = "";
    if (votoMaxCorrente <= votoMaxConsentito) {
      messaggio = spazioStatiOut(a, soluzione)
          + " distribuisce voto max. " + votoMaxCorrente + " con votazione " + votazioneCorrente +".\n";
    }
    return messaggio;
  }

  /* Stampa le risposte. */
  public static void risposta(GenPair<Integer, Float>[] a, int votoMaxConsentito,
      boolean[] risposta, boolean[] soluzione,
      int j) {
    if (j == a.length) {
      System.out.print(rispostaOut(a, votoMaxConsentito, soluzione, risposta));
    } else {
      risposta(a, votoMaxConsentito, risposta, soluzione, j + 1);
      soluzione[j] = !soluzione[j];
      risposta(a, votoMaxConsentito, risposta, soluzione, j + 1);
      soluzione[j] = !soluzione[j];
    }
  }
  
  private static String rispostaOut(GenPair<Integer, Float>[] a, int votoMaxConsentito, boolean[] soluzione,
      boolean[] risposta) {

    /* Valore del votoMaxCorrente distribuito da soluzione[0..soluzione.length). 
     * Usa soluzione[i] per determinare il valore in a[i]. */
    int votoMaxCorrente = 0;
    for (int i = 0; i < soluzione.length; i++)
      votoMaxCorrente += (soluzione[i] ? a[i].pi0() : 0);

    /* Valore della votazioneCorrente distribuita da soluzione[0..soluzione.length). 
     * Usa soluzione[i] per determinare il valore in a[i]. */
    float votazioneCorrente = 0.0f;
    for (int i = 0; i < soluzione.length; i++)
      votazioneCorrente += (soluzione[i] ? a[i].pi1() : 0.0f);

    /* L'attuale migliore votazione e' fornita da risposta[0..risposta.length). 
     * La calcoliamo per confrontarla con votazioneCorrente fornita da
     * soluzione[0..soluzione.length).                                        */
    float attualeMiglioreVotazione = 0.0f;
    for (int i = 0; i < risposta.length; i++)
      attualeMiglioreVotazione += (risposta[i] ? a[i].pi1() : 0.0f);

    /* Se necessario, sostituisce l'attuale risposta[0..risposta.length) 
     * con soluzione[0..soluzione.length).                                       */
    String messaggio = "";
    if (votoMaxCorrente <= votoMaxConsentito && attualeMiglioreVotazione < votazioneCorrente) {
      for (int i = 0; i < risposta.length; i++)
        risposta[i] = soluzione[i];

      /* A titolo didattico, stampa la nuova risposta. */
      
      messaggio = "Nuova risposta " + spazioStatiOut(a, soluzione) + " che distribuisce voto max " 
          + votoMaxCorrente + " e assegna votazione " + votazioneCorrente + ".\n";
    }
    return messaggio;
  }
}