package hackerrank;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        // Creating a scanner object to read input from stdin
        Scanner scan = new Scanner(System.in);

        // Read a full line of input from stdin and save it to our variable, inputString.
        String inputString = scan.nextLine();

        // Close the scanner object, because we've finished reading
        // all of the input from stdin needed for this challenge
        scan.close();
        System.out.println("Hello World");
        System.out.println(inputString);

    }
}
