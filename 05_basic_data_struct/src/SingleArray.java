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
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > count()) {
            return;
        }
        T[] newArray = (T[]) new Object[count - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        for (int i = index; i < newArray.length - 1; i++) {
            newArray[i] = array[i+1];
        }
        array = newArray;
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
