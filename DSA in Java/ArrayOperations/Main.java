import java.util.Scanner;
import java.util.Arrays;
/**
 * The Main class implements a menu-driven program for performing various operations
 * on a long array. These operations include creating an array, finding elements,
 * inserting elements, deleting elements, displaying the array, and removing duplicates.
 * Users can choose different operations by selecting options from the menu.
 *
 * This class utilizes the Scanner class for user input and the Arrays class for array
 manipulation.
 *
 * @author Aniket Bhangale
 * @version 1.0
 * @since September 15, 2023
 */
public class Main {
    /** The size of the array. */
    private static int size;
    /** The array to perform operations on. */
    static long[] arr;
    /** The scanner object for taking user input. */
    static Scanner sc = new Scanner(System.in);
    /**
     * The main method where the program starts execution.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
// Continuously display the menu and perform operations based on user input.
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MyLongArray();
                    break;
                case 2:
                    findElem();

                    break;
                case 3:
                    insertIndex();
                    break;
                case 4:
                    getElem();
                    break;
                case 5:
                    deleteAt();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    dupDelete();
                    break;
                case 8:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    /**
     * Displays the menu of available operations to the user.
     */
    private static void displayMenu() {
        System.out.println("*** MENU ***");
        System.out.println("1. To create an array");
        System.out.println("2. To find an element in the array");
        System.out.println("3. To insert an element in the array");
        System.out.println("4. To find an element at a specific location");
        System.out.println("5. To delete an element at a specific location");
        System.out.println("6. To display the array");
        System.out.println("7. To delete duplicate elements");
        System.out.println("8. To exit the program");
        System.out.print("Enter your choice: ");
    }
    /**
     * Creates a new long array based on user input for size and elements.
     */
    public static void MyLongArray() {

        System.out.println("Enter the size of the array:");
        size = sc.nextInt();
        arr = new long[size];
        System.out.println("Enter " + size + " elements in the array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println("Entered elements are:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    /**
     * Deletes an element at a specific location in the array.
     */
    public static void deleteAt() {
        System.out.println("Enter the location of element in array to delete:");
        int loc = sc.nextInt();
        for (int i = loc; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
    /**
     * Finds the specified element in the array and displays the number of occurrences.
     */
    public static void findElem() {
        System.out.println("Enter the search element: ");
        int n = sc.nextInt();
        int count = 0;
        for (long element : arr) {
            if (element == n) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Item found " + count + " time(s)");
        } else {
            System.out.println("Item not found");

        }
    }
    /**
     * Inserts a new element at a specific location in the array.
     */
    public static void insertIndex() {
        if (size == 0) {
            System.out.println("Array is empty. Please create the array first.");
            return;
        }
        System.out.println("Enter the location of the element to replace (0 to " + (size - 1) + "):");
        int loc = sc.nextInt();
        if (loc < 0 || loc >= size) {
            System.out.println("Invalid location. Location must be between 0 and " + (size - 1));
            return;
        }
        System.out.println("Enter the new element: ");
        int newElem = sc.nextInt();
        arr[loc] = newElem;
        System.out.println("Array after replacing element:");
        display();
    }
    /**
     * Deletes duplicate elements from the array and displays the modified array.
     */
    public static void dupDelete() {
        Arrays.sort(arr);
        int temp[] = new int[size];
        int j = 0;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = (int) arr[i];
            }
        }
        temp[j++] = (int) arr[size - 1];
        System.out.println("Array after deleting duplicates:");
        for (int k = 0; k < j; k++) {
            System.out.println(temp[k]);

        }
    }
    /**
     * Finds and displays the element at a specific location in the array.
     */
    public static void getElem() {
        System.out.println("Enter the location of element to search:");
        int n = sc.nextInt();
        if (n >= 0 && n < size) {
            System.out.println("Element at index " + n + ": " + arr[n]);
        } else {
            System.out.println("Invalid index");
        }
    }
    /**
     * Displays the elements of the array.
     */
    public static void display() {
        System.out.println("The given array is:");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

}