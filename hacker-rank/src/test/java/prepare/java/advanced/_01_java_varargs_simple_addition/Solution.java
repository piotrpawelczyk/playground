// https://www.hackerrank.com/challenges/simple-addition-varargs/problem?isFullScreen=true
package prepare.java.advanced._01_java_varargs_simple_addition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Add {
  void add(int... ints) {
    System.out.println(
      IntStream.of(ints).mapToObj(Integer::toString).collect(Collectors.joining("+"))
      + "="
      + IntStream.of(ints).sum()
    );
  }
}


public class Solution {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      int n6 = Integer.parseInt(br.readLine());
      Add ob = new Add();
      ob.add(n1, n2);
      ob.add(n1, n2, n3);
      ob.add(n1, n2, n3, n4, n5);
      ob.add(n1, n2, n3, n4, n5, n6);
      Method[] methods = Add.class.getDeclaredMethods();
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
      e.printStackTrace();
    }
  }
}
