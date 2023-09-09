package boj.graphTraversal;

import java.util.*;

public class dfs_bfs {

    static boolean[] visit;
    static List<Integer> dfsWay = new ArrayList<>();
    static List<Integer> bfsWay = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        visit = new boolean[n + 1];
        dfs(start, map);

        for (int i = 1; i <= n; i++) {
            visit[i] = false;
        }
        bfs(start, map);

        for (int i = 0; i < dfsWay.size() - 1; i++) {
            System.out.print(dfsWay.get(i) + " ");
        }
        System.out.println(dfsWay.get(dfsWay.size() - 1));

        for (int i = 0; i < bfsWay.size() - 1; i++) {
            System.out.print(bfsWay.get(i) + " ");
        }
        System.out.print(bfsWay.get(bfsWay.size() - 1));
    }

    static void dfs(int now, int[][] map) {
        visit[now] = true;
        dfsWay.add(now);

        int[] close = map[now];
        for (int i = 0; i < close.length; i++) {
            if (close[i] == 1 && !visit[i]) {
                dfs(i, map);
            }
        }
    }

    static void bfs(int now, int[][] map) {

        Queue<Integer> queue = new LinkedList<>();
        visit[now] = true;
        bfsWay.add(now);
        queue.offer(now);

        while (!queue.isEmpty()) {
            int a = queue.poll();
            int[] close = map[a];
            for (int i = 0; i < close.length; i++) {
                if (close[i] == 1 && !visit[i]) {
                    visit[i] = true;
                    bfsWay.add(i);
                    queue.offer(i);
                }
            }

        }

    }


}
