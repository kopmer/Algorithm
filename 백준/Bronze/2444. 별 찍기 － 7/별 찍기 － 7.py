x = int(input())
N = x * 2 - 1

for i in range(1,N+1):
    if(i<=x):
        print(' ' * int(x-i) + '*' * int(i*2-1))
    else:
        print(' ' * int(i%x) + '*' * int((x-i%x) * 2 - 1)) 