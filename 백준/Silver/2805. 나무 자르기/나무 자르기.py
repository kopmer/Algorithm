import sys

treeCount, length = map(int,sys.stdin.readline().split())
tree_list = list(map(int,sys.stdin.readline().split()))

set_lenght = max(tree_list[0],tree_list[-1],tree_list[len(tree_list)//2]) - length  # 세개중 최대값(첫,끝,중간중)
if set_lenght < 0 : # 세팅값 음수면
    set_lenght = 0
rt = 1000000000
lt = set_lenght
while (lt<=rt):
    mid = (lt+rt) // 2
    take_sum = 0    
    for i in tree_list:
        if i > mid:  # 절단되는 나무 높이 합
            take_sum += (i - mid)
            
    if take_sum >= length:   # 가져가는 나무 높이 합 > 가져가려 했던 높이 -> 더 잘라도 됨 -> 세팅 높이 더 높게
        lt = mid+1
        set_lenght = mid
    elif take_sum < length: # 덜 잘라야함
        rt = mid-1
        
sys.stdout.write(f"{set_lenght}\n")
