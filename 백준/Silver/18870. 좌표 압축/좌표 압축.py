# N개 좌표 정렬 -> 작은순으로 인덱스 부여 -> 인덱스 출력
import sys
N = int(sys.stdin.readline())
N_list = list(map(int,sys.stdin.readline().split()))

sorted_list = sorted(set(N_list))  # 중복 제거 후 정렬
compressed_crd = {num: idx for idx, num in enumerate(sorted_list)}

for i in N_list:
    sys.stdout.write(f"{compressed_crd[i]} ")
sys.stdout.write(f"\n")
