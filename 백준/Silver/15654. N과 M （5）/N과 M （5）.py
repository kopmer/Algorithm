import sys
N, M = map(int,sys.stdin.readline().split())
num_lsit = list(map(int,sys.stdin.readline().split()))
num_lsit.sort() # 사전순으로 정렬
comb = []
visited = [False for _ in range(N)] # 사용한 숫자

def back():
    if len(comb) == M:
        for i in comb:
            sys.stdout.write(f"{i} ")
        sys.stdout.write("\n")
        return
    for i in range(N):
        if visited[i] == False: # 사용하지 않은 숫자의 경우
            comb.append(num_lsit[i])
            visited[i] = True
            back()
            comb.pop()
            visited[i] = False
back()