package prepare.java.data_structures._13_java_dequeue;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    int n = in.nextInt();
    int m = in.nextInt();

    var max = 0;
    var u = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();

      if (i >= m) {
        var r = deque.remove();
        if (!deque.contains(r)) u.remove(r);
      }

      deque.add(num);
      u.add(num);

      if (i >= m - 1) {
        max = Math.max(max, u.size());
      }
    }

    System.out.println(max);
  }
}
