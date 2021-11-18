public class SingleArray<T> implements IArray<T> {

    private T[] array;
    private int count = 0;

    public SingleArray() {
        array = (T[]) new Object[0];
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
        if (count <= 0) {
            return;
        }
        array[--count] = null;
        resize();
    }

    private void resize() {
        T[] newArray = (T[]) new Object[count + 1];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }
}
