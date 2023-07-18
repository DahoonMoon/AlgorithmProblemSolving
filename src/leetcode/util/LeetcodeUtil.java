package leetcode.util;

import java.util.Collections;
import java.util.List;

public class LeetcodeUtil {

	public static ListNode arrayListToListNode(List<Integer> list) {

		ListNode listNode = null;

		for (int i = list.size() - 1; i >= 0; i--) {
			ListNode newNode = new ListNode(list.get(i));
			newNode.next = listNode;
			listNode = newNode;
		}

		return listNode;
	}

	public static void printListNode(ListNode listNode) {
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}


}
