N = int(input())
size_list = {"S":0,"M":0,"L":0,"XL":0,"XXL":0,"XXXL":0}
order_list = input().split()
order_cnt = 0
for i in size_list.keys():                      # 사이즈별 주문 개수 딕셔너리화
    size_list[i] = int(order_list[order_cnt])
    order_cnt += 1

T,P = map(int,input().split())
order_T = 0
order_P = 0
for k in size_list.keys():                      # 티셔츠 T장씩 몇묶음 주문해야하는지 계산
    #print(order_T)
    if (size_list[k] == 0):
        pass
    elif (size_list[k] <= T):                       # 주문수 < T묶음
        order_T += 1
    else:                                       # 주문수 > T묶음
        order_T += (size_list[k] // T)            # 나눈 몫 추가
        if(size_list[k] % T != 0): order_T += 1 # T장씩 묶고 남으면 묶음 추가

order_P = N // P                                # 주문수 묶음수 몫 계산
order_P_one = N % P                             # 나머지(한자루씩 주문해야 하는거)
print(order_T)
print(order_P,order_P_one)