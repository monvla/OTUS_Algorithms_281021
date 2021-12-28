import java.util.ArrayList;

public class MyHashTable {

    private static final int N = 2;

    HashEntry[] items = new HashEntry[N];

    private class HashEntry {

        HashEntry(Object key, int value, HashEntry previousEntry) {
            this.key = key;
            this.value = value;
            this.previousEntry = previousEntry;
        }

        public Object key;
        public int value;
        HashEntry previousEntry;
    }

    public void put(Object key, int value) {
        HashEntry currentValue = items[key.hashCode() % N];
        if (currentValue == null) {
            items[key.hashCode() % N] = new HashEntry(key, value, null);
        } else {
            items[key.hashCode() % N] = new HashEntry(key, value, currentValue);
        }
    }

    public int get(Object key) {
        HashEntry lastEntry = items[key.hashCode() % N];
        while (lastEntry.key != key) {
            lastEntry = lastEntry.previousEntry;
        }
        return lastEntry.value;
    }
}
