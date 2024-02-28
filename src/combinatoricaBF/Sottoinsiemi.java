package combinatoricaBF;

/**
 * Dato un array a, elenca tutti i suoi sottoinsiemi.
 */

public class Sottoinsiemi {

  /* Sottoinsiemi di tutti gli elementi in a. */
  public static void sottoinsiemi(int[] a) {
    risposta(a, new boolean[a.length], 0);
  }

  /* L'array a contiene gli elementi di cui elencare i 
   * sottoinsiemi. L'array s contiene via via le funzioni 
   * caratteristiche dei sottoinsiemi di a. Ogni soluzione, e,
   * quindi ogni risposta, e' una di queste funzioni caratteristiche; 
   * ciascuna di esse si ottiene quando a e' riempita in tutta 
   * la sua lunghezza.                                               */
  public static void risposta(int[] a, boolean[] risposta, int j) {
    if (j == a.length) {
      System.out.println(toString(a, risposta));
    } else {
      risposta(a, risposta, j + 1);
      risposta[j] = !risposta[j];
      risposta(a, risposta, j + 1);
      risposta[j] = !risposta[j];
    }
  }

  private static String toString(int[] a, boolean[] risposta) {
    String risultato = "[";
    for (int i = 0; i < a.length; i++)
      risultato += (risposta[i] ? a[i] : "");
    return risultato + "]";
  }
}