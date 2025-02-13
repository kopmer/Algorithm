import sys

move = [[1,0],[0,1],[-1,0],[0,-1]]
def wormcount(field,y,x):
    global location
    queue = [(y,x)]
    field[y][x] = 0 # 방문처리
    while queue:
        y,x = queue.pop(0)
        for i in range(4):
            nx = x + move[i][0]
            ny = y + move[i][1]
            if nx >= width or ny >= height or nx < 0 or ny < 0: # 행렬에서 벗어나는지 검사
                continue
            if field[ny][nx] == 1:
                queue.append((ny,nx))
                field[ny][nx] = 0
                location.remove((ny,nx))
testcase = int(sys.stdin.readline())
for _ in range(testcase):
    width, height, baechuLocationCount = map(int,sys.stdin.readline().split())
    baechue_field = [[0] * width for _ in range(height)]
    location = []
    for _ in range(baechuLocationCount):    # 배추심기
        baechu_x, baechu_y = map(int,sys.stdin.readline().split())
        baechue_field[baechu_y][baechu_x] = 1
        location.append((baechu_y,baechu_x))
    cnt = 0
    while location:
        cnt += 1
        y,x = location.pop(0)
        wormcount(baechue_field,y,x)
    sys.stdout.write(f"{cnt}\n")