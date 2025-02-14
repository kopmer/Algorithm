import sys
visited = []
stack = []
non_visited = []
def visit_graph(v,graph):   # dfs
    stack.append(v)
    visited.append(v)
    non_visited.remove(v)
    while stack:
        node = stack.pop()
        for i in graph[node]:
            if i not in visited:
                stack.append(i)
                visited.append(i)
                non_visited.remove(i)
    return
graph = {}
node, edge = map(int,sys.stdin.readline().split())

for i in range(node):   # 그래프 생성
    graph[i+1] = [] # i+1 인덱스가 아니라 key graph = {i+1:[]}
    non_visited.append(i+1) # 방문 안한 곳

for _ in range(edge):
    u, v = map(int,sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

conected_component = 0
while non_visited:
    v = non_visited[0]
    conected_component += 1
    visit_graph(v,graph)    # bfs

sys.stdout.write(f"{conected_component}\n")
