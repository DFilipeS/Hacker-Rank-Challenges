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
            int k = in.nextInt();
            int a[] = new int[n];

            int early = 0;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();

                if (a[a_i] <= 0) early++;
            }

            if (early >= k) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
