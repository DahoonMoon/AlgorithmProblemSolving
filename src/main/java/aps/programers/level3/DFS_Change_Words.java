package aps.programers.level3;

import java.util.Objects;

public class DFS_Change_Words {

	static boolean[] visit;
	static int answer = 0;

	public static int solution(String begin, String target, String[] words) {
		visit = new boolean[words.length];
		dfs(begin, target, words, 0);
		return answer;
	}

	private static void dfs(String now, String target, String[] words, int cnt) {
		if (Objects.equals(now, target)) {
			answer = cnt;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visit[i]) {
				continue;
			}

//			다른 단어 개수 찾기
			int k = 0;
			for (int j = 0; j < now.length(); j++) {
				if (now.charAt(j) != words[i].charAt(j)) {
					k++;
				}
			}

			if (k == 1) {
				visit[i] = true;
				dfs(words[i], target, words, cnt + 1);
				visit[i] = false;
			}
		}
	}


	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};

		int answer = solution(begin, target, words);

		System.out.println(answer);
//		4
	}



}
