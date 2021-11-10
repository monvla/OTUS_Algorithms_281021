import pathlib
from console_tester import *
import math


class PrimeAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0

    def run(self, data):
        result = self.solve_with_iterations(data)
        return self.prepare_result(round(result, 11))

    def is_prime(self, number):
        count = 0
        for i in range(1, number + 1):
            if number % i == 0:
                count += 1
        return count == 2

    def solve_with_iterations(self, data):
        prime = int(data[0])
        result = 0
        for num in range(2, prime + 1):
            if self.is_prime(num):
                result += 1
        return result


task = PrimeAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "5.Primes")
)
tester.run_tests()
