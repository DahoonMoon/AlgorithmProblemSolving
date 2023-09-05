package programers.level3;

public class DFS_Travel_Path {

	static boolean[] visited;
	public static String[] solution(String[][] tickets) {
		String[] answer = {};

//		초기화
		visited = new boolean[tickets.length];
		for (int i = 0; i < tickets.length; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < tickets.length; i++) {
//			어디서나 출발할 수 있다.
			String start = tickets[i][0];

			String next = tickets[i][1];

			visited[i] = true;
			pathDfs(next, tickets);
			visited[i] = false;
		}



//  ICN

//		SFO ATL   모두 찾고 다음꺼
//		티켓 쓴건지 확인 visited
//		DFS ?



//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
//		["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만
//		["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.


		return answer;
	}

	static void pathDfs(String now, String[][] tickets) {

	}

	public static void main(String[] args) {

		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] answer = solution(tickets);

		System.out.println(answer);

//				["ICN", "JFK", "HND", "IAD"]
	}
}
