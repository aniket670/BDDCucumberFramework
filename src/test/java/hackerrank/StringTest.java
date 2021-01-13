package hackerrank;

import java.util.Scanner;

public class StringTest {

    private  static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scan.nextInt();
        scan.nextLine();

        for (int i=0 ;i<T ; i++){
            String myinput = scan.nextLine();
            String even = "";
            String odd = "";
            for (int j =0 ; j<myinput.length(); j++){

                if (j%2==0){
                    even += myinput.charAt(j);
                } else {
                    odd += myinput.charAt(j);
                }
            }
            System.out.println(even +" " +odd);
            //System.out.println(odd);

        }
        scan.close();

    }
}
