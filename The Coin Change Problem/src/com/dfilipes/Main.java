package com.dfilipes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static TreeSet<Integer> coins;
    private static ArrayList<HashSet<ArrayList<Integer>>> combinationsList;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("input"));
        int n = kb.nextInt();
        int m = kb.nextInt();

        coins = new TreeSet<>();
        combinationsList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int coin = kb.nextInt();
            coins.add(Integer.valueOf(coin));
        }

        for (int i = 0; i <= n; i++) {
            getCombinations(i);
        }

        System.out.println(combinationsList.get(n).size());
    }

    public static void getCombinations(int n) {
        Iterator<Integer> iterator = coins.descendingIterator();
        HashSet<ArrayList<Integer>> combinationsSet = new HashSet<>();
        ArrayList<Integer> combination;

        while (iterator.hasNext()) {
            int coin = iterator.next();

            if (n == coin) {
                combination = new ArrayList<>();
                combination.add(coin);

                combinationsSet.add(combination);
            } else if (n > coin) {
                HashSet<ArrayList<Integer>> descendantSolutions = combinationsList.get(n - coin);
                for (ArrayList<Integer> descendant : descendantSolutions) {
                    combination = new ArrayList<>();
                    combination.add(coin);
                    combination.addAll(descendant);
                    Collections.sort(combination);

                    combinationsSet.add(combination);
                }
            }
        }

        combinationsList.add(n, combinationsSet);
    }
}
