import sys
N = int(sys.stdin.readline())
 
for _ in range(N): 
    cnt_0 = [1,0]   # fib(0) = 1 0 
    cnt_1 = [0,1]   # fib(1) = 0 1
    n = int(sys.stdin.readline())
    if n>1:
        for i in range(n-1):
            cnt_0.append(cnt_1[-1]) # 0 호출 횟수 = fib(n-1)의 1 호출횟수
            cnt_1.append(cnt_0[-2]+cnt_1[-1])   # 1 호출 횟수 = fib(n-2)의 0호출횟수 + fib(n-1)의 1호출횟수
 
    sys.stdout.write(f"{cnt_0[n]} {cnt_1[n]}\n")