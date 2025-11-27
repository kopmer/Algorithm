def redraw_cnt(start_row,start_col,board_state,first_color):
    cnt = 0
    next_color = first_color
    for i in range(8):
        for k in range(8):
            if board_state[i+start_row][k+start_col] != next_color:
                cnt +=1
            if next_color == 'W' and k != 7:
                next_color = 'B'
            elif next_color == 'B' and k != 7:
                next_color = 'W'
    return cnt

N,M = map(int,input().split())
board_state = []
redraw_min = 64
for i in range(N):
    board_state.append(input())

for i in range(N-7):
    for k in range(M-7):
        start_row = i
        start_col = k
        a_start = redraw_cnt(start_row,start_col,board_state,'W')
        b_start = redraw_cnt(start_row,start_col,board_state,'B')
        if a_start < redraw_min:
            redraw_min = a_start
        if b_start < redraw_min:
            redraw_min = b_start
print(redraw_min)