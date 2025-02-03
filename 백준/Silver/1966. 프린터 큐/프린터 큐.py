# 현재 큐의 가장앞 문서 중요도 확인
# 우선순위 큐
class priority_que:
    def __init__(self):
        self.items = []
    
    def is_empty(self):
        return len(self.items) == 0
    
    def push(self, item):
        self.items.append(item)
    
    def priority_search(self):
        is_priority = 1
        for i in range(self.size()-1):
            if self.items[0][1] < self.items[i+1][1]:
                is_priority = 0
        return is_priority

    def pop(self):
        if not self.is_empty():
            while True:
                if self.priority_search() == 1:
                    break
                self.push(self.items[0])
                del self.items[0]
                #self.print()
            return self.items.pop(0)   
        else:
            raise IndexError("empty")
        
    def peak(self):
        if not self.is_empty():
            return self.items[0]
        else:
            raise IndexError("empty")

    def print(self):
        print(self.items)
    def size(self):
        return len(self.items)
testCase_num = int(input())     # 첫 줄
for i in range(testCase_num):
    cnt =0
    file_num, find_index = map(int,input().split()) #문서 몇개인지, 출력 순서 궁금한 큐의 인덱스
    priority = list(map(int, input().split()))
    que_state = priority_que()

    for k in range(file_num):
        que_state.push([k,priority[k]])
    while True:
        pop_result = que_state.pop()
        cnt += 1
        if pop_result[0] == find_index:
            break
    print(cnt)