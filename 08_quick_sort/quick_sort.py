import pathlib
import random
import time


class QuickSort:
    def __init__(self):
        self.array = []

    def swap(self, array, first_index, second_index):
        temp = array[first_index]
        array[first_index] = array[second_index]
        array[second_index] = temp

    def run(self, L, R, array):
        self.array = array
        self.quick_sort(L, R)

    def quick_sort(self, L, R):
        if L < R:
            M = self.split(L, R)
            self.quick_sort(L, M - 1)
            self.quick_sort(M + 1, R)

    def split(self, L, R):
        pass


class QuickSortOld(QuickSort):
    def __init__(self):
        super().__init__()

    def split(self, L, R):
        p = self.array[R]
        i = L - 1
        j = L
        while j <= R:
            if self.array[j] < p:
                i += 1
                self.swap(self.array, i, j)
            j += 1
        self.swap(self.array, i + 1, R)
        return i + 1


class QuickSortNew(QuickSort):
    def __init__(self):
        super().__init__()

    def split(self, L, R):
        p = self.array[R]
        a = L - 1
        i = L
        while i <= R:
            if self.array[i] <= p:
                a += 1
                self.swap(self.array, a, i)
            i += 1
        return a


class MergeSort:

    def run(self, arr):
        self.mergeSort(arr)

    def mergeSort(self, arr):
        if len(arr) > 1:

            mid = len(arr) // 2

            L, R = arr[:mid], arr[mid:]

            self.mergeSort(L)
            self.mergeSort(R)

            i = j = k = 0

            while i < len(L) and j < len(R):
                if L[i] < R[j]:
                    arr[k] = L[i]
                    i += 1
                else:
                    arr[k] = R[j]
                    j += 1
                k += 1

            while i < len(L):
                arr[k] = L[i]
                i += 1
                k += 1

            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1


def get_rand_arr(n):
    return [random.randint(0, n) for _ in range(n)]


def run_quick_sort_new(arr):
    sort = QuickSortNew()
    time_start = time.perf_counter()
    sort.run(0, len(arr) - 1, arr.copy())
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_quick_sort_old(arr):
    sort = QuickSortOld()
    time_start = time.perf_counter()
    sort.run(0, len(arr) - 1, arr.copy())
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_merge(arr):
    sort = MergeSort()
    time_start = time.perf_counter()
    sort.run(arr.copy())
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_tests():
    power = 2
    while power <= 6:
        arr = get_rand_arr(pow(10, power))
        power += 1

        print("=" * 20 + "QuickOld" + 20 * "=")
        run_quick_sort_old(arr)

        print("=" * 20 + "QuickNew" + 20 * "=")
        run_quick_sort_new(arr)

        print("=" * 20 + "MergeSort" + 20 * "=")
        run_merge(arr)


run_tests()
