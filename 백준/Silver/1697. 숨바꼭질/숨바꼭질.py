import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

if N >= K:
    sys.stdout.write(f"{N - K}\n")  # 단순히 1씩 감소하면 되는 경우
else:
    queue = deque([(N, 0)])  # (현재 위치, 이동 횟수)
    visited = set()  # 중복 방문 방지

    while queue:
        pos, steps = queue.popleft()
        
        if pos == K:
            sys.stdout.write(f"{steps}\n")
            break
        
        if pos not in visited:
            visited.add(pos)
            queue.append((pos - 1, steps + 1))  # -1 이동
            queue.append((pos + 1, steps + 1))  # +1 이동
            if pos * 2 <= 2 * K:  # 큰 숫자 탐색 방지
                queue.append((pos * 2, steps + 1))  # *2 이동