package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
                int weigth = in.nextInt();

                graph.addEdge(vertexA, vertexB, weigth);
                graph.addEdge(vertexB, vertexA, weigth);
            }

            int start = in.nextInt();

            dijkstra(graph, start);

            nTestCases--;
        }
    }

    public static void dijkstra(Graph graph, int start) {
        final int[] distance = new int[graph.size + 1];
        int[] predecesor = new int[graph.size + 1];
        LinkedList<Integer> unvisitedVertices = new LinkedList<>();

        for (int i = 1; i <= graph.size; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecesor[i] = -1;
            unvisitedVertices.add(i);
        }

        distance[start] = 0;

        while (!unvisitedVertices.isEmpty()) {
            int minDist = Integer.MAX_VALUE;
            Integer currentVertex = null;
            for (Integer vertex : unvisitedVertices) {
                if (distance[vertex] <= minDist) {
                    minDist = distance[vertex];
                    currentVertex = vertex;
                }
            }
            unvisitedVertices.remove(currentVertex);

            for (Integer adjacent : graph.nodes[currentVertex].adjacentNodes) {
                if (distance[currentVertex] != Integer.MAX_VALUE) {
                    int candidateDistance = distance[currentVertex] + graph.weigths[currentVertex][adjacent];
                    if (candidateDistance < distance[adjacent]) {
                        distance[adjacent] = candidateDistance;
                        predecesor[adjacent] = currentVertex;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= graph.size; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                if (i != start) {
                    stringBuilder.append(distance[i] + " ");
                }
            } else {
                stringBuilder.append("-1 ");
            }
        }

        System.out.println(stringBuilder.toString().trim());
    }

    static class Graph {
        int size;
        Node[] nodes;
        int[][] weigths;

        public Graph(int nVertices) {
            this.size = nVertices;
            this.nodes = new Node[nVertices + 1];
            this.weigths = new int[nVertices + 1][nVertices + 1];
            for (int i = 1; i < nVertices + 1; i++) {
                Node node = new Node();
                nodes[i] = node;
            }
        }

        public void addEdge(int vertexA, int vertexB, int weigth) {
            nodes[vertexA].addAdjacent(vertexB);
            if (weigths[vertexA][vertexB] == 0 || weigths[vertexA][vertexB] > weigth) {
                weigths[vertexA][vertexB] = weigth;
                weigths[vertexB][vertexA] = weigth;
            }
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
