package testsBF;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import combinatoricaBF.*;

class DisposizioniTest {

//  @Test
  void test21() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2 };
    int k = 1;
    Disposizioni.risposte(a, 0, 1);
    System.out.println("---------------");
  }

//  @Test
  void test22() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2 };
    int k = 2;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 2);
  }

//  @Test
  void test31() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 1;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 1);
  }

  @Test
  void test32() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 2;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 2);
  }

//  @Test
  void test33() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3 };
    int k = 3;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 3);
  }

//  @Test
  void test41() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 1;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 1);
  }

//  @Test
  void test42() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 2;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 2);
  }

//  @Test
  void test43() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 3;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 3);
  }

//  @Test
  void test44() {
    Disposizioni.count = 0;
    int[] a = new int[] { 1, 2, 3, 4 };
    int k = 4;
    System.out.println("---------------");
    Disposizioni.risposte(a, 0, 4);
  }
}