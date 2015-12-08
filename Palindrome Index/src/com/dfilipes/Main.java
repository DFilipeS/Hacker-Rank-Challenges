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
            int index = -1;

            if (isPalindrome(sequence)) {
                System.out.println(index);
            } else {
                for (int i = 0; i <= sequence.length() / 2; i++) {
                    int left = i;
                    int right = sequence.length() - 1 - i;
                    if (sequence.charAt(left) != sequence.charAt(right)) {
                        if (isPalindrome(sequence.substring(left, right))) {
                            index = right;
                        } else {
                            index = left;
                        }

                        break;
                    }
                }

                System.out.println(index);
            }

            nTestCases--;
        }
    }

    public static boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return word.equals(reverse);
    }
}
