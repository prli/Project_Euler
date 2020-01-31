package leetcode;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class minDepth {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //DFS, keep level, is curLevel > min? return;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    //DFS, keep level, is curLevel > min? return;
    public int minDepth(TreeNode root, int level) {
        int min = Integer.MAX_VALUE;

        return min;
    }
}
