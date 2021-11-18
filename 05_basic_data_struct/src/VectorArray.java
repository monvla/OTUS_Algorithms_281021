public class VectorArray<T> implements IArray<T> {

    public T[] array;
    int count;
    int vector;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) new Object[vector];
        this.count = 0;
    }

    public VectorArray() {
        this(100);
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
        array[count++] = item;
        resize();
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
            newSize = array.length + vector;
            copySize = array.length;
        } else if (count <= array.length - vector) {
            newSize = array.length - vector;
            copySize = newSize;
        } else {
            return;
        }
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, copySize);
        array = newArray;
    }
}
