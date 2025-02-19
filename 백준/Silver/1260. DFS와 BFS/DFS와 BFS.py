import sys
from collections import deque

def dfs(start):
    stack.append(start)
    while stack:
        v = stack.pop()  # LIFO 동작
        if v not in visited:
            visited.add(v)
            result.append(v)
            for i in sorted(graph[v], reverse=True):  # DFS는 역순
                stack.append(i)

def bfs(start):
    queue.append(start)
    while queue:
        v = queue.popleft()  # FIFO 동작
        if v not in visited:
            visited.add(v)
            result.append(v)
            for i in sorted(graph[v]):  # BFS는 정순
                queue.append(i)

# 입력 받기
N, M, V = map(int, sys.stdin.readline().split())  # 정점, 간선, 시작점
graph = {i: [] for i in range(1, N + 1)}

for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

visited = set()
result = []
stack = []
dfs(V)
for i in result:
    sys.stdout.write(f"{i} ")
print("")
visited.clear()
result.clear()
queue = deque()
bfs(V)
for i in result:
    sys.stdout.write(f"{i} ")
