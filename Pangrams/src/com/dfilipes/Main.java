package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        String sentence = kb.nextLine();
        HashSet<String> letterCounter = new HashSet<>(26);

        for (char c : sentence.toCharArray()) {
            if (c != ' ') {
                letterCounter.add(Character.valueOf(c).toString().toLowerCase());
            }
        }

        if (letterCounter.size() == 26) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
