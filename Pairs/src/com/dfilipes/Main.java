package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        ArrayList<Integer> sequence = new ArrayList<>();

        int n = in.nextInt();
        int k = in.nextInt();
        int pairCounter = 0;

        for (int i = 0; i < n; i++) {
            sequence.add(in.nextInt());
        }

        Collections.sort(sequence);

        for (int i = 0; i < n - 1; i++) {
            int pairValue = sequence.get(i);
            for (int j = i + 1; j < n; j++) {
                int difference = Math.abs(pairValue - sequence.get(j));
                if (difference == k) {
                    pairCounter++;
                    break;
                } else if (difference > k) {
                    break;
                }
            }
        }

        System.out.println(pairCounter);
    }
}
