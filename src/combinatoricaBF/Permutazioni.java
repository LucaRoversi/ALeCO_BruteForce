package combinatoricaBF;

/**
 * Dato un array a, produce tutte le sue permutazioni.
 * */

import java.util.Arrays;

public class Permutazioni {

  /* L'array a contiene gli elementi di cui produrre le permutazioni.
   * Adottando la terminologia di Horowitz "Computer Algorithms":
   * - l'insieme di tutti i sottorami dell'intero albero e' lo 
   * spazio degli stati 
   * - l'insieme delle risposte e delle soluzioni coincide perche'
   * il nostro scopo e' generare tutte le permutazioni e ciascuna
   * delle permutazioni e' completa solo avendo completamente
   * percorso il ramo che individua quella permutazione.             */
  public static void risposte(int[] a, int j) {
    if (j == a.length) {
      System.out.println(Arrays.toString(a));
    } else {
      int i = j; // permutazioni dei restanti a.length-j elementi
      while (i < a.length) {
        swap(a, i, j);
        risposte(a, j + 1);
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