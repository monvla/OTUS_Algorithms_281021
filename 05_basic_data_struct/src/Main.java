

public class Main {

    public static void main(String[] args) {
        runExecutionTimeTests(1000);
        runExecutionTimeTests(10000);
        runExecutionTimeTests(100000);
        runExecutionTimeTests(1000000);
        runExecutionTimeTests(10000000);

        UnitTests tests = new UnitTests();
        tests.testCount();
        tests.testGet();
        tests.testAdd();
        tests.testInsert();
        tests.testRemoveLast();
        tests.testRemoveIndex();
    }

    private static void runExecutionTimeTests(int total) {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();
        calculateExecutionTime(single, total);
//        calculateExecutionTime(vector, total);
//        calculateExecutionTime(factor, total);
//        calculateExecutionTime(matrix, total);
    }

    private static void calculateExecutionTime(IArray<Integer> array, int total) {
        System.out.println("============= " + array + " execution time test; TOTAL: " + total + " ============= ");
        // ADD
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.add(j);
        }
        System.out.println("add: " + (System.currentTimeMillis() - start) + " ms");
        // REMOVE LAST
        start = System.currentTimeMillis();
        array.removeLast();
        System.out.println("remove last: " + (System.currentTimeMillis() - start) + " ms");
        // INSERT 0
        start = System.currentTimeMillis();
        array.insert(1337, 0);
        System.out.println("insert 0: " + (System.currentTimeMillis() - start) + " ms");
        // REMOVE 0
        start = System.currentTimeMillis();
        array.remove(0);
        System.out.println("remove 0: " + (System.currentTimeMillis() - start) + " ms");
        // INSERT
        start = System.currentTimeMillis();
        array.insert(1337, getRandomNumber(0, total - 1));
        System.out.println("insert rand: " + (System.currentTimeMillis() - start) + " ms");
        // REMOVE
        start = System.currentTimeMillis();
        array.remove(getRandomNumber(0, total - 1));
        System.out.println("remove rand: " + (System.currentTimeMillis() - start) + " ms");
        // GET
        start = System.currentTimeMillis();
        array.get(31);
        System.out.println("get: " + (System.currentTimeMillis() - start) + " ms");
    }

//    private static void testPut(IArray<Integer> array, int total) {
//        System.out.println("============= " + array + " test ============= ");
//        long start = System.currentTimeMillis();
//        for (int j = 0; j < total; j++) {
//            array.add(j);
//        }
//        array.remove(29);
//        System.out.println("items count: " + array.count());
//        System.out.println("size: " + array.size());
//        System.out.println("get 27 item: " + array.get(27));
//        System.out.println("get 28 item: " + array.get(28));
//        System.out.println("get 29 item: " + array.get(29));
//        System.out.println("get 30 item: " + array.get(30));
//        System.out.println("get 31 item: " + array.get(31));
//        System.out.println("get 32 item: " + array.get(32));
//        System.out.println("add: " + (System.currentTimeMillis() - start) + " ms");
//    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
