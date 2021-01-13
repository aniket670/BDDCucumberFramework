package hackerrank;

import java.util.Scanner;

public class ArrayTest {

    /* Reverse array program
    Task
Given an array, , of  integers, print 's elements in reverse order as a single line of space-separated numbers.

Input Format
The first line contains an integer,  (the size of our array).
The second line contains  space-separated integers describing array 's elements.

Output Format
Print the elements of array  in reverse order as a single line of space-separated numbers.
*/

    public static void reverseArray(int[] myinput){
        int len = myinput.length;
        for (int i =len-1; i>=0 ; i--){
            System.out.print(myinput[i] + " ");
        }
    }
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        reverseArray(arr);

        scanner.close();
    }

    }

