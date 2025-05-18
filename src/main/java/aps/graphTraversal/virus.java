package aps.graphTraversal;

import java.util.Scanner;

public class virus {
    static boolean[] visit;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        visit = new boolean[n + 1];
        count = 0;
        dfs(1, map);

        System.out.print(count - 1);

    }

    static void dfs(int now, int[][] map) {
        visit[now] = true;
        count++;

        int[] close = map[now];
        for (int i = 0; i < close.length; i++) {
            if (close[i] == 1 && !visit[i]) {
                dfs(i, map);
            }
        }
    }



}
