from typing import List


# 枚举 + 暴力
# class MagicDictionary:
#
#     def __init__(self):
#         self.dict = list()
#
#     def buildDict(self, dictionary: List[str]) -> None:
#         self.dict = dictionary
#
#     def search(self, searchWord: str) -> bool:
#         for word in self.dict:
#             if len(word) != len(searchWord):
#                 continue
#             diff = 0
#             for chx, chy in zip(word, searchWord):
#                 if chx != chy:
#                     diff += 1
#                     if diff > 1:
#                         break
#             if diff == 1:
#                 return True
#         return False

# 字典树（前缀树）
class Trie:
    def __init__(self):
        self.child = dict()
        self.finished = False


class MagicDictionary:

    def __init__(self):
        self.root = Trie()

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            cur = self.root
            for ch in word:
                if ch not in cur.child:
                    cur.child[ch] = Trie()
                cur = cur.child[ch]
            cur.finished = True

    def search(self, searchWord: str) -> bool:  # 递归遍历字典树
        def dfs(node: Trie, pos: int, modified: bool) -> bool:
            """
            :param node: 当前树节点
            :param pos: 当前字符下标
            :param modified: 是否已修改
            :return:
            """
            if pos == len(searchWord):
                return modified and node.finished

            ch = searchWord[pos]
            if ch in node.child:
                if dfs(node.child[ch], pos + 1, modified):
                    return True
            if not modified:
                for cnext in node.child:
                    if cnext != ch:
                        if dfs(node.child[cnext], pos + 1, True):
                            return True
            return False
        return dfs(self.root, 0, False)

# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dictionary)
# param_2 = obj.search(searchWord)
