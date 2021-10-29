
MAGIC_CONDITIONS = [
    lambda x, y: x < y,
    lambda x, y: x * y == 0,
    lambda x, y: x == y,
    lambda x, y: x + y == 24,
    lambda x, y: x + y < 30,
    lambda x, y: y % 2 == x % 2,
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
