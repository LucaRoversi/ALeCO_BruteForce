package testsBF;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import motivazionaliBF.*;
import supportoBF.GenPair;

class RischioSotTest {

  static GenPair<Integer, GenPair<Float, Float>>[] test = new GenPair[5];

  @Test
  void test() {
    initSmall();
    RischioSotFARE.rischio(test, 3.0f, 0.5f);
  }

  /* Istanza ridotta del test di riferimento. */
  public static void initSmall() {
    test[0] = new GenPair<Integer,GenPair<Float,Float>>( 8, new GenPair<Float,Float>(0.2f , 40.0f));
    test[1] = new GenPair<Integer,GenPair<Float,Float>>(10, new GenPair<Float,Float>(0.2f , 50.0f));
    test[2] = new GenPair<Integer,GenPair<Float,Float>>(20, new GenPair<Float,Float>(0.75f, 26.5f));
    test[3] = new GenPair<Integer,GenPair<Float,Float>>(22, new GenPair<Float,Float>(0.5f , 44.0f));
    test[4] = new GenPair<Integer,GenPair<Float,Float>>(30, new GenPair<Float,Float>(0.5f , 60.0f));
  }
}
