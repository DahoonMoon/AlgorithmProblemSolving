package boj.graphTraversal;

import java.util.*;

public class numbering_danji {
    static boolean[][] visit;
    static int count;
    static int danji;
    static List<Integer> danjiList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if(line.charAt(j) == '0'){
                    map[i][j] = 0;
                } else{
                    map[i][j] = 1;
                }
            }
        }

        visit = new boolean[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    danji = 0;
                    dfs(i, j, map);
                    count ++;
                    danjiList.add(danji);
                }
            }
        }

        System.out.println(count);

        Collections.sort(danjiList);

        for (Integer d : danjiList) {
            System.out.println(d);
        }
    }

    static void dfs(int x, int y, int[][] map) {
        visit[x][y] = true;
        danji++;

        int[][] delta = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        for(int i = 0; i < delta.length; i++){
            int dx = x + delta[i][0];
            int dy = y + delta[i][1];
            if(dx < 0 || dy < 0 || dx > map.length - 1 || dy > map[0].length - 1){
                continue;
            }

            if(map[dx][dy] == 1 && !visit[dx][dy]) {
                dfs(dx, dy, map);
            }
        }

    }



}
