package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));

        int n = kb.nextInt();
        int[] counter = new int[100];

        for (int i = 0; i < n; i++) {
            int val = kb.nextInt();
            kb.next();
            counter[val]++;
        }

        int l = 0;
        for (int i = 0; i < 100; i++) {
            l += counter[i];
            System.out.print(l + " ");
        }
    }
}
