# 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
# 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
# 마지막 도착 계단은 반드시 밟아야 한다.
import sys
N = int(sys.stdin.readline())
dp = [0] * (N+1)
score = []
for i in range(N):
    score.append(int(sys.stdin.readline().strip()))
dp[1] = score[0]
if N > 1:
    dp[2] = score[1]+score[0]
if N > 2:
    dp[3] = max(dp[0] + score[1]+ score[2],dp[1]+score[2])
for i in range(4,N+1):
    dp[i] = max((score[i-1] + dp[i-2]),(score[i-1] + score[i-2] + dp[i-3])) # 두칸 점프한경우, 전에 이미 두칸점프후 한칸 올라온 경우
  
sys.stdout.write(f"{dp[N]}\n")