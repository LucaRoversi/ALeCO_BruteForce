package testsBF;

import org.junit.jupiter.api.Test;

import combinatoricaBF.*;

class PermutazioniTest {

  @Test
  void test2() {
    Permutazioni.risposte(new int[] { 1, 2 }, 0);
    System.out.println("---------------");
  }

  @Test
  void test3() {
    Permutazioni.risposte(new int[] { 1, 2, 3 }, 0);
    System.out.println("---------------");
  }

  @Test
  void test4() {
    Permutazioni.risposte(new int[] { 1, 2, 3, 4 }, 0);
    System.out.println("---------------");
  }
}
