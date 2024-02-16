import java.util.Scanner;

/**
 * GenericStack class represents a generic stack data structure that can store elements of any data type.
 * It provides methods for pushing elements onto the stack, popping elements from the stack,
 * checking if the stack is empty, and displaying the stack contents.
 *
 * @param <T> the type of elements stored in the stack
 * @author: Aniket Bhangale
 */
class GenericStack<T> {
    private int maxSize;
    private int top;
    private Object[] stackArray;

    /**
     * Constructs a GenericStack with the specified maximum size.
     *
     * @param size the maximum size of the stack
     */
    public GenericStack(int size) {
        maxSize = size;
        stackArray = new Object[maxSize];
        top = -1;
    }

    /**
     * Pushes the given element onto the stack.
     *
     * @param value the element to be pushed onto the stack
     */
    public void push(T value) {
        if (top < maxSize - 1) {
            top++;
            stackArray[top] = value;
            System.out.println("Pushed element: " + value);
        } else {
            System.out.println("Stack overflow! Cannot push element: " + value);
        }
    }

    /**
     * Pops an element from the stack and returns it.
     *
     * @return the popped element, or null if the stack is empty
     */
    public T pop() {
        if (top >= 0) {
            @SuppressWarnings("unchecked")
            T poppedElement = (T) stackArray[top];
            top--;
            return poppedElement;
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Displays the elements of the stack.
     */
    public void displayStack() {
        if (top >= 0) {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }

    /**
     * The main method provides a menu-driven interface to interact with the GenericStack class.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        GenericStack<Integer> stack = new GenericStack<>(size);

        while (true) {
            System.out.println("1. Push  2. Pop  3. Display  4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int elementToPush = scanner.nextInt();
                    stack.push(elementToPush);
                    break;
                case 2:
                    Integer poppedElement = stack.pop();
                    if (poppedElement != null) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    stack.displayStack();
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
