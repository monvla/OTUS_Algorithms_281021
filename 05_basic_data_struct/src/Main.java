

public class Main {

    public static void main(String[] args) {
        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>();
        IArray<Integer> factor = new FactorArray<>();
        IArray<Integer> matrix = new MatrixArray<>();
        testPut(single, 200_001);
        testPut(vector, 200_001);
        testPut(factor, 200_001);
        testPut(matrix, 200_001);
    }

    private static void testPut(IArray<Integer> array, int total) {
        System.out.println("============= " + array + " test ============= ");
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.add(j);
        }
        array.removeLast();
        array.removeLast();
        System.out.println("items count: " + array.count());
        System.out.println("size: " + array.size());
        System.out.println("get 1000 item: " + array.get(1000));
        System.out.println("add: " + (System.currentTimeMillis() - start) + " ms");
    }
}
