import sys
testcase = int(sys.stdin.readline())
for i in range(testcase):
    N = int(sys.stdin.readline())
    dp = [[0] * 2 for _ in range(N+1)]
    dp[0][0] = 1
    dp[0][1] = 0
    if N>0:
        dp[1][0] = 0
        dp[1][1] = 1
        for i in range(2,N+1):
            dp[i][0] = dp[i-1][0] + dp[i-2][0] 
            dp[i][1] = dp[i-1][1] + dp[i-2][1] 
    sys.stdout.write(f"{dp[N][0]} {dp[N][1]}\n")
