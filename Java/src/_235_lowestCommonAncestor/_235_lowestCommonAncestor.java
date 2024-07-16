package _235_lowestCommonAncestor;

public class _235_lowestCommonAncestor {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find (root, p, q);
        return ans;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftTree = find (root.left, p, q);
        boolean rightTree = find(root.right, p, q);
        if ((leftTree && rightTree)
                || ((leftTree || rightTree) && (root.val == p.val || root.val == q.val))) {
            this.ans = root;
        }
        return leftTree || rightTree || (root.val == p.val || root.val == q.val);
    }
}