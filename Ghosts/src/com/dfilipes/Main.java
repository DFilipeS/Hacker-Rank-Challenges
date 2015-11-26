package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();

        int ghostsPopulation = 0;

        for (int town = 1; town <= A; town++) {
            for (int street = 1; street <= B; street++) {
                for (int house = 1; house <= C; house++) {
                    for (int apartment = 1; apartment <= D; apartment++) {
                        if (Math.abs(town - street) % 3 == 0) {
                            if ((street + house) % 5 == 0) {
                                if ((town * house) % 4 == 0) {
                                    if (gcd(town, apartment) == 1) {
                                        ghostsPopulation++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ghostsPopulation);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
