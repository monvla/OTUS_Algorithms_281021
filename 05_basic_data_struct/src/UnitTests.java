public class UnitTests {

    public void testCount() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);
        assert single.count() == 32;
        assert vector.count() == 32;
        assert factor.count() == 32;
        assert matrix.count() == 32;

        single.removeLast();
        vector.removeLast();
        factor.removeLast();
        matrix.removeLast();
        assert single.count() == 31;
        assert vector.count() == 31;
        assert factor.count() == 31;
        assert matrix.count() == 31;

        single.add(1234);
        vector.add(1234);
        factor.add(1234);
        matrix.add(1234);
        assert single.count() == 32;
        assert vector.count() == 32;
        assert factor.count() == 32;
        assert matrix.count() == 32;
    }

    public void testGet() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);
        assert single.get(14) == 14;
        assert vector.get(14) == 14;
        assert factor.get(14) == 14;
        assert matrix.get(14) == 14;

        assert single.get(33) == null;
        assert vector.get(33) == null;
        assert factor.get(33) == null;
        assert matrix.get(33) == null;

        assert single.get(-1) == null;
        assert vector.get(-1) == null;
        assert factor.get(-1) == null;
        assert matrix.get(-1) == null;
    }

    public void testAdd() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);
        single.add(1337);
        vector.add(1337);
        factor.add(1337);
        matrix.add(1337);
        assert single.get(32) == 1337;
        assert vector.get(32) == 1337;
        assert factor.get(32) == 1337;
        assert matrix.get(32) == 1337;
    }

    public void testInsert() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);
        single.insert(1337, 12);
        vector.insert(1337, 12);
        factor.insert(1337, 12);
        matrix.insert(1337, 12);
        assert single.get(12) == 1337;
        assert vector.get(12) == 1337;
        assert factor.get(12) == 1337;
        assert matrix.get(12) == 1337;

        assert single.get(11) == 11;
        assert vector.get(11) == 11;
        assert factor.get(11) == 11;
        assert matrix.get(11) == 11;

        assert single.get(13) == 12;
        assert vector.get(13) == 12;
        assert factor.get(13) == 12;
        assert matrix.get(13) == 12;
    }

    public void testRemoveLast() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);

        single.removeLast();
        vector.removeLast();
        factor.removeLast();
        matrix.removeLast();

        assert single.get(31) == null;
        assert vector.get(31) == null;
        assert factor.get(31) == null;
        assert matrix.get(31) == null;

        assert single.get(30) == 30;
        assert vector.get(30) == 30;
        assert factor.get(30) == 30;
        assert matrix.get(30) == 30;

        assert single.count() == 31;
        assert vector.count() == 31;
        assert factor.count() == 31;
        assert matrix.count() == 31;
    }

    public void testRemoveIndex() {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();

        fillArray(single, 32);
        fillArray(vector, 32);
        fillArray(factor, 32);
        fillArray(matrix, 32);

        single.remove(12);
        vector.remove(12);
        factor.remove(12);
        matrix.remove(12);
        single.remove(9999);
        vector.remove(9999);
        factor.remove(9999);
        matrix.remove(9999);
        assert single.get(11) == 11;
        assert vector.get(11) == 11;
        assert factor.get(11) == 11;
        assert matrix.get(11) == 11;

        assert single.get(12) == 13;
        assert vector.get(12) == 13;
        assert factor.get(12) == 13;
        assert matrix.get(12) == 13;
    }

    private void fillArray(IArray<Integer> array, int size) {
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
    }
}
