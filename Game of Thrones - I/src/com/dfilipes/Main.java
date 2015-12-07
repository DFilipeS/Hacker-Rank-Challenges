package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("input"));

        String word = in.nextLine();
        HashMap<Character, Integer> alphabetCount = new HashMap<>();
        int oddLetterCounters = 0;
        int evenLetterCounters = 0;

        for (char letter : word.toCharArray()) {
            if (alphabetCount.containsKey(letter)) {
                int newCounter = alphabetCount.get(letter) + 1;
                alphabetCount.put(letter, newCounter);

                if (newCounter % 2 == 0) {
                    oddLetterCounters--;
                    evenLetterCounters++;
                } else {
                    oddLetterCounters++;
                    evenLetterCounters--;
                }
            } else {
                alphabetCount.put(letter, 1);
                oddLetterCounters++;
            }
        }

        if (word.length() % 2 == 0) {
            if (oddLetterCounters == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (oddLetterCounters == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
