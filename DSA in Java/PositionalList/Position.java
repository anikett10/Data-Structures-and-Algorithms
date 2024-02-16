/**
 * The `Position` interface represents a position in a data structure,
 * allowing access to the element stored at that position and enabling
 * navigation to the next position in the data structure.
 */
public interface Position {
    /**
     * Returns the element stored at this position.
     *
     * @return The element stored at this position.
     */
    Object getElement();

    /**
     * Checks if there is a next position in the data structure.
     *
     * @return `true` if there is a next position, `false` otherwise.
     */
    boolean hasNext();

    /**
     * Returns the next position in the data structure.
     *
     * @return The next position in the data structure.
     */
    Position next();
}
