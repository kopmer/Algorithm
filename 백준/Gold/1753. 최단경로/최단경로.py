import sys
import heapq

V, E = map(int,sys.stdin.readline().split())    # 노드, 간선
start_k = int(sys.stdin.readline()) # 시작 노드
graph = [[] for _ in range(V+1)]
INF = 200000    
distance = [INF] * (V+1)
distance[start_k] = 0
for _ in range(E):
    u, v, w = map(int,sys.stdin.readline().split())
    graph[u].append((v,w))
priority_queue = [(0, start_k)] # 현재까지 거리, 현재 노드
while priority_queue:
    dist, now = heapq.heappop(priority_queue)   # 우선순위 큐에서 가장 가까운노드를 꺼냄

    if dist > distance[now]:
        continue
    for next, weight in graph[now]: # 현재 노드에서 이동할수 있는 노드들 확인
        new_weight = dist + weight  # 현재 노드를 거쳐가는 거리

        if new_weight < distance[next]: # 더 짧은 경로면 갱신
            distance[next] = new_weight
            heapq.heappush(priority_queue, (new_weight,next))
for i in range(1, V + 1):
    print("INF" if distance[i] == INF else distance[i])