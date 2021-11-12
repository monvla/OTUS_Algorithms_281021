import pathlib
from console_tester import *
import math


class SquareMatrix:
    """
    | item00, item01 |
    | item10, item11 |
    """

    def __init__(self, item00, item01, item10, item11):
        self.item00 = item00
        self.item01 = item01
        self.item10 = item10
        self.item11 = item11

    def multiply(self, second_matrix):
        return SquareMatrix(
            self.item00 * second_matrix.item00 + self.item01 * second_matrix.item10,
            self.item00 * second_matrix.item01 + self.item01 * second_matrix.item11,
            self.item10 * second_matrix.item00 + self.item11 * second_matrix.item10,
            self.item10 * second_matrix.item01 + self.item11 * second_matrix.item11
        )

    def print(self):
        print(
"""
|%s, %s|
|%s, %s|
""" % (self.item00, self.item01, self.item10, self.item11)
        )


class FiboAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0
        self.Fi = (1 + math.sqrt(5)) / 2

    def run(self, data):
        needed_fibo_value = int(data[0])
        # result = self.solve_with_recursion(needed_fibo_value)
        # result = self.solve_with_iterations(needed_fibo_value)
        # result = self.solve_golden(needed_fibo_value)
        # result = self.solve_matrix(needed_fibo_value)
        return self.prepare_result(result)

    def fibo_rec(self, n):
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fibo_rec(n - 1) + self.fibo_rec(n - 2)

    def solve_with_recursion(self, needed_fibo_value):
        """ Рекурсивный алгоритм """
        result = self.fibo_rec(needed_fibo_value)
        return result

    def solve_with_iterations(self, needed_fibo_value):
        """ Поиск через итерации """
        fibo_array = [0, 1]
        if needed_fibo_value < 2:
            return fibo_array[needed_fibo_value]
        for i in range(2, needed_fibo_value + 1):
            fibo_array.append(fibo_array[1] + fibo_array[0])
            fibo_array.pop(0)
        result = fibo_array.pop()
        return result

    def solve_golden(self, needed_fibo_value):
        """ Формула золотого сечения """
        return int(pow(self.Fi, needed_fibo_value) / math.sqrt(5) + 0.5)

    def to_power_binary(self, needed_fibo_value):
        """ Возведение в степень через двоичное разложение показателя степени """
        result = SquareMatrix(
            1, 1,
            1, 0
        )
        n = needed_fibo_value
        numbers = []
        current_power = 1
        number_in_power = result
        while n >= 1:
            if n % 2 == 1:
                result = result.multiply(number_in_power)
            if n > 1:
                current_power *= 2
                number_in_power = number_in_power.multiply(number_in_power)
                n = int(n / 2)
                numbers.append(n)
            else:
                break
        return result

    def solve_matrix(self, needed_fibo_value):
        """ Решение через домножение матриц """
        start = SquareMatrix(
            1, 1,
            1, 0
        )
        if needed_fibo_value == 0:
            return start.item11
        if needed_fibo_value == 1:
            return start.item10
        if needed_fibo_value == 2:
            return start.item01
        result = self.to_power_binary(needed_fibo_value)
        return result.item11


task = FiboAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "4.Fibo")
)
tester.run_tests()
