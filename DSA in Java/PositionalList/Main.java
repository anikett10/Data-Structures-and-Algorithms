
/**
 * The `Main` class serves as the entry point of the program.
 * It provides a menu-driven interface for interacting with the `PositionalList` data structure.
 */
import java.util.Scanner;

public class Main {
    /**
     * The main method creates a `PositionalList` object and presents a menu to the
     * user
     * for performing various operations on the list.
     *
     * The user can add and remove elements from the list, search for elements,
     * print the
     * elements in the list, and get the size of the list. The program continues
     * running
     * until the user chooses to exit.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a new PositionalList object to store elements
        PositionalList list = new PositionalList();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Variable to control the main program loop
        boolean running = true;

        // Main program loop
        while (running) {
            // Display menu options to the user
            System.out.println("1. Add element at the beginning");
            System.out.println("2. Add element at the end");
            System.out.println("3. Add element before a specific position");
            System.out.println("4. Add element after a specific position");
            System.out.println("5. Remove element at a specific position");
            System.out.println("6. Remove element before a specific position");
            System.out.println("7. Remove element after a specific position");
            System.out.println("8. Search for an element");
            System.out.println("9. Print elements");
            System.out.println("10. Size of the list");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            try {
                // Read user choice
                int choice = scanner.nextInt();

                // Perform actions based on user choice
                switch (choice) {
                    case 1:
                        // Add element at the beginning of the list
                        System.out.print("Enter element: ");
                        Object firstElement = scanner.next();
                        list.addFirst(firstElement);
                        break;
                    case 2:
                        // Add element at the end of the list
                        System.out.print("Enter element: ");
                        Object lastElement = scanner.next();
                        list.addLast(lastElement);
                        break;
                    case 3:
                        // Add element before a specific position in the list
                        System.out.print("Enter position: ");
                        int positionBefore = scanner.nextInt();
                        System.out.print("Enter element: ");
                        Object elementBefore = scanner.next();
                        PositionalList.Position beforePosition = list.first();
                        for (int i = 0; i < positionBefore; i++) {
                            beforePosition = list.after(beforePosition);
                        }
                        list.addBefore(beforePosition, elementBefore);
                        break;
                    case 4:
                        // Add element after a specific position in the list
                        System.out.print("Enter position: ");
                        int positionAfter = scanner.nextInt();
                        System.out.print("Enter element: ");
                        Object elementAfter = scanner.next();
                        PositionalList.Position afterPosition = list.first();
                        for (int i = 0; i < positionAfter; i++) {
                            afterPosition = list.after(afterPosition);
                        }
                        list.addAfter(afterPosition, elementAfter);
                        break;
                    case 5:
                        // Remove element at a specific position in the list
                        System.out.print("Enter position to remove: ");
                        int positionToRemove = scanner.nextInt();
                        PositionalList.Position removePosition = list.first();
                        for (int i = 0; i < positionToRemove; i++) {
                            removePosition = list.after(removePosition);
                        }
                        list.remove(removePosition);
                        break;
                    case 6:
                        // Remove element before a specific position in the list
                        System.out.print("Enter position to remove before: ");
                        int positionBeforeToRemove = scanner.nextInt();
                        PositionalList.Position removeBeforePosition = list.first();
                        for (int i = 0; i < positionBeforeToRemove - 1; i++) {
                            removeBeforePosition = list.after(removeBeforePosition);
                        }
                        list.remove(removeBeforePosition);
                        break;
                    case 7:
                        // Remove element after a specific position in the list
                        System.out.print("Enter position to remove after: ");
                        int positionAfterToRemove = scanner.nextInt();
                        PositionalList.Position removeAfterPosition = list.first();
                        for (int i = 0; i < positionAfterToRemove; i++) {
                            removeAfterPosition = list.after(removeAfterPosition);
                        }
                        list.remove(removeAfterPosition);
                        break;
                    case 8:
                        // Search for an element in the list
                        System.out.print("Enter element to search: ");
                        Object elementToSearch = scanner.next();
                        try {
                            PositionalList.Position searchPosition = list.search(elementToSearch);
                            System.out.println("Element found: " + searchPosition.getElement());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 9:
                        // Print elements in the list
                        System.out.println("Elements in the list:");
                        for (Object element : list) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                        break;
                    case 10:
                        // Get the size of the list
                        System.out.println("Size of the list: " + list.size());
                        break;
                    case 11:
                        // Exit the program
                        System.out.println("Exiting program...");
                        running = false;
                        break;
                    default:
                        // Invalid choice
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
