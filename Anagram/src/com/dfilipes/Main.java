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
            if (sequence.length() % 2 != 0) {
                System.out.println("-1");
            } else {
                String firstSequence = sequence.substring(0, sequence.length() / 2);
                String secondSequence = sequence.substring(sequence.length() / 2);
                int[] firstCounter = new int[26];
                int[] secondCounter = new int[26];

                for (int i = 0; i < sequence.length() / 2; i++) {
                    firstCounter[firstSequence.charAt(i) - 'a']++;
                    secondCounter[secondSequence.charAt(i) - 'a']++;
                }

                int changes = 0;
                for (int i = 0; i < 26; i++) {
                    int difference = Math.abs(firstCounter[i] - secondCounter[i]);
                    if (difference != 0) changes += difference;
                }

                System.out.println(changes / 2);
            }

            nTestCases--;
        }
    }
}
