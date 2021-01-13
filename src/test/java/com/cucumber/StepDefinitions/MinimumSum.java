package com.cucumber.StepDefinitions;

import java.util.Arrays;

public class MinimumSum {

    public static void main(String[] args) {
        System.out.println(mininumSum(new int []{10,20,7},4));
    }

    public static int mininumSum(int [] inputArr, int k){

        int sum = 0;
        Arrays.sort(inputArr);
        for (int i = 0; i < k; i++) {
            int len = inputArr.length;
            if (inputArr[len - 1] % 2 == 0) {
                inputArr[len - 1] = inputArr[len - 1] / 2;
            } else {
                inputArr[len - 1] = (int) Math.ceil((double) inputArr[len - 1] / 2);
            }
            Arrays.sort(inputArr);
        }

        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];
        }
        return sum;
    }
    }

