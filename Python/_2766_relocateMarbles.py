from typing import List


class Solution:
    def relocateMarbles(self, nums: List[int], moveFrom: List[int], moveTo: List[int]) -> List[int]:
        table = set(nums)
        op = len(moveFrom)
        for i in range(op):
            table.remove(moveFrom[i])
            table.add(moveTo[i])
        ret = list(table)
        ret.sort()
        return ret


if __name__ == '__main__':
    print(Solution().relocateMarbles([1,6,7,8], [1,7,2], [2,9,5]))