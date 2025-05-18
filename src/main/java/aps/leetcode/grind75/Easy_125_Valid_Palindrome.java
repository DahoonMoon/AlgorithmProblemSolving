package aps.leetcode.grind75;

import java.util.Objects;
import java.util.Stack;

public class Easy_125_Valid_Palindrome {
	public static boolean isPalindrome(String s) {

		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
		String[] input = s.split("");

		Stack<String> stack = new Stack<>();
		Stack<String> temp = new Stack<>();

		for (int i = 0; i < input.length; i++) {
			String element = input[i].toLowerCase();
			if (alphabet.contains(element)) {
				stack.add(element);
			}
		}

		int len = stack.size();

		if (len <= 1) {
			return true;
		}

		for (int i = 0; i < len/2; i++) {
			temp.add(stack.pop());
		}

		if (len % 2 == 1) {
			stack.pop();
		}

		while (!stack.empty()) {
			if (!Objects.equals(stack.pop(), temp.pop())) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
//		String s = "0P";


		boolean answer = isPalindrome(s);
		System.out.println(answer);
	}
}
