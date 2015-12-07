package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int[] sequence1LetterCounter = new int[26];
        int[] sequence2LetterCounter = new int[26];

        String sequence1 = in.nextLine();
        String sequence2 = in.nextLine();

        for (char c : sequence1.toCharArray()) {
            sequence1LetterCounter[c - 'a']++;
        }

        for (char c : sequence2.toCharArray()) {
            sequence2LetterCounter[c - 'a']++;
        }

        int cuts = 0;
        for (int i = 0; i < 26; i++) {
            cuts += Math.abs(sequence1LetterCounter[i] - sequence2LetterCounter[i]);
        }

        System.out.println(cuts);
    }
}
