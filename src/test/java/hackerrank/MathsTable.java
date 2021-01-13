package hackerrank;

import java.util.Scanner;

public class MathsTable {

    public static void result(int num) {

        if (num >= 2 && num <= 20) {
            for (int i = 0; i <= 10; i++) {
                // Here The noticing thing is the usage of printf to get the expected result format
                System.out.printf("%d x %d = %d \n", num, i, (num * i));
            }

        } else {
            System.out.println("Not a valid nummber");
        }
    }

    public static void resultUsingWhileLoop(int num) {
        int i = 1;
        if (num >= 2 && num <= 20) {
            while (i <= 10) {
                System.out.printf("%d x %d = %d \n", num, i, (num * i));
                i++;
            }
        } else {
            System.out.println("Not a valid nume");
        }
    }

        public static void main(String[]args) {

            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            //result(n);
            resultUsingWhileLoop(n);

        }
    }
    /*Objective
In this challenge, we're going to use loops to help us do some simple math. Check out the Tutorial tab to learn more.

Task
Given an integer, , print its first  multiples. Each multiple  (where ) should be printed on a new line in the form: n x i = result.

Input Format

A single integer, .

Constraints

Output Format

Print  lines of output; each line  (where ) contains the  of  in the form:
n x i = result.

Sample Input

2
Sample Output

2 x 1 = 2
2 x 2 = 4 */