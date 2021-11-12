import pathlib
from console_tester import *
import math


class PrimeAlgo(Task):

    def __init__(self):
        self.n = -1
        self.count = 0
        self.primes = []

    def run(self, data):
        prime = int(data[0])
        self.count = 0
        self.primes = []
        # result = self.solve_with_iterations(prime)
        # result = self.solve_with_iterations_sqrt(prime)
        # result = self.solve_with_erathosphene_sieve(prime)
        result = self.solve_with_erathosphene_sieve_linear(prime)
        return self.prepare_result(result)

    def is_prime(self, number):
        count = 0
        for i in range(1, number + 1):
            if number % i == 0:
                count += 1
        return count == 2

    def solve_with_iterations(self, N):
        """ Итеративный алгоритм """
        result = 0
        for num in range(2, N + 1):
            if self.is_prime(num):
                result += 1
        return result

    def is_prime_sqrt(self, p):
        sqrt = int(math.sqrt(p))
        i = 0
        while self.primes[i] <= sqrt:
            if p % self.primes[i] == 0:
                return False
            i += 1
        return True

    def solve_with_iterations_sqrt(self, N):
        """ Поиск с делением на простые числа """
        self.primes.append(2)
        self.count += 1
        p = 3
        while p <= N:
            if self.is_prime_sqrt(p):
                self.primes.append(p)
                self.count += 1
            p += 2

        return self.count

    def solve_with_erathosphene_sieve(self, N):
        """ Поиск через решето Эратосфена """
        divs = [False] * (N + 1)
        count = 0
        for p in range(2, N + 1):
            if not divs[p]:
                count += 1
                if p <= math.sqrt(N):
                    j = p * p
                    while j <= N:
                        divs[j] = True
                        j += p
        return count

    def solve_with_erathosphene_sieve_linear(self, N):
        """ Решето Эратосфена за O(N) """
        lp = [0] * (N + 1)
        pr = []
        i = 2
        while i <= N:
            if lp[i] == 0:
                lp[i] = i
                pr.append(i)
            for p in pr:
                if p <= lp[i] and p * i <= N:
                    lp[p*i] = p
            i += 1
        return len(pr)

task = PrimeAlgo()
tester = Tester(
    task,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "5.Primes")
)
tester.run_tests()
