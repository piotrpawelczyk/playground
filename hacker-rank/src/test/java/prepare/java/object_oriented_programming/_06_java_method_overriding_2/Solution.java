// https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem?isFullScreen=true
package prepare.java.object_oriented_programming._06_java_method_overriding_2;

class BiCycle {
  String define_me() {
    return "a vehicle with pedals.";
  }
}

class MotorCycle extends BiCycle {
  String define_me() {
    return "a cycle with an engine.";
  }

  MotorCycle() {
    System.out.println("Hello I am a motorcycle, I am " + define_me());

    String temp = super.define_me(); //Fix this line

    System.out.println("My ancestor is a cycle who is " + temp);
  }

}

public class Solution {
  public static void main(String[] args) {
    MotorCycle M = new MotorCycle();
  }
}
