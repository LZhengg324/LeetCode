from typing import List


class Solution:
    def calPoints(self, operations: List[str]) -> int:
        st = []
        total = 0
        for op in operations:
            if op == '+':
                point = st[-1] + st[-2]
            elif op == 'D':
                point = st[-1] * 2
            elif op == 'C':
                total -= st.pop()
                continue
            else:
                point = int(op)
            st.append(point)
            total += point
        return total


if __name__ == "__main__":
    print(Solution().calPoints(["5", "-2", "4", "C", "D", "9", "+", "+"]))
