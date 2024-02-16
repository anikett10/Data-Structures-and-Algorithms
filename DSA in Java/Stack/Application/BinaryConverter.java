import java.util.Scanner;

/**
 * This program provides a method to convert integers to their binary representation using a stack.
 * The conversion is done by repeatedly dividing the input integer by 2 and storing the remainders
 * in a stack. The remainders are then popped from the stack to form the binary representation.
 *
 * @author Aniket Bhangale
 * @version 1.0
 * @since 2023-10-22
 */
class BinaryConverter {

    /**
     * Converts the given integer to its binary representation.
     *
     * @param number The integer to be converted.
     * @return The binary representation of the input integer as a string.
     */
    public static String convertToBinary(int number) {
        CustomStack<Integer> stack = new CustomStack<>();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        StringBuilder binaryRepresentation = new StringBuilder();
        Integer bit;
        while ((bit = stack.pop()) != null) {
            binaryRepresentation.append(bit);
        }

        return binaryRepresentation.toString();
    }

    /**
     * Main method to interact with the user and perform binary conversion.
     * Continuously prompts the user for an integer input until the user enters -1 to exit.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.println("Enter an integer (enter -1 to exit):");
            number = scanner.nextInt();

            if (number == -1) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            String binary = convertToBinary(number);
            System.out.println("Binary representation of " + number + " is: " + binary);
        }

        scanner.close();
    }
}

/**
 * A simple generic stack implementation using an array.
 */
class CustomStack<T> {
    private Object[] array;
    private int top = -1;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Initializes the stack with a default size.
     */
    public CustomStack() {
        array = new Object[DEFAULT_SIZE];
    }

    /**
     * Pushes the given item onto the stack.
     *
     * @param item The item to be pushed.
     */
    public void push(T item) {
        if (top == array.length - 1) {
            resize();
        }
        array[++top] = item;
    }

    /**
     * Pops an item from the top of the stack.
     *
     * @return The popped item, or null if the stack is empty.
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (top < 0) return null;
        return (T) array[top--];
    }

    /**
     * Resizes the stack array to double its current size.
     */
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
