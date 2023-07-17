package leetcode.top_interviewed_questions.array;

import java.util.HashMap;
import java.util.Map;

//		Constraint
//		2 <= nums.length <= 10^4
//		-10^9 <= nums[i] <= 10^9
//		-10^9 <= target <= 10^9
//		Only one valid answer exists.
//      시간복잡도 O(n^2) 미만

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
		}

		return new int[]{};
	}

	public static void main(String[] args) {
		Two_Sum solution = new Two_Sum();

		int[] nums = {3, 3};
		int target = 6;

		int[] answer = solution.twoSum(nums, target);

		System.out.print("[");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
			if(i < answer.length -1){
			System.out.print(", ");}
		}
		System.out.print("]");


	}
}
