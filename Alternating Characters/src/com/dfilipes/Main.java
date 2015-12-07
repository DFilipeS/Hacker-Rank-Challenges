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
            String word = in.nextLine();
            char lastChar = word.charAt(0);
            int cuts = 0;

            for (int i = 1; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (currentChar == lastChar) {
                    cuts++;
                }

                lastChar = currentChar;
            }

            System.out.println(cuts);

            nTestCases--;
        }
    }
}
