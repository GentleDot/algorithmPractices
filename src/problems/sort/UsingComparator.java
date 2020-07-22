package problems.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int scoreCompare = b.score - a.score;
        int nameCompare = a.name.compareTo(b.name);

        if (scoreCompare == 0) {
            return nameCompare;
        }
        return scoreCompare;
    }
}

class Checker2 implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int scoreCompare = b.score - a.score;
        int nameFirstCharCompare = a.name.toCharArray()[0] - b.name.toCharArray()[0];
        int nameCompare = a.name.chars().sum() - b.name.chars().sum();
        int lengthCompare = a.name.length() - b.name.length();

        if (scoreCompare == 0) {
            if (nameFirstCharCompare == 0) {
                return nameCompare;
            } else {
                return nameFirstCharCompare;
            }
        }
        return scoreCompare;
    }
}

public class UsingComparator {
    public static void main(String[] args) {
        /*String a = "aab";
        String b = "ab";

        System.out.println(a.compareTo(b)); // -1
        System.out.println(b.compareTo(a)); // 1
        */
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
