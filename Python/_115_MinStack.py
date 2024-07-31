class MinStack:     # 维护两个栈
    def __init__(self):
        self.__stack = []
        self.__minstack = []

    def push(self, val: int) -> None:
        self.__stack.append(val)
        if not len(self.__minstack):
            self.__minstack.append(val)
        else:
            self.__minstack.append(min(val, self.__minstack[-1]))

    def pop(self) -> None:
        self.__stack.pop()
        self.__minstack.pop()

    def top(self) -> int:
        return self.__stack[-1]

    def getMin(self) -> int:
        return self.__minstack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
if __name__ == '__main__':
    minstack = MinStack()
    print(minstack.push(-1))
    print(minstack.top())
    print(minstack.getMin())