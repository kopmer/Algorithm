import sys
N,M = map(int,sys.stdin.readline().split())
num = list(map(int,sys.stdin.readline().split()))

# 누적합
dp = [0] * (N+1)    
for n in range(1,N+1):  
    dp[n] = dp[n-1] + num[n-1]

for _ in range(M):
    i, j = map(int,sys.stdin.readline().split())
    part_sum = 0
    part_sum = dp[j] - dp[i-1]
    sys.stdout.write(f"{part_sum}\n")