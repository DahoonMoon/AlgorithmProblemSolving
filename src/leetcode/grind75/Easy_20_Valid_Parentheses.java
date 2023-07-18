package leetcode.grind75;

import java.util.List;
import java.util.Stack;

public class Easy_20_Valid_Parentheses {
	public boolean isValid(String s) {
		Stack<String> stack = new Stack<>();

		List<String> open = List.of ("[", "{", "(");
		List<String> close = List.of("]", "}", ")");

		for (int i = s.length()-1; i >= 0; i--) {
			String entity = s.substring(i, i+1);

			if(close.contains(entity)){
				stack.add(entity);
			} else{
				if (stack.empty()) {
					return false;
				}
				String popped = stack.pop();
				if (open.indexOf(entity) != close.indexOf(popped)) {
					return false;
				}
			}
		}

		if (!stack.empty()) {
			return false;
		}

		return true;
	}


	public static void main(String[] args) {

		Easy_20_Valid_Parentheses solution = new Easy_20_Valid_Parentheses();
		String s = "()[]{}";

		System.out.println(solution.isValid(s));
	}

}
