# Binary Converter with Stack 

## Overview

The **Binary Converter** program provides a method to convert integers to their binary representation using a stack data structure. The conversion is performed by repeatedly dividing the input integer by 2 and storing the remainders in a stack. The remainders are then popped from the stack to construct the binary representation.

## Usage

1. **Compilation**: Compile the Java program using a Java compiler (e.g., `javac BinaryConverter.java`).

2. **Execution**: Run the compiled program using the Java Virtual Machine (e.g., `java BinaryConverter`).

3. **Binary Conversion**: The program prompts the user to enter an integer. It then converts the integer to its binary representation and displays the result. This process continues until the user enters -1 to exit the program.

## Class Structure

- **BinaryConverter Class**: 
  - **`convertToBinary(int number)`:** Converts the given integer to its binary representation.
  - **`main(String[] args)`:** Main method to interact with the user and perform binary conversion.

- **CustomStack\<T\> Class**:
  - **`push(T item)`:** Pushes the given item onto the stack.
  - **`pop()`:** Pops an item from the top of the stack.
  - **`resize()`:** Resizes the stack array to double its current size.

## Example

Here is an example of how to use the Binary Converter program:

1. Run the program.

2. Enter an integer when prompted. The program will display its binary representation.

3. Repeat step 2 for additional conversions or enter -1 to exit the program.

## Author

- **Author:** Aniket Bhangale

## Version

- **Version:** 1.0

## Release Date

- **Release Date:** October 22, 2023

## Dependencies

- The program uses Java's built-in libraries, including `java.util.Scanner`.

