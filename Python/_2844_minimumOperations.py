from math import inf


class Solution:
    def minimumOperations(self, num: str) -> int:
        n = len(num)
        find0 = find5 = False
        for i in range(n - 1, -1, -1):
            if num[i] in {'5', '0'}:
                if find0:
                    return n - i - 2
                else:
                    if num[i] == '0':
                        find0 = True
                    else:
                        find5 = True
            elif num[i] in {'2', '7'}:
                if find5:
                    return n - i - 2
        if find0:
            return n - 1
        return n


if __name__ == '__main__':
    print(Solution().minimumOperations("1"))
