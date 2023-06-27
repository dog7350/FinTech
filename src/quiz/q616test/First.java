package quiz.q616test;

import prt.ObjectPrint;

import java.util.*;

public class First {
    public void Building() {
        ObjectPrint o = new ObjectPrint();
        Scanner sc = new Scanner(System.in);
        // 아스키 코드, 변수, IF, Switch, 3항, While, For

        o.prt((Object) "TestCase : ");
        int tc = sc.nextInt();
        o.prt((Object) "부지의 크기 : ");
        int gr = sc.nextInt();
        o.prt((Object) "최고 높이 : ");
        int fl = sc.nextInt();

        char[][] apt = new char[gr][gr];
        int[][] answer = new int[gr][gr];

        for (int i = 0; i < gr; i++) {
            String line = sc.next();
            apt[i] = line.toCharArray();
        }

        for (int i = 0; i < gr; i++) {
            for (int j = 0; j < gr; j++) {
                answer[i][j] = forest(apt, i, j, gr);
            }
        }

        for (int i = 0; i < gr; i++) {
            for (int j = 0; j < gr; j++) {
                if (answer[i][j] == -1) {
                    answer[i][j] = 0;
                    for (int index = i; index > 0; index--) if (apt[index][j] == 'b') answer[i][j]++;
                    for (int index = i; index < gr;index++) if (apt[index][j] == 'b') answer[i][j]++;
                    for (int index = j; index > 0; index--) if (apt[i][index] == 'b') answer[i][j]++;
                    for (int index = j; index < gr; index++) if (apt[i][index] == 'b') answer[i][j]++;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < gr; i++) {
            for (int j = 0; j < gr; j++) {
                if (answer[i][j] != 0) sum += answer[i][j];
            }
        }

        System.out.println("정답 : " + sum);
    }

    public static int forest(char[][] apt, int i, int j, int gr) {
        if (apt[i][j] == 'p') return 0;
        else if (i > 0 && j > 0) {
            if (apt[i - 1][j] == 'p') return 1;
            if (i < gr) if (apt[i + 1][j] == 'p') return 1;
            if (j < gr) if (apt[i][j + 1] == 'p') return 1;
            if (apt[i][j - 1] == 'p') return 1;
        } else if (i > 0) {
            if (apt[i - 1][j] == 'p') return 1;
            if (i < gr) if (apt[i + 1][j] == 'p') return 1;
            if (j < gr) if (apt[i][j + 1] == 'p') return 1;
        } else if (j > 0) {
            if (i < gr) if (apt[i + 1][j] == 'p') return 1;
            if (j < gr) if (apt[i][j + 1] == 'p') return 1;
            if (apt[i][j - 1] == 'p') return 1;
        }

        return -1;
    }
}
