package aps.leetcode.top_interviewed_questions.array;

//		Constraint
//		1 <= nums.length <= 3 * 10^4
//		-3 * 10^4 <= nums[i] <= 3 * 10^4

public class Single_Number {
	public int singleNumber(int[] nums) {
		int[] index = new int[60001];

		for (int i = 0; i < nums.length; i++) {
			index[nums[i]+30000] += 1;
		}

		for (int i = 0; i < index.length; i++) {
			if (index[i] == 1) {
				return i-30000;
			}
		}

		return -1;
	}

	public static void main(String[] args){
		Single_Number solution = new Single_Number();

		int[] nums = {4, 1, 2, 1, 2};

		int answer = solution.singleNumber(nums);

		System.out.println(answer);

	}
}
