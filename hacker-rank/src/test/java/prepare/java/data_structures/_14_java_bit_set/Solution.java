package prepare.java.data_structures._14_java_bit_set;

import java.util.*;

// https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var N = scanner.nextInt();
      var M = scanner.nextInt();

      var AB = new BitSet[]{new BitSet(N), new BitSet(N)};

      while (M-- > 0) {
        op(AB, scanner.next(), scanner.nextInt(), scanner.nextInt());
        System.out.print(AB[0].cardinality() + " " + AB[1].cardinality());
        System.out.println();
      }
    }
  }

  private static void op(final BitSet[] AB, final String op, final int a1, final int a2) {
    switch (op) {
      case "AND":
        AB[a1 - 1].and(AB[a2 - 1]);
        break;
      case "OR":
        AB[a1 - 1].or(AB[a2 - 1]);
        break;
      case "XOR":
        AB[a1 - 1].xor(AB[a2 - 1]);
        break;
      case "FLIP":
        AB[a1 - 1].flip(a2);
        break;
      case "SET":
        AB[a1 - 1].set(a2);
        break;
    }
  }
}
