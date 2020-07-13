import java.util.Scanner;

/**
 * Class to validate the inputs given by the user.
 *
 * @author Alex Uskova
 * @author Rafael Almeida
 * @version 1.0
 */
public class InputValidators {

    /**
     * Validate if a input is a valid integer and greater than 0.
     *
     * @param input        A Scanner object reference from the referenced class
     * @param message      A String message to ask for the user input
     * @param errorMessage A String message to be thrown in case of input validation fail
     * @return An valid integer greater than zero.
     */
    public static int validateInt(Scanner input, String message, String errorMessage) {
        int value; // return variable
        do {
            // Prints the message arg
            System.out.println("\n" + message + ":");
            // Check if input is not an integer
            while (!input.hasNextInt()) {
                System.out.print("\u001B[31m");
                // Prints error message in case of not integer
                System.out.println(errorMessage);
                System.out.print("\u001B[0m\n");
                // Prints the message arg again
                System.out.println(message + ":");
                // Go to next line of input
                input.next();
            }
            // Add integer to return variable
            value = input.nextInt();
            // Go to next line (int doesn't do this automatically)
            input.nextLine();
            // Check if value is greater than 0
        } while (value <= 0);
        // return validated integer
        return value;
    }

    /**
     * Validate if a input is a valid String which contains only alphabets, numbers and spaces
     * and not containing any special characters.
     *
     * @param input        A Scanner object reference from the referenced class
     * @param message      A String message to ask for the user input
     * @param errorMessage A String message to be thrown in case of input validation fail
     * @return A String not containing special characters
     */
    public static String validateString(Scanner input, String message, String errorMessage) {
        // Regex to check for alphabets, numbers and spaces
        String regex = "^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$";
        String value; // return variable
        do {
            // Prints the message arg
            System.out.println("\n" + message + ":");
            // Assign input to return value
            value = input.nextLine();

            // Check if string matches regex (only alphabets,numbers and spaces
            if (!value.matches(regex)) {

                System.out.print("\u001B[31m");
                // Prints custom error message in case of not integer
                System.out.println(errorMessage);
                // Prints validation error message
                System.out.println("Only alphabet and integers are accepted. " +
                        "Comma, dots and special chars are not accepted.");
                System.out.print("\u001B[0m");
            }
            // do loop while the string is invalid
        } while (!value.matches(regex));
        // return validated string
        return value;
    }
}
