package leetcode.grind75;

import java.util.HashMap;
import java.util.Map;

//Constraints
//1 <= s.length, t.length <= 5 * 10^4
//s and t consist of lowercase English letters.
public class Easy_242_Valid_Anagram {
	public static boolean isAnagram(String s, String t) {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] index = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int idx = alphabet.indexOf(s.charAt(i));
			index[idx] += 1;
		}

		for (int i = 0; i < t.length(); i++) {
			int idx = alphabet.indexOf(t.charAt(i));
			index[idx] -= 1;
		}

		for (int i = 0; i < index.length; i++) {
			if (index[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
//		Input: s = "anagram", t = "nagaram"
//		Output: true

		String s = "rat";
		String t = "car";
		boolean answer = isAnagram(s, t);

		System.out.println(answer);

	}

}
