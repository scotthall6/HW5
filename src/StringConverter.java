import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StringConverter {

    public static int convert(String numString) throws NumberFormatException, FileNotFoundException {

        int next = 0;
        int first = 0;
        PrintWriter pw = new PrintWriter("NumberStringsConverted.txt");

        if (numString.matches(".*[a-zA-Z]+.*")) {
            System.out.println(("? Invalid numeric string detected starting at " + numString));
        }

        // try-catch block to throw NumberFormatException if input has alphas
        try {

            if (numString.matches(".*[a-zA-Z]+.*")) {
                throw new NumberFormatException("? Invalid numeric string detected starting at " + numString);
            }

            // Logic to handle negative numbers. If first element of numString is a negative sign
            // convert the substring starting at index 1 and substract from 0 to give negative int value
            if (numString.charAt(0) == '-' && numString.length() >= 2)
                return 0 - convert(numString.substring(1));

            // If numString length is 1 convert to int value and return
            // subtracting char '0' implicitly casts value to int
            if (numString.length() == 1)
                return numString.charAt(0) - '0';

            // power(10^length - 1) gives us place value, eg thousands, hundreds, etc.
            // Split off first digit, convert to int, multiply by appropriate power
            first = (numString.charAt(0) - '0') * (int) Math.pow(10, numString.length() - 1);

            // Recursively process a numString with first digit split off, yields same process as above
            // until base case (length == 1) is reached
            next = convert(numString.substring(1));

        } catch (NumberFormatException ex) {
            pw.println(ex.getMessage());
            // Returns value of 0 if input is alpha
            return 0;
        }

        // Adds int values of each recursive call, ones-place + tens-place + hundreds-place + thousands place
        return first + next;
    }
} // End class String Converter
