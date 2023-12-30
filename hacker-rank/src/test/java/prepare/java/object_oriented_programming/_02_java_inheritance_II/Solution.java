// https://www.hackerrank.com/challenges/java-inheritance-2/problem?isFullScreen=true
package prepare.java.object_oriented_programming._02_java_inheritance_II;

//Write your code here
class Arithmetic {
  int add(int a, int b) {
    return a + b;
  }
}

class Adder extends Arithmetic {
}

public class Solution {
  public static void main(String[] args) {
    // Create a new Adder object
    Adder a = new Adder();

    // Print the name of the superclass on a new line
    System.out.println("My superclass is: " + a.getClass().getSuperclass().getSimpleName());

    // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
    System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
  }
}
