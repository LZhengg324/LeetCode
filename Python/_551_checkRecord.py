class Solution:
    def checkRecord(self, s: str) -> bool:
        absent = 0
        late = 0
        for word in s:
            if word == 'A':
                absent += 1
                if absent >= 2:
                    return False
            elif word == 'L':
                late += 1
                if late >= 3:
                    return False
                continue
            late = 0
        return True
