import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The `PositionalList` class implements a doubly linked list that supports
 * positional access to its elements. It provides methods to add, remove,
 * and search for elements within the list, as well as iterate through the
 * elements.
 * The list is iterable and allows traversal through its positions.
 */
public class PositionalList implements Iterable<Object> {

    /**
     * The `Node` class represents nodes in the doubly linked list.
     * Each node contains an element and references to its previous and next nodes.
     * It implements the `Position` interface, allowing positional access to the
     * list.
     */
    private class Node implements Position {
        Object element;
        Node prev;
        Node next;

        /**
         * Constructs a new node with the given element, previous node, and next node.
         *
         * @param element The element to be stored in the node.
         * @param prev    The previous node in the list.
         * @param next    The next node in the list.
         */
        Node(Object element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        /**
         * Checks if there is a next position in the list.
         *
         * @return `true` if there is a next position, `false` otherwise.
         */
        public boolean hasNext() {
            return next != null;
        }

        /**
         * Returns the next position in the list.
         *
         * @return The next position in the list.
         */
        public Position next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list");
            }
            return next;
        }

        /**
         * Returns the element stored at this position.
         *
         * @return The element stored at this position.
         */
        public Object getElement() {
            return element;
        }
    }

    /**
     * The `Position` interface represents a position in the `PositionalList`.
     * It provides methods to access the element stored at the position,
     * check if there is a next position, and retrieve the next position.
     */
    public interface Position {
        /**
         * Returns the element stored at this position.
         *
         * @return The element stored at this position.
         */
        Object getElement();

        /**
         * Checks if there is a next position in the list.
         *
         * @return `true` if there is a next position, `false` otherwise.
         */
        boolean hasNext();

        /**
         * Returns the next position in the list.
         *
         * @return The next position in the list.
         */
        Position next();
    }

    private Node header;
    private Node trailer;
    private int size;

    /**
     * Constructs an empty `PositionalList` with a header and a trailer node.
     * The header and trailer nodes serve as sentinel nodes to simplify
     * boundary cases and avoid null references.
     */
    public PositionalList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return `true` if the list is empty, `false` otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first position in the list.
     *
     * @return The first position in the list.
     */
    public Position first() {
        return header.next;
    }

    /**
     * Returns the last position in the list.
     *
     * @return The last position in the list.
     */
    public Position last() {
        return trailer.prev;
    }

    /**
     * Returns the position before the given position.
     *
     * @param p The position for which to find the predecessor.
     * @return The position before the given position.
     */
    public Position before(Position p) {
        Node node = (Node) p;
        return node.prev;
    }

    /**
     * Returns the position after the given position.
     *
     * @param p The position for which to find the successor.
     * @return The position after the given position.
     */
    public Position after(Position p) {
        Node node = (Node) p;
        return node.next;
    }

    /**
     * Adds an element to the beginning of the list and returns its position.
     *
     * @param element The element to be added to the list.
     * @return The position of the newly added element.
     */
    public Position addFirst(Object element) {
        return addBetween(element, header, header.next);
    }

    /**
     * Adds an element to the end of the list and returns its position.
     *
     * @param element The element to be added to the list.
     * @return The position of the newly added element.
     */
    public Position addLast(Object element) {
        return addBetween(element, trailer.prev, trailer);
    }

    /**
     * Adds an element before the given position in the list and returns its
     * position.
     *
     * @param p       The position before which the element will be added.
     * @param element The element to be added to the list.
     * @return The position of the newly added element.
     */
    public Position addBefore(Position p, Object element) {
        Node node = (Node) p;
        return addBetween(element, node.prev, node);
    }

    /**
     * Adds an element after the given position in the list and returns its
     * position.
     *
     * @param p       The position after which the element will be added.
     * @param element The element to be added to the list.
     * @return The position of the newly added element.
     */
    public Position addAfter(Position p, Object element) {
        Node node = (Node) p;
        return addBetween(element, node, node.next);
    }

    /**
     * Adds a new node with the given element between the given previous and next
     * nodes.
     *
     * @param element The element to be added to the list.
     * @param prev    The previous node in the list.
     * @param next    The next node in the list.
     * @return The position of the newly added element.
     */
    private Position addBetween(Object element, Node prev, Node next) {
        Node newNode = new Node(element, prev, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
        return newNode;
    }

    /**
     * Removes the given position from the list and returns its element.
     *
     * @param p The position to be removed from the list.
     * @return The element stored at the removed position.
     */
    public Object remove(Position p) {
        Node node = (Node) p;
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
        size--;
        return node.element;
    }

    /**
     * Searches for the given element in the list and returns its position.
     * If the element is not found, it throws an `IllegalArgumentException`.
     *
     * @param element The element to search for in the list.
     * @return The position of the element in the list.
     * @throws IllegalArgumentException If the element is not found in the list.
     */
    public Position search(Object element) {
        Node currentNode = header.next;
        while (currentNode != trailer) {
            if (currentNode.element.equals(element)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        throw new IllegalArgumentException("Element not found in the list.");
    }

    /**
     * Returns an iterator for the elements in the `PositionalList`.
     *
     * @return An iterator for the elements in the list.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private Position current = header.next;

            /**
             * Checks if there is a next element in the list.
             *
             * @return `true` if there is a next element, `false` otherwise.
             */
            @Override
            public boolean hasNext() {
                return current != trailer;
            }

            /**
             * Returns the next element in the list.
             *
             * @return The next element in the list.
             */
            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list");
                }
                Object element = current.getElement();
                current = current.next();
                return element;
            }
        };
    }
}
