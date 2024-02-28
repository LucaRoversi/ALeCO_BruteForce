package combinatoricaBF;

/**
 * Dato un array a, stampa tutte le permutazioni con 
 * ripetizione dei suoi elementi .
 *  
 * Rispetto a quanto fatto in Permutazioni.answer,
 * le ripetizioni si ottengono variando l'insieme
 * da cui pescare l'elemento a[j] per estendere 
 * a[0..j) in a[0..j+1).
 * Per ogni nuovo valore di j, a[j] appartiene as
 * a[0..a.length), non dall'intervallo a[j..a.length).
 * */

import java.util.Arrays;

public class PermutazioniRpt {

  /* L'array a contiene gli elementi di cui produrre le 
   * permutazioni. E' necessario un array di supporto s
   * in cui costruire la permutazione s[0..j). Senza
   * l'array s, si sovrascriverebbe s[0..j) ad ogni cambio 
   * di livello nella visita dell'albero degli stati.   */
  public static void risposte(int[] a, int[] soluzioni, int j) {
    if (j == a.length) {
      System.out.println(Arrays.toString(soluzioni));
    } else {
      /* Riparte da capo ad ogni livello ==> ripetizione */
      int i = 0;
      while (i < a.length) {
        soluzioni[j] = a[i];
        swap(a, i, j);
        risposte(a, soluzioni, j + 1);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}