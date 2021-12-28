public class Main {

    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        MyHashString test_key1 = new MyHashString("myKey1");
        MyHashString test_key2 = new MyHashString("myKey2");
        MyHashString test_key3 = new MyHashString("myKey3");
        MyHashString test_key4 = new MyHashString("myKey4");
        MyHashString test_key5 = new MyHashString("myKey5");
        MyHashString test_key6 = new MyHashString("myKey6");
        MyHashString test_key7 = new MyHashString("myKey7");
        MyHashString test_key8 = new MyHashString("myKey8");
        table.put(test_key1, 1337);
        table.put(test_key2, 1338);
        table.put(test_key3, 1339);
        table.put(test_key4, 1340);
        table.put(test_key5, 1341);
        table.put(test_key6, 1342);
        table.put(test_key7, 1343);
        table.put(test_key8, 1344);
        int getted_value = table.get(test_key4);
    }
}
