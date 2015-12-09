package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nTestCases = in.nextInt();

        while (nTestCases > 0) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            int squaresCounter = 0;
            for (int i = n1; i <= n2; i++) {
                double squareRoot = Math.sqrt(i);
                int floored = (int) Math.floor(squareRoot);
                if (squareRoot == floored) {
                    while (i <= n2) {
                        squaresCounter++;
                        floored++;
                        i = floored * floored;
                    }
                    break;
                }
            }

            System.out.println(squaresCounter);

            nTestCases--;
        }
    }
}
