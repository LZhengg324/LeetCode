package _105_buildTree;

import java.util.HashMap;

public class _105_buildTree {
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

class Solution {    //前序中序找二叉树
    private final HashMap<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int pre_root = pre_left;
        int in_root = indexMap.get(preorder[pre_root]);
        int leftSubTree_size = in_root - in_left;
        TreeNode leftSubTree = build(preorder, inorder, pre_left + 1, pre_left + leftSubTree_size, in_left, in_root - 1);
        TreeNode rightSubTree = build(preorder, inorder, pre_left + leftSubTree_size + 1, pre_right, in_root + 1, in_right);
        return new TreeNode(preorder[pre_root], leftSubTree, rightSubTree);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }
}