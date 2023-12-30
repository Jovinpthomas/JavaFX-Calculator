 # JavaFX Calculator

JavaFX Calculator is a simple yet powerful calculator that can perform basic mathematical operations. It features a user-friendly interface with a text field to display the result and buttons for digits and operations.

## Key Features

* **User-Friendly Interface:** Clean and intuitive design with a clear layout of buttons and text field. Easy-to-read display shows the result of calculations in real-time.
* **Basic Mathematical Operations:** Supports addition, subtraction, multiplication, and division. Handles both positive and negative numbers.
* **Error Handling:** Detects and handles division by zero errors, displaying an appropriate message. Prevents invalid input, such as entering two consecutive operators without a number.
* **Parenthesis Support:** Includes support for parentheses, allowing users to create more complex expressions.
* **Conversion between Infix and Postfix Notation:** Converts infix expressions entered by the user into postfix notation for efficient evaluation.

## Implementation Details

* **JavaFX:** The project utilizes the JavaFX library to create the graphical user interface (GUI) and handle user interactions.
* **Stack Data Structure:** A stack is employed to evaluate postfix expressions efficiently and handle parenthesis.
* **Exception Handling:** The program incorporates exception handling to catch and display error messages for division by zero and invalid input.

## How to Use

1. Open the application.
2. Enter a mathematical expression in the text field using digits and operators (+, -, x, /).
3. Click the "=" button to evaluate the expression and display the result.
4. Use the "C" button to clear the text field and start a new calculation.
