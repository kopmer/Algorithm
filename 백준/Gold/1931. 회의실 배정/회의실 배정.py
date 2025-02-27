# 회의가 겹치지 않으면서 가장빨리 끝나는 회의 할당하면 될듯
import sys
meeting_cnt = int(sys.stdin.readline())
time_slot = []
for _ in range(meeting_cnt):
    start, end = map(int,sys.stdin.readline().split())
    time_slot.append([start,end])
time_slot.sort(key=lambda x:(x[1],x[0]))   # 끝나는 시간이 빠른순으로 정렬한 뒤 시작시간이 빠른순으로 정렬
available_time = 0
count = 0
while time_slot:
    meeting = time_slot.pop(0)
    if meeting[0] >= available_time:
        count += 1
        available_time = meeting[1]
print(count)
