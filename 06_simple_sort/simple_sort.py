from random import randrange
import time


class Sort:

    def swap(self, array, first_index, second_index):
        temp = array[first_index]
        array[first_index] = array[second_index]
        array[second_index] = temp

    def sort(self, array):
        pass


class BubbleSort(Sort):
    def __init__(self):
        self.unsorted_end_index = 0

    def sort(self, array):
        self.unsorted_end_index = len(array)
        while self.unsorted_end_index != 0:
            i = 0
            while i < self.unsorted_end_index - 1:
                if array[i] > array[i + 1]:
                    self.swap(array, i, i + 1)
                i += 1
            self.unsorted_end_index -= 1


class InsertionSort(Sort):
    def __init__(self):
        self.unsorted_start_index = 0

    def sort(self, array):
        while self.unsorted_start_index != len(array):
            i = self.unsorted_start_index
            while i > 0:
                if array[i] < array[i - 1]:
                    self.swap(array, i, i - 1)
                i -= 1
            self.unsorted_start_index += 1


class ShellSort:
    def __init__(self):
        pass

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


def run_bubble():
    range1 = 100
    test_array1 = [randrange(range1) for _ in range(range1)]
    time_start = time.perf_counter()
    BubbleSort().sort(test_array1)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range2 = 1000
    test_array2 = [randrange(range2) for _ in range(range2)]
    time_start = time.perf_counter()
    BubbleSort().sort(test_array2)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range3 = 10000
    test_array3 = [randrange(range3) for _ in range(range3)]
    time_start = time.perf_counter()
    BubbleSort().sort(test_array3)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_insertion():
    range1 = 100
    test_array1 = [randrange(range1) for _ in range(range1)]
    time_start = time.perf_counter()
    InsertionSort().sort(test_array1)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range2 = 1000
    test_array2 = [randrange(range2) for _ in range(range2)]
    time_start = time.perf_counter()
    InsertionSort().sort(test_array2)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range3 = 10000
    test_array3 = [randrange(range3) for _ in range(range3)]
    time_start = time.perf_counter()
    InsertionSort().sort(test_array3)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_shell():
    range1 = 100
    test_array1 = [randrange(range1) for _ in range(range1)]
    time_start = time.perf_counter()
    ShellSort().sort(test_array1)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range2 = 1000
    test_array2 = [randrange(range2) for _ in range(range2)]
    time_start = time.perf_counter()
    ShellSort().sort(test_array2)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")

    range3 = 10000
    test_array3 = [randrange(range3) for _ in range(range3)]
    time_start = time.perf_counter()
    ShellSort().sort(test_array3)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


run_shell()