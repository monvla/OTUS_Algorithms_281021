import pathlib
from console_tester import *

"""
Одна часть билета

В списке self.digits храню отдельные числа для их дальнейшего суммирования
"""


class LuckyTicketPart:
    def __init__(self, n):
        self.size_of_part = n
        self.digits = [0 for _ in range(n)]

    """
    Имитирую логику увеличения обычного числа на 1, но вместо числа массив
    """

    def increase(self):
        # Кол-во цифр
        total_length = len(self.digits)
        # Текущий индекс списка цифр на проверке
        checking_index = total_length - 1
        # Нахожу крайнее число слева для увеличения на 1
        while checking_index > 0 and self.digits[checking_index] == 9:
            checking_index -= 1
        # Если крайнее число слева равно 9, ничего не делаю
        if checking_index == 0 and self.digits[checking_index] == 9:
            return

        # Увеличиваю проверяемое число на 1
        self.digits[checking_index] += 1
        # Все остальные числа справа приравниваю к 0
        if checking_index < total_length - 1:
            decrease_number_index = checking_index + 1
            while decrease_number_index <= total_length - 1:
                self.digits[decrease_number_index] = 0
                decrease_number_index += 1

    """
    Возвращаю сумму текущих цифр в билете
    """

    def get_sum(self):
        sum = 0
        for digit in self.digits:
            sum += digit
        return sum


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

    def run_iterations(self):
        part1 = LuckyTicketPart(self.n)
        for _ in range(pow(10, self.n)):
            part2 = LuckyTicketPart(self.n)
            for _ in range(pow(10, self.n)):
                if part1.get_sum() == part2.get_sum():
                    self.count += 1
                part2.increase()
            part1.increase()

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
