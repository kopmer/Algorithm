import sys
from collections import deque
N, K = map(int,sys.stdin.readline().split())
MAX = 100000

queue = deque([(N,0)]) # 현재 수빈이 위치, 경과 시간
visited = set([N]) # 중복 방문 방지

while queue:
    pos, time = queue.popleft()

    if pos == K:
        sys.stdout.write(f"{time}\n")
        break
    if pos * 2 <= MAX and pos * 2 not in visited:
        visited.add(pos*2)
        queue.appendleft((pos * 2, time))
    if pos - 1 >= 0 and pos - 1 not in visited:
        visited.add(pos-1)
        queue.append((pos-1, time + 1)) # x - 1
    if pos + 1 <= MAX and pos+1 not in visited:
        visited.add(pos+1)
        queue.append((pos+1, time +1)) # x + 1


        