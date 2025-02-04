import sys
N = int(input())
time_p = list(map(int,sys.stdin.readline().split()))
time_p.sort()
total = 0 
for i in range(len(time_p)):
    total += sum(time_p[0:i+1])
print(total)