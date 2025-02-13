import sys

N = int(sys.stdin.readline())
paper = []
blue = 0
white = 0
for i in range(N):
    paper.append(list(map(int,sys.stdin.readline().split()))) 

def blue_cnt(x,y,size):
    global paper,white,blue
    color = paper[y][x]
    part = size//2
    for i in range(size):
        for k in range(size):
            if paper[y + i][x + k] != color:
                blue_cnt(x,y,part)  # 2사분면
                blue_cnt(x+part,y,part)    # 1사분면
                blue_cnt(x,y+part,part)  # 3사분면
                blue_cnt(x+part,y+part,part)    #4 사분면
                return
    if color == 1:
        blue+=1
    else:
        white+=1
blue_cnt(0,0,N)
sys.stdout.write(f"{white}\n{blue}\n")