import pathlib
from console_tester import *
import math


class PowerAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0

    def run(self, data):
        result = self.solve_with_iterations(data)
        return self.prepare_result(round(result, 11))

    def solve_with_iterations(self, data):
        result = 1.0
        for _ in range(int(data[1])):
            result *= float(data[0])
        return result

    # def solve_with_power(self, data):
    #     result = float(data[0])
    #     needed_power = int(data[1])
    #     if needed_power == 0:
    #         return 1.0
    #
    #     current_power = 1
    #     while current_power * 2 < needed_power:
    #         current_power *= 2
    #         result *= result
    #     for _ in range(needed_power - current_power):
    #         result *= float(data[0])
    #     return result

task = PowerAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "3.Power")
)
tester.run_tests()
