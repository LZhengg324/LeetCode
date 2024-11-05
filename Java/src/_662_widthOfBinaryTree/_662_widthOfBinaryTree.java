package _662_widthOfBinaryTree;

import java.util.ArrayList;
import javafx.util.Pair;

public class _662_widthOfBinaryTree {
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
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Pair<TreeNode, Integer>> q = new ArrayList<>();
        q.add(new Pair<TreeNode, Integer>(root, 1));
        int res = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            ArrayList<Pair<TreeNode, Integer>> temp = new ArrayList<>();
            for (Pair<TreeNode, Integer> nodes : q) {
                TreeNode node = nodes.getKey();
                Integer index = nodes.getValue();
                if (node.left != null) {
                    temp.add(new Pair<TreeNode, Integer>(node.left, 2 * index));
                }
                if (node.right != null) {
                    temp.add(new Pair<TreeNode, Integer>(node.right, 2 * index + 1));
                }
            }
            res = Math.max(res, q.get(q.size() - 1).getValue() - q.get(0).getValue() + 1);
            q = temp;
        }
        return res;
    }
}