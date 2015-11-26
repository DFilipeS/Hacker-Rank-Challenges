package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Scanner kb = new Scanner(new File("input"));
        ArrayList<Integer> sequence = new ArrayList<>();
        int s = kb.nextInt();

        for (int i = 0; i < s; i++) sequence.add(kb.nextInt());
        sequence = insertSort(sequence);
    }

    private static ArrayList<Integer> insertSort(ArrayList<Integer> sequence) {
        for (int i = 1; i < sequence.size(); i++) {
            int auxIndex = i;
            while (auxIndex > 0 && sequence.get(auxIndex) < sequence.get(auxIndex - 1)) {
                int auxVal = sequence.get(auxIndex);
                sequence.set(auxIndex, sequence.get(auxIndex - 1));
                sequence.set(auxIndex - 1, auxVal);
                auxIndex--;
            }

            printSequence(sequence);
        }

        return sequence;
    }

    private static void printSequence(ArrayList<Integer> sequence) {
        for (Integer num : sequence) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
