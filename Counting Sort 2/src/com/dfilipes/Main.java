package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));

        int[] counter = new int[100];
        int n = kb.nextInt();

        for (int i = 0; i < n; i++) {
            int val = kb.nextInt();
            counter[val]++;
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < counter[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
