package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> phonebook = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++){

            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phonebook.put(name,phone);
        }
        while(in.hasNext()) {
            String s = in.next();
            // Write code here
            if (phonebook.containsKey(s)){

                System.out.println(s+ " = " + phonebook.get(s));
            } else {
                System.out.println("Not found");
            }
            break ;
        }
        in.close();

    }
}
