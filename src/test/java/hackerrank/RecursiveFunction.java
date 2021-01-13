package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveFunction {

    private static final Scanner scanner = new Scanner(System.in);

    public static int factorial(int n){
        if (n <=1){
            return 1 ;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);

     /*   bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close(); */

        System.out.println("Factorial Value is:"+" "+result);
        scanner.close();
    }
}
