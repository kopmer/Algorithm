import sys
N, M = map(int,sys.stdin.readline().split())
num_arr = []
for _ in range(N):
    num_arr.append(list(map(int,sys.stdin.readline().split())))
dp = [[0] * (N+1) for _ in range(N+1)] # 현재 위치까지의 합
for row in range(1,N+1):
    for col in range(1,N+1):
        dp[row][col] = num_arr[row-1][col-1] + dp[row-1][col] + dp[row][col-1] - dp[row-1][col-1]
for _ in range(M):
    x1,y1,x2,y2 = map(int,sys.stdin.readline().split())
    sum = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]
    sys.stdout.write(f"{sum}\n")