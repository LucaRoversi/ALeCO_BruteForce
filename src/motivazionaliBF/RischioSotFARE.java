package motivazionaliBF;

import java.util.Arrays;

import supportoBF.*;

public class RischioSotFARE {
  public static void rischio(GenPair<Integer, GenPair<Float, Float>>[] a, float guadagno, float rischio) {
    answer(a, guadagno, rischio, new boolean[a.length], 0);
  }

  public static void answer(GenPair<Integer, GenPair<Float, Float>>[] a, float guadagno, float rischio, boolean[] s,
      int j) {
    if (j == s.length) {
      System.out.println(toString(a, s));
    } else {
      s[j] = false;
      answer(a, guadagno, rischio, s, j + 1);
      s[j] = true;
      answer(a, guadagno, rischio, s, j + 1);
    }
  }

  private static String toString(GenPair<Integer, GenPair<Float, Float>>[] a, boolean[] s) {
    String r = "[";
    for (int i = 0; i < s.length; i++) {
      r += s[i] ? "("+a[i].pi0()+","+(a[i].pi1()).pi0()+","+(a[i].pi1()).pi1()+")" : "";
    }
    return r + "]";
  }
}