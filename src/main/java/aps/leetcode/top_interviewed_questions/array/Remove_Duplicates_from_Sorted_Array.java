package aps.leetcode.top_interviewed_questions.array;

public class Remove_Duplicates_from_Sorted_Array {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int uniqueElements = 1;
		int current = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1] ) {
				nums[current] = nums[i];
				uniqueElements++;
				current++;
			}
		}

		return uniqueElements;
	}

	public static void main(String[] args){

		Remove_Duplicates_from_Sorted_Array solution = new Remove_Duplicates_from_Sorted_Array();

		int[] nums = {1, 1, 2}; // Input array

		int k = solution.removeDuplicates(nums); // Calls your implementation

		System.out.println(k);

		System.out.print("[");
		for (int i = 0; i < k; i++) {
			System.out.print(nums[i]);
			if (i != k - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");

	}


}
