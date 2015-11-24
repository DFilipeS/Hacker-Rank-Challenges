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

            String nString = String.valueOf(n);
            int count = 0;
            for (char c : nString.toCharArray()) {
                if (c != '0' && n % Character.getNumericValue(c) == 0) count++;
            }
            System.out.println(count);
        }
    }
}
