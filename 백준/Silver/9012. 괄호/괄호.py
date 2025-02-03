# PS -> 괄호 문자열, VPS -> 올바른 괄호 문자열
# 스택활용 하면 될듯
class ps_stack:
    def __init__(self):
        self.items = []
    def push(self,X):
        self.items.append(X)
    def pop(self):
        if self.empty() == 1:
            raise Exception("empty")
        else: 
            return self.items.pop()
    def top(self):
        if self.empty() == 1:
            return -1
        else:
            return self.items[-1]
    def empty(self):
        if self.size() == 0:
            return 1
        else: return 0
    def size(self):
        return len(self.items)
    def print(self):
        print(self.items) 
T = int(input())
for i in range(T):
    VPS_check = "YES"
    stack = ps_stack()
    ps = input()
    for k in ps:
        if k == ')':
            if stack.top() == -1:   # 닫는괄호 나오면 pop
                VPS_check = "NO"    # 스택에 ( 없으면 NO
            else:
                stack.pop()
        elif k == '(':
            stack.push(k)
    if stack.empty() == 0:  # 스택에 ( 남아있으면 NO
        VPS_check = "NO"
    print(VPS_check)