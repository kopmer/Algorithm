import sys

move = [[1,0],[-1,0],[0,1],[0,-1]]
def bfs(y,x,map):
    queue = [(y,x)]
    result[y][x] = 0
    while queue:
        y,x = queue.pop(0) # fifo(bfs)
        for i in range(4):  # 상하좌우
            ny = y + move[i][0]
            nx = x + move[i][1]
            if ny >= height or nx >= width or ny < 0 or nx < 0 or map[ny][nx] == 0:    # 행렬 초과 + 못가는곳
                continue
            if map[ny][nx] == 1 and result[ny][nx] == -1:   # 갈수있고 방문 안한곳
                result[ny][nx] = result[y][x] + 1   # 직전위치 + 1
                queue.append((ny,nx)) # 탐색 큐 추가(bfs)

            


height, width = map(int,sys.stdin.readline().split())
maps = []
result = [[-1] * width for _ in range(height)]

for _ in range(height):
    maps.append(list(map(int,sys.stdin.readline().split())))
for i in range(height):
    for k in range(width):
        if maps[i][k] == 2: # 스타트 지역
            bfs(i,k,maps)   # 탐색 시작
        elif maps[i][k] == 0:
            result[i][k] = 0
for k in range(height):
    for j in range(width):
        sys.stdout.write(f"{result[k][j]} ")
    sys.stdout.write("\n")