import sys
sys.setrecursionlimit(10**9)
n = int(sys.stdin.readline())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    parent, child, weight = map(int,sys.stdin.readline().split())
    tree[parent].append((child,weight))
    tree[child].append((parent,weight))

max_dist = 0
far_node = 0
visited = [False] * (n+1)
visited[1] = True

def dfs(node,dist):
    global max_dist, far_node
    if dist > max_dist:
        max_dist = dist
        far_node = node
    for next_node, weight in tree[node]: # tree dfs방문
        if not visited[next_node]:
            visited[next_node] = True
            dfs(next_node,dist + weight)
dfs(1,0) # 처음 dfs(1번 노드 시작)
visited = [False] * (n+1)
visited[far_node] = True
dfs(far_node,0) # 가장 멀리있는 노드에서 dfs
sys.stdout.write(f"{max_dist}\n")