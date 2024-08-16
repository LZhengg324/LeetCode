from typing import List


# 垃圾做法
# class Vector2D:
#     def __init__(self, vec: List[List[int]]):
#         self.vec = []
#         for vec_item in vec:
#             for num in vec_item:
#                 self.vec.append(num)
#         self.size = len(self.vec)
#         self.pos = -1
#
#     def next(self) -> int:
#         self.pos += 1
#         return self.vec[self.pos]
#
#     def hasNext(self) -> bool:
#         return self.pos < self.size - 1


# 仿造Iterator
class Vector2D:
    def __init__(self, vec: List[List[int]]):
        self.vec = vec
        self.inner = 0
        self.outer = 0

    def advance_to_next(self):
        while self.outer < len(self.vec) and self.inner == len(self.vec[self.outer]):
            self.outer += 1
            self.inner = 0

    def next(self) -> int:
        self.advance_to_next()
        ret = self.vec[self.outer][self.inner]
        self.inner += 1
        return ret

    def hasNext(self) -> bool:
        self.advance_to_next()
        return self.outer < len(self.vec)