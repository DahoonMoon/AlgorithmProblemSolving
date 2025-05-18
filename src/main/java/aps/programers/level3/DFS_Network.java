package aps.programers.level3;

public class DFS_Network {
    static boolean[] visit;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[n];

        for(int i = 0; i < n; i++){
            visit[i] = false;
        }

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                answer++;
                dfs(i, computers);
            }
        }

        return answer;
    }

    static void dfs(int now, int[][] computers){

        visit[now] = true;

        int[] connected = computers[now];

        for(int i = 0; i < connected.length; i++){
            if(connected[i] == 1 && i != now && !visit[i]){
                dfs(i, computers);
            }
        }

    }

	public static void main(String[] args) {

		int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int i = 3;
		int answer = solution(i, computer);

		System.out.println(answer);

		//2
	}
}
