/**
 * An interface representing a single node or entry in the heap priority queue.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface Entry<K, V> {

    /**
     * Accessor method to retrieve the key of the entry.
     *
     * @return The key of the entry.
     */
    K getKey();

    /**
     * Accessor method to retrieve the data stored at the entry.
     *
     * @return The data stored at the entry.
     */
    V getValue();
}
