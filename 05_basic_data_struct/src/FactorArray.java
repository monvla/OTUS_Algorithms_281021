public class FactorArray<T> implements IArray<T> {

    public T[] array;
    int count;

    public FactorArray() {
        array = (T[]) new Object[10];
        this.count = 0;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void add(T item) {
        resize();
        array[count++] = item;
    }

    @Override
    public T get(int index) {
        try {
            return array[index];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void insert(T item, int index) {
        if (index > count() - 1) {
            add(item);
            return;
        }
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        array = newArray;
        array[index] = item;
        count++;
        resize();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > count()) {
            return;
        }
        T[] newArray = (T[]) new Object[count - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        for (int i = index; i < newArray.length; i++) {
            newArray[i] = array[i + 1];
        }
        array = newArray;
        count--;
        resize();
    }

    @Override
    public void removeLast() {
        array[--count] = null;
        resize();
    }

    private void resize() {
        int newSize, copySize;
        if (count == array.length) {
            newSize = array.length * 2;
            copySize = array.length;
        } else if (count < array.length / 2) {
            newSize = array.length / 2;
            copySize = newSize;
        } else {
            return;
        }
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, copySize);
        array = newArray;
    }
}
