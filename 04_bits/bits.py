import pathlib
from console_tester import *


class BitsTask(Task):

    clear_overflow = 18446744073709551615

    def __init__(self):
        self.cached_bits = []
        for i in range(256):
            self.cached_bits.append(self.population_counter_optimized(i))

    def population_counter(self, mask):
        """ Подсчет числа бит через сдвиг """
        count = 0
        while mask > 0:
            if (mask & 1) == 1:
                count += 1
            mask >>= 1
        return count

    def population_counter_optimized(self, mask):
        """ Подсчет числа бит через вычитание 1 """
        count = 0
        while mask > 0:
            mask &= mask - 1
            count += 1
        return count

    def population_counter_cached(self, mask):
        """ Подсчет числа бит через кеширование """
        count = self.cached_bits[mask & 0xff] + \
                self.cached_bits[(mask >> 8) & 0xff] + \
                self.cached_bits[(mask >> 16) & 0xff] + \
                self.cached_bits[(mask >> 24) & 0xff] + \
                self.cached_bits[(mask >> 32) & 0xff] + \
                self.cached_bits[(mask >> 40) & 0xff] + \
                self.cached_bits[(mask >> 48) & 0xff] + \
                self.cached_bits[(mask >> 56) & 0xff]
        return count


class BitsKing(BitsTask):

    def run(self, data):
        K = 1 << int(data[0])
        noH = 18374403900871474942
        noA = 9187201950435737471
        KnoH = K & noH
        KnoA = K & noA
        king_moves = (KnoA << 9) | (K << 8) | (KnoH << 7) | \
                     (KnoA << 1) |            (KnoH >> 1) | \
                     (KnoA >> 7) | (K >> 8) | (KnoH >> 9)
        king_moves &= self.clear_overflow
        count = self.population_counter_cached(king_moves)
        return self.prepare_result("%s\n%s" % (count, king_moves))


class BitsKnight(BitsTask):

    def run(self, data):
        K = 1 << int(data[0])
        noGH = 4557430888798830399
        noAB = 18229723555195321596
        KnoGH = K & noGH
        KnoAB = K & noAB

        knight_moves = (KnoAB << 6) | (KnoAB << 15) | (KnoGH << 17) | (KnoGH << 10) | \
                       (KnoGH >> 6) | (KnoAB >> 10) | (KnoGH >> 15) | (KnoAB >> 17)
        knight_moves &= self.clear_overflow
        count = self.population_counter_cached(knight_moves)
        return self.prepare_result("%s\n%s" % (count, knight_moves))


class BitsRook(BitsTask):

    def run(self, data):
        position = int(data[0])
        R = 1 << position

        rook_row = 255
        rook_col = 72340172838076673
        rook_row <<= 8 * int(position / 8)
        rook_col <<= 1 * (position % 8)
        rook_moves = R ^ rook_row | R ^ rook_col
        rook_moves &= self.clear_overflow
        count = self.population_counter_cached(rook_moves)
        return self.prepare_result("%s\n%s" % (count, rook_moves))


# task1 = BitsKing()
# tester1 = Tester(
#     task1,
#     os.path.join(pathlib.Path(__file__).parent.resolve(), "0.BITS", "1.Bitboard - Король")
# )
# tester1.run_tests()

# task2 = BitsKnight()
# tester2 = Tester(
#     task2,
#     os.path.join(pathlib.Path(__file__).parent.resolve(), "0.BITS", "2.Bitboard - Конь")
# )
# tester2.run_tests()

task3 = BitsRook()
tester3 = Tester(
    task3,
    os.path.join(pathlib.Path(__file__).parent.resolve(), "0.BITS", "3.Bitboard - Ладья")
)
tester3.run_tests()

