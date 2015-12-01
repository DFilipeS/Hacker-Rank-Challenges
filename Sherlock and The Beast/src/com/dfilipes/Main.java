package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            printDecentNumber(n);
        }
    }

    public static void printDecentNumber(int n) {
        int fives = n;
        int threes = 0;

        while (fives >= 0) {
            if (fives % 3 == 0 && threes % 5 == 0) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < fives; i++) builder.append("5");
                for (int i = 0; i < threes; i++) builder.append("3");
                System.out.println(builder.toString());
                return;
            }

            fives--;
            threes++;
        }

        System.out.println("-1");
    }
}
