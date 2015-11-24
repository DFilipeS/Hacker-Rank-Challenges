package com.dfilipes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int blanks = n - 1;

        while (blanks >= 0) {
            for (int i = 0; i < blanks; i++) System.out.print(" ");
            for (int i = 0; i < n - blanks; i++) System.out.print("#");
            System.out.println();

            blanks--;
        }
    }
}
