package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int n = kb.nextInt();
        int t = kb.nextInt();
        int[] serviceLane = new int[n];

        for (int i = 0; i < n; i++) {
            serviceLane[i] = kb.nextInt();
        }

        while (t > 0) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int min = serviceLane[start];

            for (int i = start; i <= end; i++) {
                if (serviceLane[i] < min) min = serviceLane[i];
            }

            System.out.println(min);

            t--;
        }
    }
}
