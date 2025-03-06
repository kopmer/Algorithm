#배낭문제
import sys
N, K = map(int,sys.stdin.readline().split())    # 가방개수 N, 무게제한 K
backapcks = []
for _ in range(N):
    backapcks.append(list(map(int,sys.stdin.readline().split())))
dp = [[0] * (K+1) for _ in range(N+1)]
for i in range(1,N+1):
    for j in range(1,K+1):
        weight = backapcks[i-1][0]
        value = backapcks[i-1][1]
        if j < weight:  # 가방 무게 < 현재 물건의 무게 (담을수 없을때)
            dp[i][j] = dp[i-1][j]
        else:   # 가방 무게 >= 현재 물건의 무게 (담을수 있을때)
            dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight]+value)    # 담지 않았을때,이전 물건 고려해서 담았을때
sys.stdout.write(f"{dp[N][K]}\n")