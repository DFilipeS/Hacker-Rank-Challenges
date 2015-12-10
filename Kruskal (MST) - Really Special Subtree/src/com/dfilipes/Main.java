package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input"));
        int nVertices = in.nextInt();
        int nEdges = in.nextInt();
        PriorityQueue<Edge> minWeigthQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if (e1.getWeight() < e2.getWeight()) {
                    return -1;
                } else if (e1.getWeight() > e2.getWeight()) {
                    return 1;
                }

                int tieBreakerSum1 = e1.getX() + e1.getWeight() + e1.getY();
                int tieBreakerSum2 = e2.getX() + e2.getWeight() + e2.getY();

                if (tieBreakerSum1 < tieBreakerSum2) return -1;
                return 1;
            }
        });

        for (int i = 0; i < nEdges; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int weigth = in.nextInt();

            minWeigthQueue.add(new Edge(x, y, weigth));
        }

        ArrayList<HashSet<Integer>> forest = new ArrayList<>();
        for (int i = 1; i <= nVertices; i++) {
            HashSet<Integer> tree = new HashSet<>();
            tree.add(i);
            forest.add(tree);
        }

        ArrayList<Edge> minSpanningTree = new ArrayList<>();
        while (!minWeigthQueue.isEmpty() && forest.size() > 1) {
            Edge minWeigthEdge = minWeigthQueue.poll();
            HashSet<Integer> vertex1Tree = null;
            HashSet<Integer> vertex2Tree = null;

            for (HashSet<Integer> tree : forest) {
                if (tree.contains(minWeigthEdge.getX()) && !tree.contains(minWeigthEdge.getY())) {
                    vertex1Tree = tree;
                } else if (!tree.contains(minWeigthEdge.getX()) && tree.contains(minWeigthEdge.getY())) {
                    vertex2Tree = tree;
                }
            }

            if (vertex1Tree != null && vertex2Tree != null) {
                HashSet<Integer> mergedTree = new HashSet<>();
                mergedTree.addAll(vertex1Tree);
                mergedTree.addAll(vertex2Tree);
                forest.remove(vertex1Tree);
                forest.remove(vertex2Tree);
                forest.add(mergedTree);
                minSpanningTree.add(minWeigthEdge);
            }
        }

        int minTotalWeigth = 0;
        for (Edge edge : minSpanningTree) {
            minTotalWeigth += edge.getWeight();
        }

        System.out.println(minTotalWeigth);
    }

    static class Edge {
        private int x;
        private int y;
        private int weight;

        public Edge (int v1, int v2, int weight) {
            this.x = v1;
            this.y = v2;
            this.weight = weight;
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public int getWeight() { return weight; }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ") -> " + weight;
        }
    }
}
