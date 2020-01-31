package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/validate-binary-search-tree/
public class isValidBST {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val >= min) {
            return false;
        }

        if (max != null && root.val <= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Integer.MIN_VALUE);
    }

    public boolean isValidBST2(TreeNode root, int prev) {
        if (root == null) {
            return true;
        }

        if (isValidBST2(root.left, prev)) {
            return false;
        }

        if (root.val <= prev) {
            return false;
        }

        if (isValidBST2(root.right, root.val)) {
            return false;
        }

        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        isValidBST3(root, nodes);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i).val <= nodes.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public void isValidBST3(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            isValidBST3(root.left, nodes);
            nodes.add(root);
            isValidBST3(root.right, nodes);
        }
    }
}
