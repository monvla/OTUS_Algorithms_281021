public class MatrixArray<T> implements IArray<T> {

    private static final int NEW_ARRAY_LENGTH = 100;
    
    private T[][] array;
    private int arraysIndex = 0;
    private int valueIndex = 0;

    public MatrixArray() {
        array = (T[][]) new Object[1][NEW_ARRAY_LENGTH];
    }

    @Override
    public int size() {
        return (arraysIndex + 1) * NEW_ARRAY_LENGTH;
    }

    @Override
    public int count() {
        return arraysIndex * NEW_ARRAY_LENGTH + valueIndex;
    }

    @Override
    public void add(T item) {
        if (valueIndex == NEW_ARRAY_LENGTH) {
            resize();
            valueIndex = 0;
        }
        array[arraysIndex][valueIndex++] = item;
    }

    @Override
    public T get(int index) {
        return array[index / NEW_ARRAY_LENGTH][index % NEW_ARRAY_LENGTH];
    }

    @Override
    public void removeLast() {
        if (valueIndex >= 0) {
            array[arraysIndex][valueIndex--] = null;
        }
        if (valueIndex < 0 && arraysIndex >= 0) {
            array[arraysIndex--] = null;
            valueIndex = NEW_ARRAY_LENGTH - 1;
        }
    }

    private void resize() {
        arraysIndex++;
        T[][] newArray = (T[][]) new Object[arraysIndex + 1][NEW_ARRAY_LENGTH];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, array[i].length);
        }
        array = newArray;
    }

}
