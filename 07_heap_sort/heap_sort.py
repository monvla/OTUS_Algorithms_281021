import pathlib
from console_tester import *


class HeapSort(Task):
    def __init__(self):
        self.array = []

    def run(self, data):
        numbers = [int(x) for x in data[1].split(" ")]
        self.sort(numbers)
        str_numbers = [str(x) for x in numbers]
        return self.prepare_result(" ".join(str_numbers))

    def sort(self, arr):
        self.array = arr
        root = int(len(self.array) / 2) - 1
        while root >= 0:
            self.heapify(root, len(self.array))
            root -= 1
        j = len(self.array) - 1
        while j >= 0:
            self.swap(0, j)
            self.heapify(0, j)
            j -= 1

    def swap(self, a, b):
        x = self.array[a]
        self.array[a] = self.array[b]
        self.array[b] = x

    def heapify(self, root, size):
        L = 2 * root + 1
        R = 2 * root + 2
        X = root
        if L < size and self.array[L] > self.array[X]: X = L
        if R < size and self.array[R] > self.array[X]: X = R
        if X == root: return
        self.swap(X, root)
        self.heapify(X, size)


class SimpleSort(Task):
    def __init__(self):
        self.array = []

    def run(self, data):
        numbers = [int(x) for x in data[1].split(" ")]
        self.sort(numbers)
        str_numbers = [str(x) for x in numbers]
        return self.prepare_result(" ".join(str_numbers))

    def swap(self, array, first_index, second_index):
        temp = array[first_index]
        array[first_index] = array[second_index]
        array[second_index] = temp

    def sort(self, array):
        pass


class BubbleSort(SimpleSort):
    def __init__(self):
        super().__init__()
        self.unsorted_end_index = 0

    def sort(self, array):
        self.array = array
        self.unsorted_end_index = len(self.array)
        while self.unsorted_end_index != 0:
            i = 0
            while i < self.unsorted_end_index - 1:
                if self.array[i] > self.array[i + 1]:
                    self.swap(self.array, i, i + 1)
                i += 1
            self.unsorted_end_index -= 1


class InsertionSort(SimpleSort):
    def __init__(self):
        super().__init__()
        self.unsorted_start_index = 0

    def sort(self, array):
        self.array = array
        self.unsorted_start_index = 0
        while self.unsorted_start_index != len(array):
            i = self.unsorted_start_index
            while i > 0:
                if array[i] < array[i - 1]:
                    self.swap(array, i, i - 1)
                i -= 1
            self.unsorted_start_index += 1


class ShellSort(Task):
    def __init__(self):
        pass

    def run(self, data):
        numbers = [int(x) for x in data[1].split(" ")]
        self.sort(numbers)
        str_numbers = [str(x) for x in numbers]
        return self.prepare_result(" ".join(str_numbers))

    def sort(self, array):
        gap = int(len(array) / 2)
        while gap > 0:
            i = 0
            while i + gap < len(array):
                j = i + gap
                tmp = array[j]
                while j - gap >= 0 and array[j - gap] > tmp:
                    array[j] = array[j - gap]
                    j -= gap
                array[j] = tmp
                i += 1
            gap = int(gap / 2)


def run_heap_sort():
    sort = HeapSort()
    array = [4, 0, 2, 1, 7, 6, 5, 3, 8, 9, 10, 11, 13, 15, 17, 19, 20, 12, 14, 16, 18]
    sort.sort(array)
    print(array)


def run_random_tests():
    tests_dir = "0.random"
    # Tester(BubbleSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(InsertionSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(HeapSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    Tester(ShellSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()


def run_digits_tests():
    tests_dir = "1.digits"
    # Tester(BubbleSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(InsertionSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(HeapSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    Tester(ShellSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()


def run_sorted_tests():
    tests_dir = "2.sorted"
    # Tester(BubbleSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(InsertionSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(HeapSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    Tester(ShellSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()


def run_revers_tests():
    tests_dir = "3.revers"
    # Tester(BubbleSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(InsertionSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    # Tester(HeapSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()
    Tester(ShellSort(), os.path.join(pathlib.Path(__file__).parent.resolve(), "sorting-tests", tests_dir)).run_tests()


run_revers_tests()
