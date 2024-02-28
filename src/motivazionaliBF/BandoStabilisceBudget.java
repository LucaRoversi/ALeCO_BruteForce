package motivazionaliBF;
import supportoBF.GenPair;

/** Qusta classe è da vedere come classe di utilità
 * per impostare correttyamente una istanza del
 * probelma "Bando", esempio di multiple-KP (MKP). 
 * Qui consideriamo una istanza di "Bando" relativa 
 * a tre aree di intervento. Per ciascuna area 
 * forniamo una lista di coppie (Utilità, Finanziamento 
 * richiesto) associate ad un progetto. 
 * 
 * La classe definisce il budget da mettere a 
 * disposizione per soddisfare le condizioni di 
 * consistenza di una qualsiasi istanza di MKP, 
 * a pagina 318 di Pisinger "Knapsack Problems".
 * Il valore "80" è il minimo budget da mettere a 
 * disposizione affinché tutte le richieste di 
 * finanziamento possano partecipare alla gare.     */
 
public class BandoStabilisceBudget {

  /* Ogni istanza di Pair è da leggere come
   * (Utilità, Finanziamento richiesto)
   * da parte di un progetto in una delle
   * tre aree possibili. */
  static GenPair<Integer,Integer>[][] areas = new GenPair[ 3][];
  static GenPair<Integer,Integer>[]   area0 = new GenPair[4];
  static GenPair<Integer,Integer>[]   area1 = new GenPair[4];
  static GenPair<Integer,Integer>[]   area2 = new GenPair[4];

  public static void init() {
    areas[0] = area0;
    areas[1] = area1;
    areas[2] = area2;

    area0[ 0] = new GenPair<Integer, Integer>( 8, 10);
    area0[ 1] = new GenPair<Integer, Integer>(10, 43);
    area0[ 2] = new GenPair<Integer, Integer>(20, 51);
    area0[ 3] = new GenPair<Integer, Integer>(22, 63);
    area1[ 0] = new GenPair<Integer, Integer>(11, 39);
    area1[ 1] = new GenPair<Integer, Integer>(21, 12);
    area1[ 2] = new GenPair<Integer, Integer>(0,  0);
    area1[ 3] = new GenPair<Integer, Integer>(0,  0);
    area2[ 0] = new GenPair<Integer, Integer>( 8, 27);
    area2[ 1] = new GenPair<Integer, Integer>(10,  9);
    area2[ 2] = new GenPair<Integer, Integer>(20, 47);
    area2[ 3] = new GenPair<Integer, Integer>(0,  0);
        
//    area0[ 0] = new GenPair<Integer, Integer>(10,  8);
//    area0[ 1] = new GenPair<Integer, Integer>(43, 10);
//    area0[ 2] = new GenPair<Integer, Integer>(51, 20);
//    area0[ 3] = new GenPair<Integer, Integer>(63, 22);
//    area0[ 4] = new GenPair<Integer, Integer>(32, 30);
//    area0[ 5] = new GenPair<Integer, Integer>(13, 42);
//    area0[ 6] = new GenPair<Integer, Integer>(65, 47);
//    area0[ 7] = new GenPair<Integer, Integer>(48, 53);
//    area0[ 8] = new GenPair<Integer, Integer>(76, 57);
//    area0[ 9] = new GenPair<Integer, Integer>(22, 41);
//    area0[10] = new GenPair<Integer, Integer>(65, 41);
//    area1[0] = new GenPair<Integer, Integer>(39, 22);
//    area1[1] = new GenPair<Integer, Integer>(12, 21);
//    area1[2] = new GenPair<Integer, Integer>(41, 23);
//    area1[3] = new GenPair<Integer, Integer>(80, 32);
//    area1[4] = new GenPair<Integer, Integer>(60, 57);
//    area1[5] = new GenPair<Integer, Integer>(28, 53);
//    area1[6] = new GenPair<Integer, Integer>(60, 72);
//    area1[7] = new GenPair<Integer, Integer>(29, 76);
//    area2[0] = new GenPair<Integer, Integer>(27, 8);
//    area2[1] = new GenPair<Integer, Integer>( 9, 10);
//    area2[2] = new GenPair<Integer, Integer>(47, 20);
//    area2[3] = new GenPair<Integer, Integer>(16, 26);
//    area2[4] = new GenPair<Integer, Integer>(60, 34);
//    area2[5] = new GenPair<Integer, Integer>(13, 52);
//    area2[6] = new GenPair<Integer, Integer>(41, 52);
//    area2[7] = new GenPair<Integer, Integer>(33, 72);
//    area2[8] = new GenPair<Integer, Integer>(68, 72);
  }

  public static int minWeight(GenPair<Integer,Integer>[] area) {
    int min = area[0].pi0();
    for (int i = 1; i < area.length; i++)
      if (min > area[i].pi0())
        min = area[i].pi0();
    return min;
  }

  public static int sumMinWeights(GenPair<Integer,Integer>[][] areas) {
    int sum = 0;
    for (int i = 0; i < areas.length; i++)
      sum = sum + minWeight(areas[i]);
    return sum;
  }

  /* Per il budget fissato, elenca quali progetti dovrebbero
   * essere esclusio dalla gara perché inconsistenti con la 
   * modellazione di un MCKP.                                */
  public static String listOutOfBudget(int budget, GenPair<Integer,Integer>[][] areas) {
    String u = "Given the budget " + budget + ",\n";
    // Per ogni area
    for (int area = 0; area < areas.length; area++) {
      u += "-) from area " + area + " discard proposals: ";

      int sumMinAreas = 0;
      // Calcola la somma delle minime richieste di finanziamento
      // nelle altre aree...
      for (int h = 0; h < areas.length; h++)
        if (h != area)
          sumMinAreas = sumMinAreas + minWeight(areas[h]);
      
      // Elenca i progetti della data area che, assieme ai meno
      // costosi delle aree rimanenti, sfonderebbe il budget.
      for (int proposal = 0; proposal < areas[area].length; proposal++) {
        if (areas[area][proposal].pi0() > budget)
          u += proposal + ", ";
      }
      u = u.substring(0, u.length() - 2) + ".\n";
    }
    return u;
  }

  public static int maxWeight(GenPair<Integer,Integer>[] area) {
    int max = area[0].pi0();
    for (int i = 1; i < area.length; i++)
      if (max < area[i].pi0())
        max = area[i].pi0();
    return max;
  }

  public static int sumMaxWeights(GenPair<Integer,Integer>[][] areas) {
    int sum = 0;
    for (int i = 0; i < areas.length; i++)
      sum = sum + maxWeight(areas[i]);
    return sum;
  }

  public static void main(String[] args) {
    init();
    System.out.println(
        "Il budget distribuibile deve essere compreso tra " + sumMinWeights(areas) + " e " + sumMaxWeights(areas));

    for (int budget = 10; budget <= 22; budget++)
      System.out.println(listOutOfBudget(budget, areas));
  }
}