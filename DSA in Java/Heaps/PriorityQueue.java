// PriorityQueue.java
public interface PriorityQueue<K, V> {
    boolean isEmpty();
    int size();
    Entry<K, V> insert(K key, V value);
    Entry<K, V> min();
    Entry<K, V> removeMin();
}
