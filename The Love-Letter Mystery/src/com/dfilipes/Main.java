package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nTestCases = in.nextInt();
        in.nextLine();

        while (nTestCases > 0) {
            String sequence = in.nextLine();
            int minOperations = 0;

            for (int i = 0; i < sequence.length() / 2; i++) {
                int left = i;
                int right = sequence.length() - 1 - i;
                char leftChar = (char) (sequence.charAt(left) - 'a');
                char rightChar = (char) (sequence.charAt(right) - 'a');

                minOperations += Math.abs(leftChar - rightChar);
            }

            System.out.println(minOperations);

            nTestCases--;
        }
    }
}
