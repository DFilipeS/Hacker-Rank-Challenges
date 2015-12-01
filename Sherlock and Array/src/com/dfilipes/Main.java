package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Scanner kb = new Scanner(new File("input"));

        int t = kb.nextInt();
        while (t > 0) {
            int i;
            int n = kb.nextInt();
            int[] sequence = new int[n];
            int sum = 0;

            for (i = 0; i < n; i++) {
                sequence[i] = kb.nextInt();
                sum += sequence[i];
            }

            if (n == 1) {
                System.out.println("YES");
            } else {
                int leftSum = sequence[0];
                int rightSum = sum - sequence[0];

                for (i = 1; i < n; i++) {
                    rightSum -= sequence[i];

                    if (leftSum == rightSum) {
                        System.out.println("YES");
                        break;
                    }

                    leftSum += sequence[i];
                }

                if (i == n) {
                    System.out.println("NO");
                }
            }

            t--;
        }
    }
}
