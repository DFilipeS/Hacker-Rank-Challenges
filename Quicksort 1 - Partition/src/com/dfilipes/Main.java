package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));

        ArrayList<Integer> leftPartition = new ArrayList<>();
        ArrayList<Integer> rightPartition = new ArrayList<>();
        int n = kb.nextInt();
        int p = kb.nextInt();

        for (int i = 1; i < n; i++) {
            int val = kb.nextInt();
            if (val < p) {
                leftPartition.add(val);
            } else {
                rightPartition.add(val);
            }
        }

        leftPartition.add(p);
        leftPartition.addAll(rightPartition);

        for (int i = 0; i < leftPartition.size(); i++) {
            System.out.print(leftPartition.get(i) + " ");
        }
    }
}
