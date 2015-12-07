package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int[] elemementsCounter = new int[26];
        int nRocks = in.nextInt();
        in.nextLine();

        for (int i = 0; i < nRocks; i++) {
            String rock = in.nextLine();
            int[] rockElementsFound = new int[26];
            for (char c : rock.toCharArray()) {
                int letterIndex = c - 'a';
                if (rockElementsFound[letterIndex] == 0) {
                    elemementsCounter[letterIndex]++;
                    rockElementsFound[letterIndex] = 1;
                }
            }
        }

        int gemElementsCounter = 0;
        for (int i = 0; i < elemementsCounter.length; i++) {
            if (elemementsCounter[i] == nRocks) gemElementsCounter++;
        }

        System.out.println(gemElementsCounter);
    }
}
