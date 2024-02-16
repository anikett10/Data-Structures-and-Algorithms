/**
 * This Java class, MyLongArray, provides a menu-driven program to perform various
 operations
 * on a long array. The available operations include creating an array, finding an element
 * in the array, inserting an element at a specific location, finding an element at a
 * specific location, deleting an element at a specific location, displaying the array,
 * deleting duplicate elements, and demonstrating array operations like initialization,
 * sorting using Bubble Sort, Selection Sort, and Insertion Sort.
 *
 * @author Aniket Bhangale
 * @version 1.0
 * @since September 15, 2023
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class MyLongArray {
    // Class fields
    private static int size;
    private static long[] arr;
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    /**
     * The main method that serves as the entry point for the program. It presents a menu
     * to the user and executes the selected operation.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("---MENU---");
            System.out.println("1. To create an array\n");
            System.out.println("2. To find an element in the array\n");
            System.out.println("3. To insert an element in the array\n");
            System.out.println("4. To find an element at a specific location\n");
            System.out.println("5. To delete an element at a specific location\n");
            System.out.println("6. To display the array\n");
            System.out.println("7. To delete duplicate elements\n");
            System.out.println("8. To exit program\n");
            System.out.println("9. Demonstrate Array Operations\n");

            System.out.println("Enter your choice: \n");
            int ch = sc.nextInt();
            switch (ch) {
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
                    System.out.println("Exiting the program\n");
                    System.exit(0);
                    break;
                case 9:
                    demonstrateArrayOperations();
                    break;
                default:
                    System.out.println("Invalid input\n");
            }
        }
    }
    /**
     * This method creates an array by taking user input for the size and elements of
     * the array.
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
     * This method deletes an element at a specific location in the array.
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
     * This method finds the count of a given element in the array.
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
     * This method inserts an element at a specific location in the array.
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
     * This method deletes duplicate elements in the array.
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
     * This method retrieves and displays an element at a specific location in the array.
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
     * This method displays the elements of the array.
     */
    public static void display() {
        System.out.println("The given array is:");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
    /**
     * This method demonstrates various array operations, including initialization with
     * random values and sorting using different algorithms.
     */
    public static void demonstrateArrayOperations() {
        if (size == 0) {
            System.out.println("Array is empty. Please create the array first.");
            return;
        }
        System.out.println("Demonstrating Array Operations: \n");
        System.out.println("1. Initialize Array with Random Values \n");
        System.out.println("2. Sort Array using Bubble Sort \n");
        System.out.println("3. Sort Array using Selection Sort \n");
        System.out.println("4. Sort Array using Insertion Sort \n");
        System.out.println("Enter your choice: ");
        int opChoice = sc.nextInt();
        switch (opChoice) {
            case 1:
                initArray();
                break;

            case 2:
                bubbleSort();
                break;
            case 3:
                selectionSort();
                break;
            case 4:
                insertionSort();
                break;
            default:
                System.out.println("Invalid operation choice.");
        }
    }
    /**
     * This method initializes the array with random values.
     */
    public static void initArray() {
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextLong();
        }
        System.out.println("Array initialized with random values.");
        display();
    }
    /**
     * This method sorts the array using Bubble Sort.
     */
    public static void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted using Bubble Sort:");
        display();
    }
    /**
     * This method sorts the array using Selection Sort.
     */
    public static void selectionSort() {

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Array sorted using Selection Sort:");
        display();
    }
    /**
     * This method sorts the array using Insertion Sort.
     */
    public static void insertionSort() {
        for (int i = 1; i < size; i++) {
            long key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using Insertion Sort:");
        display();
    }

}