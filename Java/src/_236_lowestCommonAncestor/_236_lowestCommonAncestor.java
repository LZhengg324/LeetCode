package _236_lowestCommonAncestor;

import java.util.HashMap;
import java.util.HashSet;

public class _236_lowestCommonAncestor {
    public static void main(String[] args) {

    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {    //递归
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return lca;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSubTree = find(root.left, p, q);
        boolean rightSubTree = find(root.right, p, q);
        if ((leftSubTree && rightSubTree)
                || ((root.val == p.val || root.val == q.val) && (leftSubTree || rightSubTree))) {
            this.lca = root;
        }
        return leftSubTree || rightSubTree || (root.val == p.val || root.val == q.val);
    }
}

class Solution2 {   //记录路径
    private final HashMap<Integer, TreeNode> parentNode = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        record(root);
        HashSet<Integer> record = new HashSet<>();
        record.add(p.val);
        while (parentNode.containsKey(p.val)) {
            record.add(parentNode.get(p.val).val);
            p = parentNode.get(p.val);
        }
        while (!record.contains(q.val)) {
            q = parentNode.get(q.val);
        }
        return q;
    }

    private void record(TreeNode root) {
        if (root.left != null) {
            parentNode.put(root.left.val, root);
            record(root.left);
        }
        if (root.right != null) {
            parentNode.put(root.right.val, root);
            record(root.right);
        }
    }
}