package programers.level3;

import java.util.*;

public class Graph_FarthestNode {

	private static ArrayList<Integer>[] adj;
	private static boolean[] visit;
	private static int[] distance;

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		visit = new boolean[n+1];
		distance = new int[n+1];
		adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int[] ints : edge) {
			adj[ints[0]].add(ints[1]);
			adj[ints[1]].add(ints[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		distance[1] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			ArrayList<Integer> nodeList = adj[now];
			for (Integer integer : nodeList) {
				if (!visit[integer]) {
					q.add(integer);
					visit[integer] = true;
					distance[integer] = distance[now] + 1;
				}
			}
		}

		Arrays.sort(distance);
		int max = distance[distance.length - 1];

		for (int i = distance.length - 1; distance[i] == max; i--) {
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {

		int[][] edges = {
				{3, 6},
				{4, 3},
				{3, 2},
				{1, 3},
				{1, 2},
				{2, 4},
				{5, 2}
		};

		int answer = solution(6, edges);
		int expect = 3;

		System.out.println(answer);
	}

}
