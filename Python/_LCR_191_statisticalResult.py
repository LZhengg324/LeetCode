from typing import List


class Solution:
    def statisticalResult(self, arrayA: List[int]) -> List[int]:
        arrayB = []
        total = 1
        zero_cnt = 0
        total_xzero = 1
        for num in arrayA:
            if num != 0:
                total_xzero *= num
            else:
                zero_cnt += 1
            total *= num

        for num in arrayA:
            if num != 0:
                arrayB.append(total // num)
            else:
                if zero_cnt == 1:
                    arrayB.append(total_xzero)
                else:
                    arrayB.append(0)
        return arrayB


# 不使用除法
class Solution2:
    def statisticalResult(self, arrayA: List[int]) -> List[int]:
        n = len(arrayA)
        arrayB = [1] * (n)
        for i in range(1, n):
            arrayB[i] = arrayA[i - 1] * arrayB[i - 1]
        tmp = 1
        for i in range(n - 2, -1, -1):
            tmp *= arrayA[i + 1]
            arrayB[i] *= tmp
        return arrayB