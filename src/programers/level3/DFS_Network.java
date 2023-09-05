//package programers.level3;
//
//public class DFS_Network {
//
//	static boolean[] visited;
//	public static int solution(int n, int[][] computers) {
//		int answer = 0;
//
//		visited = new boolean[n];
//
//		// 초기화
//		for(int i = 0; i < n; i++){
//			visited[i] = false;
//		}
//
//		for(int i = 0; i < n; i++){
//			if(visited[i] == false){
////				네트워크 1 추가
//				answer++;
////				연결된 모든 노드 visited 처리
//				dfs(i, computers);
//			}
//		}
//
//		return answer;
//	}
//
//	public static void dfs(int now, int[][] computers){
//		visited[now] = true;
//
//		for(int i = 0; i < computers.length; i++){
//			if(visited[i] == false && computers[now][i] == 1){
////				visited 처리 하며 다시 주변 노드들 visited 처리하러 반복
//				dfs(i, visited, computers);
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//
//		int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int i = 3;
//		int answer = solution(i, computer);
//
//		System.out.println(answer);
//
//		//2
//	}
//}
