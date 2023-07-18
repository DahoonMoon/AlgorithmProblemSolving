package leetcode.grind75;


import java.util.List;
import leetcode.util.TreeNode;

//Constraints
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
public class Easy_226_Invert_Binary_Tree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode newNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(newNode);

		return root;
	}


	public static void main(String[] args) {
//		Input: root = [4,2,7,1,3,6,9]
//		Output: [4,7,2,9,6,3,1]

		List<Integer> list = List.of(4, 2, 7, 1, 3, 6, 9);

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(7);


	}

}
