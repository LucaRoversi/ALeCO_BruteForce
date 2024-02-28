package testsBF;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import combinatoricaBF.*;

class DisposizioniRptTest {

  @Test
  void test21() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2 };
    int k = 1;
    DisposizioniRpt.risposte(a, new int[k], 0, k);
    System.out.println("---------------");
  }

  @Test
  void test22() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2 };
    int k = 2;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

  @Test
  void test31() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 1;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

  @Test
  void test32() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 2;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

  @Test
  void test33() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 3;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

//  @Test
  void test41() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 1;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

//  @Test
  void test42() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 2;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

//  @Test
  void test43() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 3;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }

//  @Test
  void test44() {
    DisposizioniRpt.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 4;
    System.out.println("---------------");
    DisposizioniRpt.risposte(a, new int[k], 0, k);
  }
}