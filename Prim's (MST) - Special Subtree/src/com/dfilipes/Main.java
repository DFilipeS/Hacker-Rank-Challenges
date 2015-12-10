package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nVertices = in.nextInt();
        int nEdges = in.nextInt();
        int[][] graph = new int[nVertices + 1][nVertices + 1];
        int[] costs = new int[nVertices + 1];

        for (int i = 0; i <= nVertices; i++) costs[i] = Integer.MAX_VALUE;
        for (int x = 0; x <= nVertices; x++) {
            for (int y = 0; y <= nVertices; y++) {
                graph[x][y] = Integer.MAX_VALUE;
            }
        }

        HashSet<Integer> queue = new HashSet<>();

        for (int i = 0; i < nEdges; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int weight = in.nextInt();

            if (weight < graph[x][y])  {
                graph[x][y] = weight;
                graph[y][x] = weight;
            }

            if (!queue.contains(x)) queue.add(x);
            if (!queue.contains(y)) queue.add(y);
        }

        int startNode = in.nextInt();
        costs[startNode] = 0;

        while (!queue.isEmpty()) {
            int minCost = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 1; i <= nVertices; i++) {
                if (queue.contains(i) && costs[i] < minCost) {
                    minCost = costs[i];
                    vertex = i;
                }
            }

            if (vertex == -1) {
                vertex = queue.iterator().next();
            }

            queue.remove(vertex);
            for (int i = 1; i <= nVertices; i++) {
                if (i != vertex && queue.contains(i) && graph[vertex][i] < costs[i]) {
                    costs[i] = graph[vertex][i];
                }
            }
        }

        int totalWeigth = 0;
        for (int i = 1; i <= nVertices; i++) {
            if (costs[i] != Integer.MAX_VALUE) totalWeigth += costs[i];
        }

        System.out.println(totalWeigth);
    }
}
