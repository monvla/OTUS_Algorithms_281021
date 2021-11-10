import pathlib
from console_tester import *


class LuckyTickets(Task):

    def __init__(self):
        self.n = -1
        self.count = 0

    def run(self, data):
        self.count = 0
        self.n = int(data[0])
        self.run_iterations()
        # self.run_recursive()
        return self.prepare_result(self.count)

    def get_next_array(self, previous_array):
        new_len = len(previous_array) + 9
        next_array = []
        for i in range(new_len):
            new_value = 0
            for j in range(10):
                append_index = i - j
                if 0 <= append_index < len(previous_array):
                    new_value += previous_array[append_index]
            next_array.append(new_value)
        return next_array

    def run_iterations(self):
        array = []
        for i in range(10):
            array.append(1)
        for i in range(self.n - 1):
            array = self.get_next_array(array)
        for i in array:
            self.count += i * i

    def run_recursive(self):
        self.next_digits(0, 0, 0)

    def next_digits(self, digit_number, first_sum, second_sum):
        if digit_number == self.n:
            if first_sum == second_sum:
                self.count += 1
            return
        for a in range(10):
            for b in range(10):
                self.next_digits(digit_number + 1, first_sum + a, second_sum + b)


task = LuckyTickets()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "1.Tickets")
)
tester.run_tests()
