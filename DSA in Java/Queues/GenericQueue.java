/**
 * GenericQueue class represents a generic queue data structure that can hold elements of any data type.
 * It provides methods to enqueue, dequeue, check if the queue is empty, and display its elements.
 *
 * @param <T> The generic type of elements that the queue can hold.
 * @author: Aniket Bhangale
 * @version 1.0
 */

import java.util.Scanner;

public class GenericQueue<T> {
    private int maxSize;
    private Object[] queueArray;
    private int front;
    private int rear;

    /**
     * Constructs a GenericQueue object with the specified size.
     *
     * @param size The maximum number of elements the queue can hold.
     */
    public GenericQueue(int size) {
        maxSize = size;
        queueArray = new Object[maxSize];
        front = 0;
        rear = -1;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param value The element to be added to the queue.
     */
    public void enqueue(T value) {
        if (rear < maxSize - 1) {
            rear++;
            queueArray[rear] = value;
            System.out.println("Enqueued element: " + value);
        } else {
            System.out.println("Queue is full. Cannot enqueue element: " + value);
        }
    }

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return The dequeued element, or null if the queue is empty.
     */
    public T dequeue() {
        if (front <= rear) {
            @SuppressWarnings("unchecked")
            T dequeuedElement = (T) queueArray[front];
            front++;
            return dequeuedElement;
        } else {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return null;
        }
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front > rear;
    }

    /**
     * Displays the elements of the queue.
     */
    public void displayQueue() {
        if (!isEmpty()) {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    /**
     * Main method to demonstrate the usage of the GenericQueue class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        GenericQueue<Integer> queue = new GenericQueue<>(size);

        while (true) {
            System.out.println("1. Enqueue  2. Dequeue  3. Display  4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int elementToEnqueue = scanner.nextInt();
                    queue.enqueue(elementToEnqueue);
                    break;
                case 2:
                    Integer dequeuedElement = queue.dequeue();
                    if (dequeuedElement != null) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
