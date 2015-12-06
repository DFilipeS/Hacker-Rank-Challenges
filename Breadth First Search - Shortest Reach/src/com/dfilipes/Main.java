package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nTestCases = in.nextInt();

        while (nTestCases > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                int vertexA = in.nextInt();
                int vertexB = in.nextInt();
                graph.addEdge(vertexA, vertexB);
                graph.addEdge(vertexB, vertexA);
            }

            int start = in.nextInt();

            breadthFirstSearch(graph, start);

            nTestCases--;
        }
    }

    public static void breadthFirstSearch(Graph graph, int start) {
        int[] distances = new int[graph.size + 1];
        int[] predecessor = new int[graph.size + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i < graph.size + 1; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        distances[start] = 0;
        queue.addLast(start);

        while (!queue.isEmpty()) {
            int current = queue.pop();
            for (Integer node : graph.nodes[current].adjacentNodes) {
                if (distances[node] == Integer.MAX_VALUE) {
                    distances[node] = distances[current] + 6;
                    predecessor[node] = current;
                    queue.addLast(node);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < graph.size + 1; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                stringBuilder.append("-1 ");
            } else if (i != start) {
                stringBuilder.append(distances[i] + " ");
            }
        }

        System.out.println(stringBuilder.toString().trim());
    }

    static class Graph {
        int size;
        Node[] nodes;

        public Graph(int nVertices) {
            this.size = nVertices;
            this.nodes = new Node[nVertices + 1];
            for (int i = 1; i < nVertices + 1; i++) {
                Node node = new Node();
                nodes[i] = node;
            }
        }

        public void addEdge(int vertexA, int vertexB) {
            nodes[vertexA].addAdjacent(vertexB);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    stringBuilder.append("{" + i + "} : ");
                    stringBuilder.append(nodes[i].adjacentNodes);
                    stringBuilder.append('\n');
                }
            }

            return stringBuilder.toString();
        }

        static class Node {
            ArrayList<Integer> adjacentNodes;

            public Node() {
                adjacentNodes = new ArrayList<>();
            }

            public void addAdjacent(int key) {
                adjacentNodes.add(key);
            }
        }
    }
}
