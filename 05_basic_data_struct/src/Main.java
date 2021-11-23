

public class Main {

    public static void main(String[] args) {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();
        testPut(single, 32);
        testPut(vector, 32);
        testPut(factor, 32);
        testPut(matrix, 32);

        UnitTests tests = new UnitTests();
        tests.testCount();
        tests.testGet();
        tests.testAdd();
        tests.testInsert();
        tests.testRemoveLast();
        tests.testRemoveIndex();
    }

    private static void testPut(IArray<Integer> array, int total) {
        System.out.println("============= " + array + " test ============= ");
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.add(j);
        }
        array.removeLast();
        System.out.println("items count: " + array.count());
        System.out.println("size: " + array.size());
        System.out.println("get 28 item: " + array.get(28));
        System.out.println("get 29 item: " + array.get(29));
        System.out.println("get 30 item: " + array.get(30));
        System.out.println("get 31 item: " + array.get(31));
        System.out.println("get 32 item: " + array.get(32));
        System.out.println("get 33 item: " + array.get(33));
        System.out.println("add: " + (System.currentTimeMillis() - start) + " ms");
    }
}
