package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int height = 1;
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    height *= 2 ;
                } else {
                    height += 1;
                }
            }

            System.out.println(height);
        }
    }
}
