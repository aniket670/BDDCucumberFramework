package hackerrank;

import java.util.Scanner;

public class DataTypeTest {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank";
        Scanner scan = new Scanner(System.in);

        Integer it = scan.nextInt();
        Double dd = scan.nextDouble();
        scan.nextLine();
        String st = scan.nextLine();

        System.out.println(i+it);
        System.out.println(d+dd);
        System.out.println(s +" " +st);
        scan.close();

    }
}
