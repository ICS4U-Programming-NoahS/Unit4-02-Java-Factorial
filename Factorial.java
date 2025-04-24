import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
* The Factorial program will read a set of whole numbers from 'input.txt'.
* It will check if it is a valid whole number.
* If it is not a valid whole number, it will write an error message.
* It will then calculate the factorial of each valid whole number.
* Finally, it will write the factorials to 'output.txt'.
*
* @version 1.0
* @since 2025-04-22
*/

final class Factorial {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the reverse string method.
     *
     * @param number the number of the calculated factorial.
     * @return the factorial of the number.
     */

    public static int factorial(final int number) {

        // Base case
        if (number == 0) {

            // Return 1
            // because 0! = 1
            return 1;
        } else {
            // Recursive case
            // Call the factorial method recursively
            // and multiply the number by the factorial of that number - 1
            // Return the factorial of the number
            return (number * factorial(number - 1));
        }
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // pass the relative path to the input file as a parameter
        File file = new File("./input.txt");

        // Create a file object
        FileWriter myWriter = new FileWriter("./output.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // Greeting and program description
        System.out.println("Welcome to the factorial program!");
        System.out.print("The Factorial program will read a set");
        System.out.println(" of whole numbers from 'input.txt'.");
        System.out.println("It will check if it is a valid whole number.");
        System.out.print("If it is not a valid whole number,");
        System.out.println(" it will write an error message.");
        System.out.print("It will then calculate the factorial");
        System.out.println(" of each valid whole number.");
        System.out.println("It will write the factorials to 'output.txt'.");

        // Keep reading the file until there are no more lines
        while (scanner.hasNextLine()) {

            // Read the string from the file
            String line = scanner.nextLine();

            // to catch invalid whole number
            try {
                // try to convert the string to an integer
                int number = Integer.parseInt(line);

                // Check if the integer is a whole number
                if (number < 0) {
                    // If the number is negative
                    outputStr += ("'" + line
                            + "' is not a valid whole number.\n"
                    );

                // if the number is greater than 0
                } else {

                    // Get the sorted array by calling the select sort function
                    int factorial = factorial(number);

                    // Add the reversed string to the output string
                    outputStr += (number + "! = " + factorial + "\n");
                }

            // if the string is not a valid whole number
            } catch (Exception exception) {

                // If the string is not a valid
                // whole number, write an error message
                outputStr += ("'" + line + "' is not a valid whole number.\n");
            }
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Close the file writer
        myWriter.close();

        // Added a blank line for spacing
        System.out.println("");

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");

        // Close the scanner
        scanner.close();
    }
}
