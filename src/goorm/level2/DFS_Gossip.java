package goorm.level2;

import java.io.*;

public class DFS_Gossip {
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        int cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] network = new int[n+1][n+1];
        visit = new boolean[n+1];

        // 초기화
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                network[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            network[a][b] = 1;
            network[b][a] = 1;
        }

        br.close();

        dfs(network, 1);

        for(int i = 0; i <= n; i++ ){
            if(visit[i]){
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    static void dfs(int[][] map, int now){
        visit[now] = true;

        int[] friends = map[now];

        for(int i = 0; i < friends.length; i++){
            if(friends[i] == 1 && !visit[i]){
                dfs(map, i);
            }
        }
    }
}
