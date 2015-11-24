package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int n = in.nextInt();
        int arr[] = new int[n];

        int positives = 0;
        int negatives = 0;
        int zeroes = 0;
        int total = 0;

        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();

            if (arr[arr_i] > 0) {
                positives++;
            } else if (arr[arr_i] < 0) {
                negatives++;
            } else {
                zeroes++;
            }

            total++;
        }

        System.out.printf("%.3f\n", (float) positives / total);
        System.out.printf("%.3f\n", (float) negatives / total);
        System.out.printf("%.3f\n", (float) zeroes / total);
    }
}
