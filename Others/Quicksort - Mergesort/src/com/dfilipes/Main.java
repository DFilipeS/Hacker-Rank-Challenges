package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int n = kb.nextInt();
        //int[] sequence = new int[n];
        ArrayList<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //sequence[i] = kb.nextInt();
            sequence.add(kb.nextInt());
        }

        /*quicksort(sequence, 0, sequence.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();*/

        sequence = mergesort(sequence);

        for (int i = 0; i < n; i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();
    }

    private static void quicksort(int[] sequence, int low, int high) {
        if (low < high) {
            int p = partition(sequence, low, high);
            quicksort(sequence, low, p - 1);
            quicksort(sequence, p + 1, high);
        }
    }

    private static int partition(int[] sequence, int low, int high) {
        int pivot = sequence[high];
        int index = low;

        for (int i = low; i < high; i++) {
            if (sequence[i] <= pivot) {
                int aux = sequence[index];
                sequence[index] = sequence[i];
                sequence[i] = aux;
                index++;
            }
        }

        sequence[high] = sequence[index];
        sequence[index] = pivot;

        return index;
    }

    private static ArrayList<Integer> mergesort(ArrayList<Integer> sequence) {
        if (sequence.size() <= 1) return sequence;

        int middle = sequence.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<>(sequence.subList(0, middle));
        ArrayList<Integer> rightList = new ArrayList<>(sequence.subList(middle, sequence.size()));

        leftList = mergesort(leftList);
        rightList = mergesort(rightList);

        return merge(leftList, rightList);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> sequence = new ArrayList<>();

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            int leftVal = leftList.get(0);
            int rightVal = rightList.get(0);

            if (leftVal <= rightVal) {
                sequence.add(leftVal);
                leftList.remove(0);
            } else {
                sequence.add(rightVal);
                rightList.remove(0);
            }
        }

        if (!leftList.isEmpty()) sequence.addAll(leftList);
        if (!rightList.isEmpty()) sequence.addAll(rightList);

        return sequence;
    }
}
