import sys

def KMP_table(pattern):
    m = len(pattern)
    table = [0] * m
    j = 0
    for i in range(1, m):
        while j > 0 and pattern[i] != pattern[j]:
            j = table[j - 1]
        if pattern[i] == pattern[j]:
            j += 1
            table[i] = j
    return table

def KMP_search(text, pattern):
    n = len(text)
    m = len(pattern)
    table = KMP_table(pattern)
    j = 0  # 패턴에서 현재 검사하고있는 문자 인덱스
    count = 0
    for i in range(n):  # i 텍스트에서 현재 검사하는 문자 인덱스
        while j > 0 and text[i] != pattern[j]: 
            j = table[j - 1]
        if text[i] == pattern[j]:
            if j == m - 1:
                count += 1
                j = table[j]
            else:
                j += 1
    return count

P1 = 'IOI'
N = int(sys.stdin.readline())
PN = P1 + 'OI' * (N-1)
S_len = int(sys.stdin.readline())
S = sys.stdin.readline()
count = KMP_search(S, PN)

sys.stdout.write(f"{count}\n")