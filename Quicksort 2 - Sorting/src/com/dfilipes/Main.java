package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));

        int n = in.nextInt();
        int[] ar = new int[n];

        for(int i = 0; i < n; i++){
            ar[i] = in.nextInt();
        }

        quickSort(ar);
        printArray(ar);
    }

    private static int[] quickSort(int[] sequence) {
        if (sequence.length <= 1) return sequence;

        ArrayList<Integer> leftPartition = new ArrayList<>();
        ArrayList<Integer> rightPartition = new ArrayList<>();
        int p = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] < p) {
                leftPartition.add(sequence[i]);
            } else {
                rightPartition.add(sequence[i]);
            }
        }

        int[] left = listToArray(leftPartition);
        int[] right = listToArray(rightPartition);

        quickSort(left);
        quickSort(right);

        if (left.length > 1) printArray(left);
        if (right.length > 1) printArray(right);

        int index = 0;
        for (int i = 0; i < left.length; i++) {
            sequence[index] = left[i];
            index++;
        }

        sequence[index] = p;
        index++;

        for (int i = 0; i < right.length; i++) {
            sequence[index] = right[i];
            index++;
        }

        return sequence;
    }

    private static int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private static void printArray(int [] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}
