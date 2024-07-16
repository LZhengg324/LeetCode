package _106_buildTree;

import java.util.HashMap;

public class _106_buildTree {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {    //中序后序找二叉树
    private final HashMap<Integer,  Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            this.index.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int in_left, int in_right, int post_left, int post_right) {
        if (in_left > in_right) {
            return null;
        }
        int post_root = post_right;
        int in_root = index.get(postorder[post_root]);
        int leftSubTree_size = in_root - in_left;
        TreeNode leftSubTree = build (inorder, postorder, in_left, in_root - 1, post_left, post_left + leftSubTree_size - 1);
        TreeNode rightSubTree = build (inorder, postorder, in_root + 1, in_right, post_left + leftSubTree_size, post_right - 1);
        return new TreeNode(inorder[in_root], leftSubTree, rightSubTree);

    }
}