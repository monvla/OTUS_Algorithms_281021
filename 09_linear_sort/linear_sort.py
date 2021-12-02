from random import randrange
import time


def create_bytes_file(n):
    with open('bytes.bin', 'wb') as f:
        for x in range(n):
            f.write((randrange(65535)).to_bytes(2, byteorder='big'))


def read_bytes_file():
    data = []
    with open('bytes.bin', 'rb') as f:
        byte = f.read(2)
        while byte != b"":
            byte = f.read(2)
            data.append(int.from_bytes(byte, byteorder='big'))
    return data


class MergeSort:

    def run(self, arr):
        self.merge_sort(arr)

    def run_shell_merge(self, arr):
        self.shell_merge_sort(arr)

    def shell_sort(self, array):
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

    def shell_merge_sort(self, arr):
        if len(arr) > 32 and len(arr) < 1024:
            self.shell_sort(arr)
        elif len(arr) > 1:

            mid = len(arr) // 2

            L, R = arr[:mid], arr[mid:]

            self.shell_merge_sort(L)
            self.shell_merge_sort(R)

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

    def merge_sort(self, arr):
        if len(arr) > 1:

            mid = len(arr) // 2

            L, R = arr[:mid], arr[mid:]
            self.merge_sort(L)
            self.merge_sort(R)

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


def run_merge(arr):
    print("Merge sort")
    sort = MergeSort()
    time_start = time.perf_counter()
    array = arr.copy()
    sort.run(array)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


def run_shell_merge(arr):
    print("Shell merge sort")
    sort = MergeSort()
    time_start = time.perf_counter()
    array = arr.copy()
    sort.run_shell_merge(array)
    elapsed_time = (time.perf_counter() - time_start) * 1000
    print(f"Elapsed time: {elapsed_time:0.0f} millis")


# data = [0, 1, 2, 3, 4, 5, 6, 9, 8, 7]

create_bytes_file(3000000)
data = read_bytes_file()
run_merge(data)
run_shell_merge(data)
