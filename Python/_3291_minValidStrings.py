from math import inf
from typing import List, Optional
from functools import cache


# 字典树 + 记忆化搜索
class Trie:
    def __init__(self):
        self.children: List[Optional[Trie]] = [None] * 26

    def insert(self, word: str):
        node = self
        for i in map(lambda x: ord(x) - 97, word):
            if node.children[i] is None:
                node.children[i] = Trie()
            node = node.children[i]


class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        n = len(target)

        @cache
        def dfs(i: int):
            """
            表示target字符串从第i个字符开始最少需要多少个words的前缀
            """
            if i >= n:
                # 遍历完了
                return 0
            node = root
            ans = inf
            for j in range(i, n):
                k = ord(target[j]) - 97
                if node.children[k] is None:
                    break
                node = node.children[k]
                ans = min(ans, 1 + dfs(j + 1))
            return ans

        root = Trie()
        for word in words:
            root.insert(word)
        res = dfs(0)
        return res if res < inf else -1


