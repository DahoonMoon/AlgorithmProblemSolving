package aps.programers.level2;

public class DFS_Target_Number {

	static int count = 0;

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		dfs(numbers, 0, target, 0);
		answer = count;

		return answer;
	}

	public static void dfs(int[] numbers, int depth, int target, int result){
//		마지막까지 갔을때 검증
		if (depth == numbers.length){ //마지막 노드까지 진행했을 때
			if (target == result){ //target값과 합계가 같다면
				count++;
			}
			return;
		}

		dfs(numbers, depth+1, target, result + numbers[depth]);
		dfs(numbers, depth+1, target, result - numbers[depth]);

	}


	public static void main(String[] args) {

		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;

		int answer = solution(numbers, target);

		System.out.println(answer);
//		4
	}
}
