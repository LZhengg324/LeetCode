from cmath import inf
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# 递归检查
# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         def valid(node: Optional[TreeNode], lower: Optional[int] = -inf, upper: Optional[int] = inf) -> bool:
#             if not node:
#                 return True
#             if node.val <= lower or node.val >= upper:
#                 return False
#             if not valid(node.left, lower, node.val) or not valid(node.right, node.val, upper):
#                 return False
#             return True
#         return valid(root)

# 中序遍历检查： 对于所有根节点都有所有左子节点 < 根节点 < 所有右子节点，中序遍历二叉搜索树的所有节点的值应为递增
# 不递归，运用栈来判断
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack, pre = [], float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= pre:
                return False
            pre = root.val
            root = root.right
        return True
