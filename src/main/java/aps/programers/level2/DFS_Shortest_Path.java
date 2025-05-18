package aps.programers.level2;

public class DFS_Shortest_Path {
    static boolean[][] visit;
    static int count;
    static int shortPath = Integer.MAX_VALUE;

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        visit = new boolean[n][m];
        count = 1;
        dfs(0, 0, maps);

        if(shortPath == Integer.MAX_VALUE){
            return -1;
        } else {
            return shortPath;
        }
    }

    void dfs(int nowI, int nowJ, int[][] maps){

//       탐색 종료 조건
        if(nowI == maps.length -1 && nowJ == maps[0].length -1){
            if(shortPath > count){
                shortPath = count;
            }
            return;
        }

        // 가지치기 (Pruning)
        if (count >= shortPath) return;

        if (nowI < 0 || nowJ < 0 || nowI >= maps.length || nowJ >= maps[0].length) return;
        if (maps[nowI][nowJ] == 0 || visit[nowI][nowJ]) return;

        visit[nowI][nowJ] = true;
        count++;

        dfs(nowI + 1, nowJ, maps);
        dfs(nowI - 1, nowJ, maps);
        dfs(nowI, nowJ + 1, maps);
        dfs(nowI, nowJ - 1, maps);

        visit[nowI][nowJ] = false;
        count--;
    }
}
