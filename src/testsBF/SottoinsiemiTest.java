package testsBF;

import org.junit.jupiter.api.Test;

import combinatoricaBF.*;

class SottoinsiemiTest {

  @Test
  void test3() {
    Sottoinsiemi.sottoinsiemi(new int[] { 1, 2 });
    System.out.println("---------------");
  }
  @Test
  void test4() {
    Sottoinsiemi.sottoinsiemi(new int[] { 1, 2, 3, 4 });
    System.out.println("---------------");
  }
}