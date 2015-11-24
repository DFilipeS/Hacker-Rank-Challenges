package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int sum1 = 0;
        int sum2 = 0;

        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();

                if (a_i == a_j) {
                    sum1 += a[a_i][a_j];
                }

                if (a_i + a_j == n-1) {
                    sum2 += a[a_i][a_j];
                }
            }
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
