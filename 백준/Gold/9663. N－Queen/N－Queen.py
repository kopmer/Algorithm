import sys
def check(queens, row, col): # 퀸 배치 가능여부 체크
    for r in range(row): # 이전 행 모두 검사
        if queens[r] == col or  abs(queens[r] - col) == abs(r - row): # 이전 퀸들이 배치된 열 or 대각선에 위치 한다면(우상향 우햐앙 둘다 고려해야함)
            return False
    return True
def sol(n, row=0, queens = []): # queens는 각 row에 배치된 퀸의 col [1,3] -> 0행 1열, 1행 3열에 퀸이 배치되었다는 뜻
    if row == n: # 모든 행에 배치완료 되면 경우의수 +1
        return 1
    count = 0
    for col in range(n):
        if col not in queens: # 열에 퀸이 없으면
            if check(queens, row, col):
                queens.append(col)
                count += sol(n, row+1, queens) # 다음행 재귀 탐색
                queens.pop() # 백트래킹 ( 배치한 퀸 제거 )
    return count
N = int(sys.stdin.readline())
sys.stdout.write(f"{sol(N)}\n")
