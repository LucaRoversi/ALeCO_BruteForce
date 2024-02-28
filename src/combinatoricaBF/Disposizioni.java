package combinatoricaBF;

/**
 * Dato un array a, ed un valore k, stampa tutte le disposizioni di k elementi
 * presi da un 'insieme' a di a.length elementi.
 * 
 * L'algoritmo e' una variazione di Permutazioni.risposte. 
 * Produce una risposta, quando la lunghezza della soluzione 
 * parziale s[0..j) coincide col limite k, ovvero j==k.
 */

public class Disposizioni {

  public static int count;

  public static void risposte(int[] a, int j, int k) {
    if (j == k) {
      System.out.println(toString(a, k) + " n.ro: " + (++count));
    } else {
      int i = j;
      while (i < a.length) {
        swap(a, i, j);
        risposte(a, j + 1, k);
        swap(a, i, j);
        i = i + 1;
      }
    }
  }

  private static String toString(int[] a, int k) {
    String risultato = "[";
    for (int i = 0; i < k; i++)
      risultato += a[i] + ", ";
    return risultato.substring(0, risultato.length() - 2) + "]";
  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
