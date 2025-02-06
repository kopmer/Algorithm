import sys
testcase = int(sys.stdin.readline())
for _ in range(testcase):
    N = int(sys.stdin.readline())
    dp = [0] * int(N+3) # dp[0]은 안씀
    dp[1] = 1   
    dp[2] = 2
    dp[3] = 4
    for i in range(4,N+1):
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    sys.stdout.write(f"{dp[N]}\n")