import sys
N = int(sys.stdin.readline())
num_list = list(map(int,sys.stdin.readline().split()))
LIS = []
def binary_search(x,array):
    lt = 0
    rt = len(array)
    while(lt < rt):
        mid = (lt + rt) // 2
        if array[mid] < x:
            lt = mid + 1
        else:
            rt = mid 
    return lt

for num in num_list:
    idx = binary_search(num,LIS) # LIS에 num 추가

    if idx == len(LIS):
        LIS.append(num)
    else:
        LIS[idx] = num

sys.stdout.write(f"{len(LIS)}\n")