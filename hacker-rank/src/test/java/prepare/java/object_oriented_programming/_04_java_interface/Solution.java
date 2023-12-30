// https://www.hackerrank.com/challenges/java-interface/problem?isFullScreen=true
package prepare.java.object_oriented_programming._04_java_interface;

import java.util.Scanner;

interface AdvancedArithmetic {
  int divisor_sum(int n);
}

//Write your code here
class MyCalculator implements AdvancedArithmetic {
  @Override
  public int divisor_sum(final int n) {
    if (n == 1) return 1;
    
    var ds = 1;
    for (var d = 2; d <= n / 2; d++) {
      if (n % d == 0) ds += d;
    }
    return ds + n;
  }
}


public class Solution {
  public static void main(String[] args) {
    MyCalculator my_calculator = new MyCalculator();
    System.out.print("I implemented: ");
    ImplementedInterfaceNames(my_calculator);
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(my_calculator.divisor_sum(n) + "\n");
    sc.close();
  }

  /*
   *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
   */
  static void ImplementedInterfaceNames(Object o) {
    Class[] theInterfaces = o.getClass().getInterfaces();
    for (int i = 0; i < theInterfaces.length; i++) {
      String interfaceName = theInterfaces[i].getSimpleName();
      System.out.println(interfaceName);
    }
  }
}

