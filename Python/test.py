import bisect

a = [1,2,2,2,2,4,4,4,4,4,5,5,5,6,6]
print(bisect.bisect_left(a, 6), len(a))