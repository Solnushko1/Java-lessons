package HashTable;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashFunction<K, V> implements HTable<K, V> {
    private static final int DEFAULT_SIZE = 16;

    private int size;
    private int capacity;
    private List<Node<K, V>>[] table;


    @SuppressWarnings("unchecked")
    public HashFunction() {
        this.size = 0;
        this.capacity = DEFAULT_SIZE;
        this.table = (List<Node<K, V>>[]) new List[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        List<Node<K, V>> list = table[index];

        if (key instanceof Number) {
            int numKey = ((Number) key).intValue();
            if (numKey < 0) {
                throw new IllegalArgumentException("Key cannot be negative");
            }
        }
        if (list == null) {
            list = new LinkedList<>();
            table[index] = list;
        }
        //Repeat key check cycle, if the same node is found - update
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        list.add(new Node<>(key, value));
        size++;
        if (size > capacity * 0.75) {
            resize();
        }
    }

    //@Override
    public V get(K key) {
        int index = getIndex(key);
        List<Node<K, V>> list = table[index];
        if (list != null) {
            for (Node<K, V> node : list) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        List<Node<K, V>> list = table[index];
        if (list != null) {
            Iterator<Node<K, V>> iterator = list.iterator();
            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                if (node.key.equals(key)) {
                    iterator.remove();
                    size--;
                    return;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        List<Node<K, V>>[] newTable = new List[capacity];
        for (List<Node<K, V>> list : table) {
            if (list != null) {
                for (Node<K, V> entry : list) {
                    int index = getIndex(entry.key());
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }
                    newTable[index].add(entry);
                }
            }
        }
        table = newTable;
    }

    public void printAll() {
        for (int i = 0; i < capacity; i++) {
            List<Node<K, V>> list = table[i];
            if (list != null) {
//                System.out.println("[" + i + "]");
                for (Node<K, V> node : list) {
                    System.out.println(node.key + " " + node.value);
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K key() {
            return key;
        }


    }
}
