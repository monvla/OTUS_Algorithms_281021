import os.path
import time


class Task:
    def run(self, data):
        pass

    def prepare_result(self, result):
        return str(result)


class Tester:
    def __init__(self, task, path):
        self.task = task
        self.path = path

    def run_tests(self):
        test_number = 0
        while True:
            in_file_path = os.path.join(self.path, "test.%s.in" % test_number)
            out_file_path = os.path.join(self.path, "test.%s.out" % test_number)
            if (not os.path.isfile(in_file_path) or
                    not os.path.isfile(out_file_path)):
                break
            time_start = time.perf_counter()
            expect, actual = self.run_test(in_file_path, out_file_path)
            elapsed_time = (time.perf_counter() - time_start) * 1000
            is_passed = expect == actual
            print("Test №%s - %s; %s" % (
                test_number,
                "passed" if is_passed else "failed",
                f"Elapsed time: {elapsed_time:0.0f} millis")
                  )
            if not is_passed:
                print("Expect: %s; actual: %s" % (expect, actual))
            test_number += 1

    def run_test(self, in_file, out_file):
        with open(in_file) as f:
            data = [line.strip() for line in f.readlines()]
        with open(out_file) as f:
            expect = f.read().strip()
        actual = self.task.run(data)
        return expect, actual
