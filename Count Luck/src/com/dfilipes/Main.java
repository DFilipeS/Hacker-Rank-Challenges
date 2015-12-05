package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int n;
    public static int m;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int nTests = kb.nextInt();

        while (nTests > 0) {
            n = kb.nextInt();
            m = kb.nextInt();
            char[][] forestMatrix = new char[n][m];
            Node start = new Node();

            kb.nextLine();
            for (int line = 0; line < n; line++) {
                String lineString = kb.nextLine();
                for (int column = 0; column < m; column++) {
                    forestMatrix[line][column] = lineString.charAt(column);
                    if (forestMatrix[line][column] == 'M') {
                        start.x = line;
                        start.y = column;
                    }
                }
            }

            int k = kb.nextInt();

            Node exit = dfs(forestMatrix, start.x, start.y);
            if (exit.steps == k) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }

            nTests--;
        }
    }

    private static Node dfs(char[][] matrix, int startX, int startY) {
        int[][] discovered = new int[n][m];
        Stack<Node> searchStack = new Stack<>();

        Node start = new Node(startX, startY, 0);
        searchStack.push(start);

        while (!searchStack.isEmpty()) {
            Node current = searchStack.pop();
            if (matrix[current.x][current.y] == '*') return current;

            if (discovered[current.x][current.y] == 0) { // Undiscovered
                discovered[current.x][current.y] = 1;

                int paths = 0;

                if (current.x > 0 && matrix[current.x - 1][current.y] != 'X' && discovered[current.x - 1][current.y] == 0) paths++; // UP
                if (current.y < m-1 && matrix[current.x][current.y + 1] != 'X' && discovered[current.x][current.y + 1] == 0) paths++; // RIGHT
                if (current.x < n-1 && matrix[current.x + 1][current.y] != 'X' && discovered[current.x + 1][current.y] == 0) paths++; // DOWN
                if (current.y > 0 && matrix[current.x][current.y - 1] != 'X' && discovered[current.x][current.y - 1] == 0) paths++; // LEFT

                int steps = current.steps;
                if (paths > 1) steps++;

                if (current.x > 0 && matrix[current.x - 1][current.y] != 'X') searchStack.push(new Node(current.x - 1, current.y, steps)); // UP
                if (current.y < m-1 && matrix[current.x][current.y + 1] != 'X') searchStack.push(new Node(current.x, current.y + 1, steps)); // RIGHT
                if (current.x < n-1 && matrix[current.x + 1][current.y] != 'X') searchStack.push(new Node(current.x + 1, current.y, steps)); // DOWN
                if (current.y > 0 && matrix[current.x][current.y - 1] != 'X') searchStack.push(new Node(current.x, current.y - 1, steps)); // LEFT
            }
        }

        return null;
    }

    static class Node {
        int x, y;
        int steps;

        public Node() {}

        public Node(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}
