public interface IArray<T> {
    int size();
    int count();
    boolean isEmpty();
    void add(T item);
    T get(int index);
    void removeLast();
//    void put(T item, int index);
//    T remove(int index);
}
