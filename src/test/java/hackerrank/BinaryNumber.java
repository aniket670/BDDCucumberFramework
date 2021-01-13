package hackerrank;

import java.util.Scanner;

public class BinaryNumber {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count=0,min=0;
        while(n>0)
        {
            if(n%2==1)
            {
                count++;
                if(count>=min)
                {
                    min=count;
                }
            }
            else
            {
                count=0;
            }

            n=n/2;
            //System.out.println(n);
            //System.out.println(min);
        }
        System.out.println(min);
        scanner.close();
    }
}