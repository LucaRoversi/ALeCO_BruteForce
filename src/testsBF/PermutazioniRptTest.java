package testsBF;

import org.junit.jupiter.api.Test;

import combinatoricaBF.*;

class PermutazioniRptTest {

  @Test
  void test0() {
    System.out.println("---------------");
    int[] a = new int[] { 1, 2, 3, 4 };
    PermutazioniRpt.risposte(a, new int[a.length], 0);
  }
  
  @Test
  void test1() {
    System.out.println("---------------");
    int[] a = new int[] { 1, 2, 3 };
    PermutazioniRpt.risposte(a, new int[a.length], 0);
  }
  
  @Test
  void test2() {
    System.out.println("---------------");
    int[] a = new int[] { 1, 2 };
    PermutazioniRpt.risposte(a, new int[a.length], 0);
  }
}