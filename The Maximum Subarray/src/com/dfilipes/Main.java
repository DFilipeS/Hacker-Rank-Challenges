package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int nTestCases = kb.nextInt();

        while (nTestCases > 0) {
            int nArraySize = kb.nextInt();
            int currentSum = 0;
            int bestContiguousSum = 0;
            int maxNegativeNumber = Integer.MIN_VALUE;
            int bestNonContiguousSum = 0;


            for (int n = 0; n < nArraySize; n++) {
                int number = kb.nextInt();

                /* Continuous sum */

                if (number < 0 && number > maxNegativeNumber) maxNegativeNumber = number;

                int newSum = number + currentSum;
                if (newSum > 0) {
                    currentSum = newSum;
                } else {
                    currentSum = 0;
                }

                if (currentSum > bestContiguousSum) bestContiguousSum = currentSum;

                /* Non continuous sums */
                if (number > 0) {
                    bestNonContiguousSum += number;
                }
            }

            if (bestContiguousSum == 0 && maxNegativeNumber != Integer.MIN_VALUE) bestContiguousSum = maxNegativeNumber;
            if (bestNonContiguousSum == 0 && maxNegativeNumber != Integer.MIN_VALUE) bestNonContiguousSum = maxNegativeNumber;

            System.out.println(bestContiguousSum + " " + bestNonContiguousSum);

            nTestCases--;
        }
    }
}
