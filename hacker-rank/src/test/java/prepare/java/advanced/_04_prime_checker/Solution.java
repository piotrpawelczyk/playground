// https://www.hackerrank.com/challenges/prime-checker/problem?isFullScreen=true
package prepare.java.advanced._04_prime_checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.in;

class Prime {
  private static final int CERTAINTY = 2 ^ 7;

  void checkPrime(int... ints) {
    var toPrint = IntStream.of(ints)
      .mapToObj(BigInteger::valueOf)
      .filter(i -> i.compareTo(BigInteger.ONE) != 0 && i.isProbablePrime(CERTAINTY))
      .map(Object::toString)
      .collect(Collectors.joining(" ", "", " "));
    System.out.println(toPrint);
  }
}

public class Solution {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());

      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
