/** Generic Pair with the obvious constructor,
 * projections and toString methods.
 */
package supportoBF;

public class GenPair<A,B> {
  private A first; 
  private B second; 

  public GenPair(A r, B c) {
    first = r;
    second = c;
  }

  public A pi0() {return first;}
  
  public B pi1() {return second;}
  
  public String toString() {
    return "("+pi0()+","+pi1()+")";
  }

}
