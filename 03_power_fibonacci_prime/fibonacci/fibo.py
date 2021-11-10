import pathlib
from console_tester import *
import math


class FiboAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0

    def run(self, data):
        needed_fibo_value = int(data[0])
        # result = self.solve_with_recursion(needed_fibo_value)
        result = self.solve_with_iterations(needed_fibo_value)
        return self.prepare_result(result)

    def fibo(self, n):
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fibo(n - 1) + self.fibo(n - 2)

    def solve_with_recursion(self, needed_fibo_value):
        result = self.fibo(needed_fibo_value)
        return result

    def solve_with_iterations(self, needed_fibo_value):
        fibo_array = [0, 1]
        if needed_fibo_value < 2:
            return fibo_array[needed_fibo_value]
        for i in range(2, needed_fibo_value + 1):
            fibo_array.append(fibo_array[1] + fibo_array[0])
            fibo_array.pop(0)
        result = fibo_array.pop()
        return result


task = FiboAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "4.Fibo")
)
tester.run_tests()
