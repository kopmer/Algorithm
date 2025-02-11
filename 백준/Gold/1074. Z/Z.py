import sys

def z_visit(z_size,x,y):
    global cnt

    if x == r and y == c:   #목표좌표 도착시
        sys.stdout.write(f"{cnt}\n")    
        sys.exit(0)
    if z_size == 1: # 더이상 분할할수 없는 크기일때
        cnt += 1    # 방문횟수 더하고 종료
        return
    if not (x <= r < x+z_size and y <= c < y+z_size):   # 현재 사각형이 r,c 포함안하면
        cnt += z_size*z_size    # 한번에 방문횟수 더하고 종료
        return 
    part = z_size // 2
    z_visit(part,x,y)   # 1사분면
    z_visit(part,x,y+part)  # 2사분면
    z_visit(part,x+part,y)  # 3사분면
    z_visit(part,x+part,y+part) # 4사분면


n, r, c = map(int,sys.stdin.readline().split())

cnt = 0
z_size = 2**n
z_visit(z_size, x=0, y=0)