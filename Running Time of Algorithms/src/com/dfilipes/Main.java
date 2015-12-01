package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));

        int n = kb.nextInt();
        ArrayList<Integer> sequence = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            sequence.add(kb.nextInt());
        }

        sequence = insertSort(sequence);
    }

    private static ArrayList<Integer> insertSort(ArrayList<Integer> sequence) {
        int shifts = 0;

        for (int i = 1; i < sequence.size(); i++) {
            int index = i;
            while (index > 0 && sequence.get(index) < sequence.get(index - 1)) {
                int value = sequence.get(index);
                sequence.set(index, sequence.get(index - 1));
                sequence.set(index - 1, value);
                index--;
                shifts++;
            }
        }

        System.out.println(shifts);

        return sequence;
    }
}
