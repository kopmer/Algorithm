import sys
from collections import deque

move = [[-1,0],[1,0],[0,-1],[0,1]]
def bfs(graph,x,y):
    count = 0
    queue.append((x,y))

    while queue:
        x,y = queue.popleft()
        count += 1
        for i in range(4):
            nx = x + move[i][0]
            ny = y + move[i][1]
            if nx >= N or ny >= M or nx < 0 or ny < 0:
                continue
            if graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = graph[x][y] + 1
                
    return graph[N-1][M-1]
graph = []
queue = deque()
N,M = map(int,sys.stdin.readline().split())
for _ in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip())))
cnt = bfs(graph,0,0)
sys.stdout.write(f"{cnt}\n")