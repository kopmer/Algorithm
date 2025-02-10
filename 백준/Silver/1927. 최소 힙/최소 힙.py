import sys
class min_heap:
    def __init__(self):
        self.items = []
    def pop(self):
        if self.empty() == 1:
            return 0
        else:
            self.items[0],self.items[-1] = self.items[-1], self.items[0]
            min_value = self.items.pop(-1)
            self.sort(0)
            return min_value
    def insert(self, x):
        self.items.append(x)
        idx = len(self.items) - 1
        while idx > 0:
            if idx % 2 == 0:
                parent_idx = idx//2 - 1
            else:
                parent_idx = idx//2
            if self.items[parent_idx] > self.items[idx]:    # 부모가 더 크면 교체
                self.swap(idx,parent_idx)
                idx = parent_idx    # 현재 인덱스 = 부모 인덱스
            else:
                break
    def swap(self,idx1,idx2):
        self.items[idx1], self.items[idx2] = self.items[idx2], self.items[idx1]
    def empty(self):
        if len(self.items) == 0:
            return 1
    def sort(self,idx):
        while idx*2+1 < len(self.items):
            left = idx*2 + 1
            right = idx*2 + 2
            min_idx = left

            if right < len(self.items) and self.items[right] < self.items[left]: # 오른쪽 자식과 왼쪽 자식중 더 작은 인덱스
                 min_idx = right

            if self.items[min_idx] < self.items[idx]:   # 자식이 더 작으면 swap
                self.swap(idx,min_idx)
                idx = min_idx
            else:
                break
testcase = int(sys.stdin.readline())
heap = min_heap()
for _ in range(testcase):
    x = int(sys.stdin.readline())
    if x == 0:
        result = heap.pop()
        sys.stdout.write(f"{result}\n")
    else:
        heap.insert(x)
