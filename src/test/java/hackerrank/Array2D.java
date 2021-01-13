package hackerrank;

import java.util.Scanner;

public class Array2D {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr.length - 2 || j >= arr.length - 2) {
                } else {
                    int temp = 0;
                    int firstTemp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                    int secoundTemp = arr[i + 1][j + 1];
                    int thirdTemp = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                    temp = firstTemp + secoundTemp + thirdTemp;

                    if (temp > count) {
                        count = temp;
                    }
                }

            }
        }
        System.out.println(count);

    }
}
