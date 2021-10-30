from math import *


MAGIC_CONDITIONS = [
    lambda x, y: x < y,
    lambda x, y: x * y == 0,
    lambda x, y: x == y,
    lambda x, y: x + y == 24,
    lambda x, y: x == y or x + y == 24,
    lambda x, y: x + y < 30,
    lambda x, y: y % 2 == x % 2,
    lambda x, y: y > 15 and x > 15,
    lambda x, y: x < 10 or y < 10,
    lambda x, y: x == int(y / 2),
    lambda x, y: x == 1 or y == 1 or y == 23 or x == 23,
    lambda x, y: x / 24 == 1 or y / 24 == 1 or x / 1 == 0 or y / 1 == 0,
    lambda x, y: x % 6 == 0 or y % 6 == 0
]

def show_some_magic(magic_condition):
    for x in range(25):
        console_row = []
        for y in range(25):
            console_row.append("# " if magic_condition(x, y) else ". ")
        print("".join(console_row))

for idx, condition in enumerate(MAGIC_CONDITIONS):
    print("")
    print("=" * 25 + "MAGIC CONDITION №%s" % (idx + 1) + "=" * 25)
    print("")
    show_some_magic(condition)
