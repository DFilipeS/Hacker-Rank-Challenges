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
            System.out.println(getMaxDecentNumber(n));
        }
    }

    public static String getMaxDecentNumber(int n) {
        int fives = n;
        int threes = 0;
        String output = "";

        while (fives >= 0) {
            if (fives % 3 == 0 && threes % 5 == 0) {
                for (int i = 0; i < fives; i++) output += "5";
                for (int i = 0; i < threes; i++) output += "3";
                return output;
            }

            fives--;
            threes++;
        }

        return "-1";
    }
}
