import sys
N = int(sys.stdin.readline())
room = [[0] * N for _ in range(N)]
for i in range(N):
    room[i] = list(map(int,sys.stdin.readline().split()))
dp = [[[0] * 3 for _ in range(N)] for _ in range(N)] # [x][y]에서   
dp[0][1][0] = 1 # 초기값(0,1) 가로 시작
for i in range(N):
    for j in range(2,N):
        if room[i][j] == 1: # 벽이면
            continue
        dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2] # 가로방향 가능한 경우의수 = 이전에서 가로 + 대각 경우의수

        if i >= 1:
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2] # 세로 = 이전에서 세로 + 대각

        if i > 0 and room[i-1][j] == 0 and room[i][j-1] == 0:
            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1]+ dp[i-1][j-1][2]
sys.stdout.write(f"{sum(dp[N-1][N-1])}\n")

