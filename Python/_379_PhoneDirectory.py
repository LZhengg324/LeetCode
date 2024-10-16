class PhoneDirectory:

    def __init__(self, maxNumbers: int):
        self.storage = set(range(maxNumbers))

    def get(self) -> int:
        return self.storage.pop() if self.storage else -1

    def check(self, number: int) -> bool:
        return number in self.storage

    def release(self, number: int) -> None:
        self.storage.add(number)


# Your PhoneDirectory object will be instantiated and called as such:
# obj = PhoneDirectory(maxNumbers)
# param_1 = obj.get()
# param_2 = obj.check(number)
# obj.release(number)