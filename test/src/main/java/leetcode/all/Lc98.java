package leetcode.all;

public class Lc98 {
	public static void main(String[] args) {
		Lc98 lc98 = new Lc98();
		TreeNode n1 = new TreeNode(4);
		n1.left = null;
		n1.right = null;
		TreeNode n2 = new TreeNode(1);
		n1.left = new TreeNode(2);
		n1.right = new TreeNode(7);
		TreeNode root = new TreeNode(5);
		root.left = n1;
		root.right = n2;

		TreeNode n3 = new TreeNode(Integer.MIN_VALUE);
		//		n3.left = new TreeNode(1);
		//		n3.right = new TreeNode(3);
		System.out.print(lc98.isValidBST(n3));
	}

	long maxVal = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = isValidBST(root.left);
		if (root.val < maxVal) {
			maxVal = root.val;
		} else {
			return false;
		}
		boolean right = isValidBST(root.right);
		return left && right;
	}
}
