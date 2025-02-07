import sys

def fib(n):
    dp = [0] * int(n+1)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2
    dp[4] = 3
    for i in range(5,n+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]

def fibonacci(n):
    global count
    dp = [0] * int(n+1)
    dp[1] = 1
    dp[2] = 1
    for i in range(3,n+1):
        count += 1
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]

count = 0
N = int(sys.stdin.readline())
fibonacci(N)
sys.stdout.write(f"{fib(N)} ")
sys.stdout.write(f"{count}")