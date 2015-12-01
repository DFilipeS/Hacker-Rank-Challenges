package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));

        int n = kb.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) sequence[i] = kb.nextInt();
        quickSort(sequence, 0, sequence.length - 1);


    }

    private static void quickSort(int[] sequence, int low, int high) {
        if (low < high) {
            int pivot = lomutoPartition(sequence, low, high);
            printSequence(sequence);
            quickSort(sequence, low, pivot - 1);
            quickSort(sequence, pivot + 1, high);
        }
    }

    private static int lomutoPartition(int[] sequence, int low, int high) {
        int pivot = sequence[high];
        int pivotIndex = low;

        for (int i = low; i <= high - 1; i++) {
            if (sequence[i] <= pivot) {
                int aux = sequence[pivotIndex];
                sequence[pivotIndex] = sequence[i];
                sequence[i] = aux;
                pivotIndex++;
            }
        }

        sequence[high] = sequence[pivotIndex];
        sequence[pivotIndex] = pivot;

        return pivotIndex;
    }

    private static void printSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }

        System.out.println();
    }
}
