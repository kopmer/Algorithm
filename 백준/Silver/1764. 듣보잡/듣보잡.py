import sys
hear_list = {}
hearSee = []
N, M = map(int,input().split())
cnt = 0
for i in range(N):
    hear = sys.stdin.readline().strip()
    hear_list[hear] = 0
for k in range(M):
    see = sys.stdin.readline().strip()
    if see in hear_list:
        hear_list[see] = 1    
        cnt += 1
        hearSee.append(see)
hearSee.sort()
sys.stdout.write(f"{cnt}\n")
for j in hearSee:
    sys.stdout.write(f"{j}\n")