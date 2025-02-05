import sys
computer = int(input())
link_num = int(input())
network = [[] for _ in range(computer)]
visited = [0] * (computer)
for i in range(link_num):
    a, b = map(int,sys.stdin.readline().split())
    network[a-1].append(b)  # 인덱스 고려
    network[b-1].append(a)
cnt = 0
#print(network)
def dfs(x):
    global cnt
    visited[x-1] = 1
    for i in network[x-1]:
        if not visited[i-1]:
            cnt += 1
            dfs(i)
    return cnt

sys.stdout.write(f"{dfs(1)}")