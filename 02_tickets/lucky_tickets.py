import pathlib
from сonsole_tester import *

class LuckyTickets(Task):

    def __init__(self):
        self.count = 0

    def run(self, data):
        self.n = int(data[0])
        self.next_digits(0, 0, 0)
        # if (data[0] == "3"):
        #     return self.prepare_result(self.Lucky3())
        # if (data[0] == "4"):
        #     return self.prepare_result(self.Lucky4())
        return self.prepare_result(self.count)

    def Lucky3(self):
        count = 0
        for a1 in range(10):
            for a2 in range(10):
                for a3 in range(10):
                    for b1 in range(10):
                        for b2 in range(10):
                            for b3 in range(10):
                                if (a1 + a2 + a3 == b1 + b2 + b3):
                                    count += 1
        return count

    def Lucky4(self):
        count = 0
        for a1 in range(10):
            for a2 in range(10):
                for a3 in range(10):
                    for a4 in range(10):
                        for b1 in range(10):
                            for b2 in range(10):
                                for b3 in range(10):
                                    for b4 in range(10):
                                        if (a1 + a2 + a3 + a4 == b1 + b2 + b3 + b4):
                                            count += 1
        return count

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
