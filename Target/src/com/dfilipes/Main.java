package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int K = in.nextInt();
        int N = in.nextInt();
        ArrayList<Integer> R = new ArrayList<>(K);
        int points = 0;

        for(int R_i=0; R_i < K; R_i++){
            R.add(in.nextInt());
        }

        for (int shots = 0; shots < N; shots++) {
            int xCoord = in.nextInt();
            int yCoord = in.nextInt();
            float distance =  euclideanDistance(0, 0, xCoord, yCoord);

            if (distance <= R.get(R.size() - 1)) {
                points += R.size();
            } else {
                for (int i = 0; i < R.size(); i++) {
                    if (distance > R.get(i)) {
                        points += i;
                        break;
                    }
                }
            }
        }

        System.out.println(points);
    }

    private static float euclideanDistance(int x1, int y1, int x2, int y2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
