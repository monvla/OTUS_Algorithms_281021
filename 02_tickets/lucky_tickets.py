import pathlib
from console_tester import *

class LuckyTickets(Task):

    def run(self, data):
        self.count = 0
        self.n = int(data[0])
        self.run_recursive()
        return self.prepare_result(self.count)

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
