package aps.leetcode;

import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int
 * val, ListNode next) { this.val = val; this.next = next; } }
 */
class Medium_445_Add_Two_Numbers_II {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//		각각 Stack에 넣기
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (l1 != null) {
			stack1.add(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.add(l2.val);
			l2 = l2.next;
		}

//		before : 합계가 두자리수 일 경우 10의자리 숫자
		int before = 0;

//		맨 마지막 노드를 null로 세팅
		ListNode answer = null;

//		스택에 숫자가 있거나 10의자리 숫자가 남아있을때까지 반복
		while (!stack1.empty() || !stack2.empty() || before != 0) {
			int first = !stack1.empty() ? stack1.pop() : 0;
			int second = !stack2.empty() ? stack2.pop() : 0;

			int sum = first + second + before;
			int number = sum % 10;
			before = sum / 10;

//			새로운 노드를 생성하여 나머지 노드의 Head로 설정
			ListNode newNode = new ListNode(number);
			newNode.next = answer;
			answer = newNode;
		}

		return answer;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		Medium_445_Add_Two_Numbers_II solution = new Medium_445_Add_Two_Numbers_II();

		solution.addTwoNumbers(l1, l2);
	}


	public static class ListNode {

		private int val;
		private ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
