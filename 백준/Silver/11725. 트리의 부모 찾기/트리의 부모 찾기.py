import sys
from collections import deque
N = int(sys.stdin.readline())
tree = {}
parent = [0] * (N+1)
for _ in range(N-1):
    a, b = map(int,sys.stdin.readline().split())
    if a not in tree:
        tree[a] = []
        
    if b not in tree:
        tree[b] = []
    tree[a].append(b)
    tree[b].append(a)
def bfs(root):
    queue = deque([root])
    while queue:
        node = queue.popleft() 
        for child in tree[node]: # 현재 노드의 자식들 확인
            if parent[child] == 0: # 아직 방문 안했다면 부모설정, 큐에 추가
                parent[child] = node
                queue.append(child)
bfs(1)
for node in parent[2:]:
    sys.stdout.write(f"{node}\n")