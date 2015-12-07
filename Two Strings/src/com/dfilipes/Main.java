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
            String word1 = in.nextLine();
            String word2 = in.nextLine();
            int[] word1Counter = new int[26];
            int[] word2Counter = new int[26];

            for (char c : word1.toCharArray()) {
                word1Counter[c - 'a']++;
            }

            boolean hasSubstring = false;
            for (char c : word2.toCharArray()) {
                if (word1Counter[c - 'a'] != 0) {
                    hasSubstring = true;
                    break;
                }

                word2Counter[c - 'a']++;
            }

            if (hasSubstring) System.out.println("YES");
            else System.out.println("NO");

            nTestCases--;
        }
    }
}
