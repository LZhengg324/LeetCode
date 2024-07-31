import heapq
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pq = []     # 优先队列
        s = set()
        for num in nums:
            s.add(num)
        for n in s:
            appear = nums.count(n)
            heapq.heappush(pq, (appear, n))
            if len(pq) > k:
                heapq.heappop(pq)
        ans = []
        for i in range(k):
            ans.append(heapq.heappop(pq)[1])
        return ans

if __name__ == '__main__':
    print(Solution().topKFrequent([1,1,1,2,2,3], 2))