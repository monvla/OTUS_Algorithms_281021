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
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T item) {
        resize();
        array[count++] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
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
