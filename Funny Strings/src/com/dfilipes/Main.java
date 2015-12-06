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
            String s = in.nextLine();
            String reverse = new StringBuilder(s).reverse().toString();
            boolean funnyString = true;

            for (int i = 1; i < s.length() - 1; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(reverse.charAt(i) - reverse.charAt(i - 1))) {
                    funnyString = false;
                    break;
                }
            }

            if (funnyString) {
                System.out.println("Funny");
            } else {
                System.out.println("Not Funny");
            }

            nTestCases--;
        }
    }
}
