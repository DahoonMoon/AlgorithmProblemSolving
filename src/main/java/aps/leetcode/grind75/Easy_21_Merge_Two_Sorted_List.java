package aps.leetcode.grind75;

import static aps.leetcode.util.LeetcodeUtil.arrayListToListNode;
import static aps.leetcode.util.LeetcodeUtil.printListNode;

import java.util.List;
import java.util.Stack;
import aps.leetcode.util.ListNode;

public class Easy_21_Merge_Two_Sorted_List {

//	Constraints
//	The number of nodes in both lists is in the range [0, 50].
//	-100 <= Node.val <= 100
//	Both list1 and list2 are sorted in non-decreasing order.

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode listNode = null;
		Stack<Integer> stack = new Stack<>();

		while (list1 != null || list2 != null) {
			Integer val1 = 101;
			Integer val2 = 101;
			if (list1 != null) {
				val1 = list1.val;
			}
			if (list2 != null) {
				val2 = list2.val;
			}

			if (val1 <= val2) {
				stack.add(val1);
				list1 = list1.next;
			} else {
				stack.add(val2);
				list2 = list2.next;
			}
		}

		while(!stack.empty()){
			ListNode newNode = new ListNode(stack.pop());
			newNode.next = listNode;
			listNode = newNode;
		}

		return listNode;
	}

	public static void main(String[] args) {

		List<Integer> list1 = List.of(1, 2, 4);
		List<Integer> list2 = List.of(1, 3, 4);

		ListNode listNode1 = arrayListToListNode(list1);
		ListNode listNode2 = arrayListToListNode(list2);

		ListNode answer = mergeTwoLists(listNode1, listNode2);

		System.out.println("answer");
		printListNode(answer);

//		list1 = [1,2,4], list2 = [1,3,4]
//		Output: [1,1,2,3,4,4]

	}





}
