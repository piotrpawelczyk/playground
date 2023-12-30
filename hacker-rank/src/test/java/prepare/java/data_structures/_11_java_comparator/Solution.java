package prepare.java.data_structures._11_java_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-comparator/problem?isFullScreen=true

// Write your Checker class here

class Checker implements Comparator<Player> {
  @Override
  public int compare(final Player o1, final Player o2) {
    return Comparator.<Player, Integer>comparing(p -> p.score, Comparator.reverseOrder())
      .thenComparing(p -> p.name)
      .compare(o1, o2);
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for (int i = 0; i < n; i++) {
      player[i] = new Player(scan.next(), scan.nextInt());
    }
    scan.close();

    Arrays.sort(player, checker);
    for (int i = 0; i < player.length; i++) {
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}
