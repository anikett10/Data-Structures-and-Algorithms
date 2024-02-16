# GenericStack Java Class 

## Overview

The `GenericStack` Java class provides a generic stack data structure that can store elements of any data type. It includes methods for pushing elements onto the stack, popping elements from the stack, checking if the stack is empty, and displaying the stack contents. The class utilizes generics to allow flexibility in the type of elements it can store.

## Class Structure

- **GenericStack\<T\>**: This class represents the generic stack data structure. It includes the following methods:
  - **`push(T value)`:** Pushes the given element onto the stack.
  - **`pop()`:** Pops an element from the stack and returns it.
  - **`isEmpty()`:** Checks if the stack is empty.
  - **`displayStack()`:** Displays the elements of the stack.

## Usage

1. **Compilation**: Compile the Java class using a Java compiler (e.g., `javac GenericStack.java`).

2. **Execution**: Run the compiled program using the Java Virtual Machine (e.g., `java GenericStack`).

3. **Menu-Driven Interface**: The program provides a menu-driven interface for interacting with the `GenericStack` class.

   - **Push Operation**: Choose option 1 to push an element onto the stack.
   
   - **Pop Operation**: Choose option 2 to pop an element from the stack.
   
   - **Display Operation**: Choose option 3 to display the current stack contents.
   
   - **Exit**: Choose option 4 to exit the program.

4. **Generic Usage**: The stack can store elements of any data type. The user specifies the data type when creating the stack instance (e.g., `GenericStack<Integer> stack = new GenericStack<>(size);` for storing integers).

## Example

Here is an example of how to use the `GenericStack` class:

1. Run the program.

2. Enter the size of the stack.

3. Choose options from the menu to push elements onto the stack, pop elements, display the stack, and exit the program.

## Author

- **Author**: Aniket Bhangale

## Dependencies

- The class uses Java's built-in libraries, including `java.util.Scanner`.

