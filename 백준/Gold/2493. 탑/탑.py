import sys

N = int(sys.stdin.readline()) # 타워 개수
heights = list(map(int,sys.stdin.readline().split()))
rx_list = [0] * N
stack = [] # [인덱스, 높이]

for i in range(N):
    while stack and stack[-1][1] < heights[i]:  # 스택 안비어있고 신호보내는 타워가 더 높으면
        stack.pop()  # 현재 타워보다 낮은 타워는 신호를 수신못함
    if stack:
        rx_list[i] = stack[-1][0] + 1  

    stack.append((i, heights[i]))  # 현재 타워를 스택에 추가
    
for i in rx_list:
    sys.stdout.write(f"{i} ")
    

