public interface IArray<T> {
    int size();
    int count();
    void add(T item);
    void removeLast();
    T get(int index);
    void insert(T item, int index);
    void remove(int index);
}
