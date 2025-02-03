import sys
N = int(input())
num_list = list(map(int,sys.stdin.readline().split()))
M = int(input())
find_list = list(map(int,sys.stdin.readline().split()))
hashmap = {}

for n in num_list:
    if n in hashmap:
        hashmap[n] +=1
    else:
        hashmap[n] = 1
for i in find_list:
    if i in hashmap:
        sys.stdout.write(f"{hashmap[i]} ")
    else:
        sys.stdout.write("0 ")
