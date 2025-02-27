import sys
N, M = map(int,sys.stdin.readline().split())

num_list = [i for i in range(1,N+1)]
comb = []
def back():
    if len(comb) == M:
        for j in comb:
            sys.stdout.write(f"{j} ")
        sys.stdout.write("\n")
        return
    for i in range(N): 
        if comb and i+1 < comb[-1]:    #추가될 i+1은 비내림차순을 만족해야함
            continue
        comb.append(i+1)
        back()
        comb.pop()

back()
