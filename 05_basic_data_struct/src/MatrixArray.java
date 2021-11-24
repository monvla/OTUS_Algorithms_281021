public class MatrixArray<T> implements IArray<T> {

    private static final int NEW_ARRAY_LENGTH = 10;
    
    private T[][] array;
    private int valueIndex = 0;

    public MatrixArray() {
        array = (T[][]) new Object[1][NEW_ARRAY_LENGTH];
    }

    @Override
    public int size() {
        return array.length * NEW_ARRAY_LENGTH;
    }

    @Override
    public int count() {
        return (array.length - 1) * NEW_ARRAY_LENGTH + valueIndex;
    }

    @Override
    public void add(T item) {
        if (valueIndex == NEW_ARRAY_LENGTH) {
            array = resizeArray(array, true);
            valueIndex = 0;
        }
        array[array.length-1][valueIndex++] = item;
    }

    @Override
    public T get(int index) {
        try {
            return array[index / NEW_ARRAY_LENGTH][index % NEW_ARRAY_LENGTH];
        } catch (Exception e) {
            return null;
        }
    }

    private T[][] resizeArray(T[][] array, boolean isIncreasing) {
        int newArrayLength;
        if (isIncreasing) {
            newArrayLength = array.length + 1;
        } else {
            newArrayLength = array.length - 1;
        }
        T[][] newArray = (T[][]) new Object[newArrayLength][NEW_ARRAY_LENGTH];
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == null) {
                break;
            }
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public void insert(T item, int index) {
        if (index > count() - 1) {
            add(item);
            return;
        }
        T[][] newArray = (T[][]) new Object[index / NEW_ARRAY_LENGTH + 1][NEW_ARRAY_LENGTH];
        for (int i = 0; i < index / NEW_ARRAY_LENGTH; i++) {
            newArray[i] = array[i];
        }
        System.arraycopy(array[index / NEW_ARRAY_LENGTH], 0, newArray[index / NEW_ARRAY_LENGTH], 0, NEW_ARRAY_LENGTH);

        int swapIndex = index;
        newArray[swapIndex / NEW_ARRAY_LENGTH][swapIndex % NEW_ARRAY_LENGTH] = item;

        while (swapIndex <= array.length * NEW_ARRAY_LENGTH) {
            if (swapIndex / NEW_ARRAY_LENGTH == array.length
                    || array[swapIndex / NEW_ARRAY_LENGTH][swapIndex % NEW_ARRAY_LENGTH] == null) {
                break;
            }
            if (newArray.length == (swapIndex + 1) / NEW_ARRAY_LENGTH) {
                newArray = resizeArray(newArray, true);
            }
            newArray[(swapIndex + 1) / NEW_ARRAY_LENGTH][(swapIndex + 1) % NEW_ARRAY_LENGTH]
                    = array[swapIndex / NEW_ARRAY_LENGTH][swapIndex % NEW_ARRAY_LENGTH];
            swapIndex++;
        }
        array = newArray;
        valueIndex = swapIndex % NEW_ARRAY_LENGTH + 1;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > count()) {
            return;
        }

        T[][] newArray = (T[][]) new Object[array.length][NEW_ARRAY_LENGTH];
        for (int i = 0; i < (index / NEW_ARRAY_LENGTH); i++) {
            newArray[i] = array[i];
        }
        System.arraycopy(array[index / NEW_ARRAY_LENGTH], 0, newArray[index / NEW_ARRAY_LENGTH], 0, NEW_ARRAY_LENGTH);

        int swapIndex = index;
        while (swapIndex <= array.length * NEW_ARRAY_LENGTH) {
            T swapItem = get(swapIndex + 1);
            if (swapItem == null) {
                break;
            }
            newArray[swapIndex / NEW_ARRAY_LENGTH][swapIndex % NEW_ARRAY_LENGTH] = swapItem;
            swapIndex++;
        }
        if (newArray[array.length-1][0] == null) {
            newArray = resizeArray(newArray, false);
        }
        array = newArray;
        if (valueIndex == 1) {
            valueIndex = NEW_ARRAY_LENGTH;
        } else {
            valueIndex--;
        }
    }

    @Override
    public void removeLast() {
        if (valueIndex >= 0) {
            array[array.length-1][valueIndex-1] = null;
        }
        valueIndex--;
    }

}
