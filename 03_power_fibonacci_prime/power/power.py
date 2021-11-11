import pathlib
from console_tester import *


class PowerAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0

    def run(self, data):
        power = int(data[1])
        multiplier = float(data[0])
        # result = self.solve_with_iterations(power, multiplier)
        result = self.solve_binary(power, multiplier)
        # result = self.solve_with_multiplying(power, multiplier)
        return self.prepare_result(round(result, 11))

    def solve_with_iterations(self, power, multiplier):
        """ Итеративный алгоритм возведения числа в степень """
        result = 1.0
        for _ in range(power):
            result *= multiplier
        return result

    def solve_with_multiplying(self, power, multiplier):
        """ Возведение числа в степень через домножение """
        result = multiplier
        needed_power = power
        if needed_power == 0:
            return 1.0

        current_power = 1
        while current_power * 2 < needed_power:
            current_power *= 2
            result *= result
        for _ in range(needed_power - current_power):
            result *= multiplier
        return result

    def solve_binary(self, power, multiplier):
        """ Возведение в степень через двоичное разложение показателя степени """
        result = 1.0
        n = power
        numbers = []
        current_power = 1
        number_in_power = multiplier
        while n >= 1:
            if n % 2 == 1:
                result *= number_in_power
            if n > 1:
                current_power *= 2
                number_in_power *= number_in_power
                n = int(n / 2)
                numbers.append(n)
            else:
                break
        return result

task = PowerAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "3.Power")
)
tester.run_tests()
