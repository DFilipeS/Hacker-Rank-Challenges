package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int n = kb.nextInt();
        int[] sticks = new int[n];

        for (int i = 0; i < n; i++) {
            sticks[i] = kb.nextInt();
        }
    }

    public static void cut(int[] sticks, int n) {

    }

}
