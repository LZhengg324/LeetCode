class Solution:
    def minEnd(self, n: int, x: int) -> int:
        # 双指针，i 指向要插入的数字(n)，j 指向被插入的空格(x)
        n -= 1
        i = j = 0
        while n >> j:
            if x >> i & 1 == 0:
                bit = n >> j & 1
                x |= bit << i
                j += 1
            i += 1
        return x


if __name__ == '__main__':
    print(Solution().minEnd(3, 4))
