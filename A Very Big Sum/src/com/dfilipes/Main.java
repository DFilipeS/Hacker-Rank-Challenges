package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int n = in.nextInt();
        int arr[] = new int[n];

        BigInteger sum = BigInteger.valueOf(0);

        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();

            sum = sum.add(BigInteger.valueOf(arr[arr_i]));
        }

        System.out.println(sum);
    }
}
