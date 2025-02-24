import sys
P1 = 'IOI'
N = int(sys.stdin.readline())
PN = P1 + 'OI' * (N-1) # P2 = IOI + OI = IOIOI
PN_len = len(PN)
S_len = int(sys.stdin.readline())
S = sys.stdin.readline()
count = 0
for i in range(S_len):

    if S_len - i >= PN_len - 1:
        if S[i:i+PN_len] == PN:
            count += 1
        
sys.stdout.write(f"{count}\n")