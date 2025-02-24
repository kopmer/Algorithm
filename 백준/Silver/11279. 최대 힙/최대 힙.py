import sys
class heap:
    def __init__(self):
        self.items = []
    def insert(self,x):
        if self.empty() == 1:
            self.items.append(x)
        else:
            self.items.append(x)
            idx = len(self.items)-1
            while idx > 0:
                parent = (idx-1) // 2
                if self.items[parent] < self.items[idx]:
                    self.swap(parent,idx)
                    idx = parent
                else:
                    break
    def swap(self,x,y):
        self.items[x],self.items[y] = self.items[y],self.items[x]
    def pop_max(self):
        if self.empty():
            sys.stdout.write("0\n")
            return
        elif len(self.items) == 1:
            sys.stdout.write(f"{self.items.pop()}\n")
        else:
            self.swap(0,len(self.items)-1) # 배열의 처음값과 마지막값 swap
            sys.stdout.write(f"{self.items.pop()}\n")
            self.heapify(0) # 힙 유지

    def heapify(self, idx):
        size = len(self.items)
        while True: # top에서 bottom까지 자식과 비교하여 자식이 더 크면 교체
            left = idx * 2 + 1
            right = idx * 2 + 2
            bigger = idx 

            if left < size and self.items[left]> self.items[bigger]:  #왼쪽 자식 존재하고 자신보다 더 크다면
                bigger = left
            if right < size and self.items[bigger] < self.items[right]: # 오른쪽 자식 존재하고 값 비교
                bigger = right
            if bigger == idx: # 더이상 비교할 자식이 없거나 자신이 더 크면 반복문 탈출
                break
            else:
                self.swap(idx,bigger)
                idx = bigger
        
    def empty(self):
        return len(self.items) == 0

testcase = int(sys.stdin.readline())
array1 = heap()
for _ in range(testcase):
    command = int(sys.stdin.readline().strip())
    if command > 0:
        array1.insert(command)
    elif command == 0:
        array1.pop_max()
