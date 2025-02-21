import sys
from collections import deque
# 한칸 이동(왼쪽,오른쪽,위,아래) -> (-1 0, 1 0, 0 1, 0 -1)
move = [[-1, 0], [1, 0], [0, 1], [0, -1]]
def bfs(graph,a,b):
    queue = deque()
    queue.append((a,b)) # a,b 방문
    graph[a][b] = 0
    l = len(graph)
    count = 1   #단지수

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + move[i][0]
            ny = y + move[i][1]
            if nx >= l or ny >= l or nx < 0 or ny < 0:
                continue
            if graph[nx][ny] == 1: # 방문 안했으면
                graph[nx][ny] = 0
                queue.append((nx,ny))
                count += 1  
    return count
N = int(sys.stdin.readline())
graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip())))
cnt = []
for i in range(N):  # 그래프 돌면서 1찾으면 bfs실행
    for j in range(N):
        if graph[i][j] == 1:
            cnt.append(bfs(graph,i,j))
cnt.sort()
sys.stdout.write(f"{len(cnt)}\n")
for i in cnt:
    sys.stdout.write(f"{i}\n")