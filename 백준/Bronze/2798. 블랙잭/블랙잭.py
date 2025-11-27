card_cnt, blackjack = map(int,input().split())
card_list = list(map(int,input().split()))

min_sum = -1
for i in range(card_cnt-2):
    a = card_list[i]
    for j in range(i+1,card_cnt-1):
        b = card_list[j]
        for k in range(j+1,card_cnt):
            c = card_list[k]

            if(a+b+c <= blackjack and a+b+c > min_sum):
                min_sum = a+b+c
print(min_sum)
