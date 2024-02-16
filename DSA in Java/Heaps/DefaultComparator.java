import java.util.Comparator;

/**
 * Built-in comparator by Java.
 *
 * @param <E> The type of elements to be compared.
 */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compare two elements based on:
     * i < 0
     * i = 0
     * i > 0
     *
     * @return i The result of the comparison.
     * @throws ClassCastException If the elements are not comparable.
     */
    @SuppressWarnings("unchecked")
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
