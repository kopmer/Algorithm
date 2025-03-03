import sys
N, M = map(int,sys.stdin.readline().split())
num_list = list(map(int,sys.stdin.readline().split()))
num_list.sort()
comb = []
visited = [False for _ in range(N)]
def back():
    if len(comb) == M:
        for i in comb:
            sys.stdout.write(f"{i} ")
        sys.stdout.write("\n")
        return
    temp = 0
    for i in range(N):
        if visited[i] == False and temp != num_list[i]:
            comb.append(num_list[i])
            visited[i] = True
            temp = num_list[i]
            back()
            comb.pop()
            visited[i] = False
back()
