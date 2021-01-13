package com.cucumber.StepDefinitions;

import java.util.Arrays;
import java.util.List;

public class MininumValue {

    public static void main(String[] args) {

        System.out.println(minimumofX(Arrays.asList(new Integer[] {-2,3,1,-5})));
    }

    public static  int minimumofX(List<Integer> inputArr){
        int x = 0;
    // inputArr.stream().filter(a -> a==0);
        while (true) {
            int sum = x;
            for (Integer i : inputArr) {
                sum += i;
            }
            if (sum == 1) {
                return x;
            } else {
                x++;
            }
        }
    }
}
