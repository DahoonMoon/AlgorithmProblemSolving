package aps.goorm.level3;

import java.io.*;

public class DFS_Image_Processor {

    static boolean[][] visit;
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (temp[j].equals(".")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        br.close();

        int count = 0;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    size = 0;
                    dfs(i, j, map);

                    if (size > max) {
                        max = size;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void dfs(int nowI, int nowJ, int[][] map) {

        if (map[nowI][nowJ] == 1 && !visit[nowI][nowJ]) {

            size++;
            visit[nowI][nowJ] = true;

            if (nowJ < map[0].length - 1) {
                dfs(nowI, nowJ + 1, map);
            }

            if (nowJ > 0) {
                dfs(nowI, nowJ - 1, map);
            }

            if (nowI < map.length - 1) {
                dfs(nowI + 1, nowJ, map);
            }

            if (nowI > 0) {
                dfs(nowI - 1, nowJ, map);
            }
        }
    }

}
