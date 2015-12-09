package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        String word1 = in.nextLine();
        String word2 = in.nextLine();
        int[][] lcsMatrix = new int[word1.length() + 1][word2.length() + 1];

        for (int line = 1; line <= word1.length(); line++) {
            char letter1 = word1.charAt(line - 1);

            for (int column = 1; column <= word2.length(); column++) {
                char letter2 = word2.charAt(column - 1);

                if (letter1 == letter2) {
                    lcsMatrix[line][column] = lcsMatrix[line - 1][column - 1] + 1;
                } else {
                    lcsMatrix[line][column] = Math.max(lcsMatrix[line][column - 1], lcsMatrix[line - 1][column]);
                }
            }
        }

        System.out.println(lcsMatrix[word1.length()][word2.length()]);
    }
}
