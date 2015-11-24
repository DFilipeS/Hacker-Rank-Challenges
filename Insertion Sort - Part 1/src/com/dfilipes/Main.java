package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void insertIntoSorted(int[] ar) {
        int n = ar[ar.length-1];
        int currentCursor = ar.length - 2;
        int previousCursor = ar.length - 1;

        while (currentCursor >= 0 && ar[currentCursor] > n) {
            ar[previousCursor] = ar[currentCursor];
            previousCursor = currentCursor;
            currentCursor -= 1;
            printArray(ar);
        }

        ar[previousCursor] = n;
        printArray(ar);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
