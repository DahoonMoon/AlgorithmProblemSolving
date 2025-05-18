package aps.leetcode.grind75;

//Constraints
//1 <= nums.length <= 104
//-104 < nums[i], target < 104
//All the integers in nums are unique.
//nums is sorted in ascending order.

import java.util.Arrays;

//todo : 푸는중

public class Easy_704_Binary_Search {
	public static int search(int[] nums, int target) {

		int length = nums.length;
		if (length == 0) {
			return -1;
		}

		int[] low = Arrays.copyOfRange(nums, 0, length/2);
		int mid = nums[length / 2];
		int[] high = Arrays.copyOfRange(nums, length/2 + 1, length);

		if (mid == target) {
			return length/2;
		} else if (mid > target) {
			return search(low, target);
		} else {
			if (search(high, target) == -1) {
				return -1;
			}
			return length/2 + 1 + search(high, target);
		}


	}

	public static void main(String[] args) {

//		int[] nums = {-1,0,3,5,9,12};
//		int target = -2;

		int[] nums = {-1,0,3,5,9,12};
		int target = 2;
		int answer = search(nums, target);

		System.out.println("ans "+answer);


//		Input: nums = [-1,0,3,5,9,12], target = 9
//		Output: 4
//		Explanation: 9 exists in nums and its index is 4
	}

}
