package programers.level2;

public class Brute_Force_Divide_Graph {
    static boolean[] visit;
    static int count;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        for (int k = 0; k < wires.length; k++) {

            int[][] map = new int[n + 1][n + 1];

            for (int i = 0; i < wires.length; i++) {
                if (i != k) {
                    map[wires[i][0]][wires[i][1]] = 1;
                    map[wires[i][1]][wires[i][0]] = 1;
                }
            }

            visit = new boolean[n + 1];
            count = 0;
            dfs(1, map);

            int min;
            if (count > n - count) {
                min = count * 2 - n;
            } else {
                min = n - count * 2;
            }

            answer = Math.min(answer, min);
        }

        return answer;
    }


    public static void dfs(int now, int[][] map) {
        visit[now] = true;
        count++;

        int[] next = map[now];

        for (int i = 0; i < next.length; i++) {
            if (next[i] == 1 && !visit[i]) {
                dfs(i, map);
            }
        }
    }
}
