package combinatoricaBF;

/**
 * Dato un array a, ed un valore k, stampa 
 * tutte le disposizioni con ripetizioni 
 * formate da k elementi presi da un 'insieme' 
 * a di a.length elementi. 
 * 
 * 
 * Rispetto a quanto fatto in Disposizioni.answer,
 * le ripetizioni si ottengono variando l'insieme
 * da cui pescare l'elemento a[j] per estendere 
 * a[0..j) in a[0..j+1).
 * Per ogni nuovo valore di j, a[j] appartiene as
 * a[0..a.length), non dall'intervallo a[j..a.length). */

public class DisposizioniRpt {

  public static int count;

  /*
   * L'array a contiene gli elementi di cui produrre le disposizioni. E'
   * necessario un array di supporto s in cui costruire la permutazione s[0..j).
   * Senza l'array s, si sovrascriverebbe s[0..j) ad ogni cambio di livello nella
   * visita dell'albero degli stati.
   */

  public static void risposte(int[] a, int[] soluzione, int j, int k) {
    if (j == k) {
      System.out.println(toString(soluzione, k) + " n.ro: " + ++count);
    } else {
      /* Da capo ad ogni livello ==> ripetizione */
      int i = 0;
      while (i < a.length) {
        soluzione[j] = a[i];
        swap(a, i, j);
        risposte(a, soluzione, j + 1, k);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  private static String toString(int[] risposta, int k) {
    String risultato = "[";
    for (int i = 0; i < k; i++)
      risultato += risposta[i] + ", ";
    return risultato.substring(0, risultato.length() - 2) + "]";
  }

 public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}